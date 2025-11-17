package com.wmdigital.menu_springboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.wmdigital.menu_springboot.dao.CategoriaRepository;
import com.wmdigital.menu_springboot.entity.Categoria;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;

@Service
public class CategoriaService extends AbstractEntityService<Categoria> {

	private final CategoriaRepository categoriaDAO;
	
	protected CategoriaService(CategoriaRepository categoriaDAO) {
		super(Categoria.class, "categoria");
		
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	protected JpaRepository<Categoria, UUID> getDao() {
		
		return categoriaDAO;
	}

	@Override
	protected void validateSave(Categoria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateEdit(Categoria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateDelete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getIdEntity(Categoria entity) {
		
		return entity.getId().toString();
	}

	@Override
	public List<Categoria> findAllNew() {
		
		return categoriaDAO.findAll();
	}

}
