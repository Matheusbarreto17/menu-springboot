package com.wmdigital.menu_springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmdigital.menu_springboot.entity.Role;
import com.wmdigital.menu_springboot.entity.Usuario;
import com.wmdigital.menu_springboot.framework.AbstractController;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;
import com.wmdigital.menu_springboot.service.RoleService;
import com.wmdigital.menu_springboot.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends AbstractController<Usuario> {
	
	private final UsuarioService usuarioService;
	private final RoleService roleService;

	protected UsuarioController(UsuarioService usuarioService, RoleService roleService) {
		super("usuario", Usuario :: new);
		
		this.usuarioService = usuarioService;
		this.roleService = roleService;
	}

	@Override
	protected Usuario createEmptyEntity() {
		
		Usuario user = new Usuario();
		user.setAtivo(true);
		user.setRole(new Role());

		return user;
	}

	@Override
	protected AbstractEntityService<Usuario> getService() {
		
		return usuarioService;
	}

	@GetMapping
	@Override
	public ModelAndView listEntitys() {
	
		return super.listEntitys();
	}
	
	@Override
	protected void preloadFormData(ModelMap modelMap) {
		
		modelMap.addAttribute("roles", roleService.findAll());
		
	}
}
