package com.wmdigital.menu_springboot.controller;

import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmdigital.menu_springboot.entity.Categoria;
import com.wmdigital.menu_springboot.framework.AbstractController;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;
import com.wmdigital.menu_springboot.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController extends AbstractController<Categoria> {
	
	private final CategoriaService categoriaService;

	protected CategoriaController(CategoriaService categoriaService) {
		super("categoria", Categoria::new);
		
		this.categoriaService = categoriaService;
	}

	@Override
	protected Categoria createEmptyEntity() {
		
		Categoria categoria = new Categoria();
		categoria.setAtivo(true);
		
		
		return categoria;
	}

	@Override
	protected AbstractEntityService<Categoria> getService() {
		
		return categoriaService;
	}
	
	@GetMapping
	@Override
	public ModelAndView listEntitys() {
		
		return super.listEntitys();
	}

}
