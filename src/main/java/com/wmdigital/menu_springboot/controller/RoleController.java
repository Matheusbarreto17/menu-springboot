package com.wmdigital.menu_springboot.controller;

import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmdigital.menu_springboot.entity.Role;
import com.wmdigital.menu_springboot.framework.AbstractController;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;
import com.wmdigital.menu_springboot.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController extends AbstractController<Role> {
	
	private final RoleService roleService;

	protected RoleController(RoleService roleService) {
		super("role", Role ::new);
		
		this.roleService = roleService;
	}

	@Override
	protected Role createEmptyEntity() {
		
		Role role = new Role();
		role.setAtivo(true);
		
		return role;
	}

	@Override
	protected AbstractEntityService<Role> getService() {
		
		return roleService;
	}
	
	@GetMapping
	@Override
	public ModelAndView listEntitys() {
		
		return super.listEntitys();
	}
}
