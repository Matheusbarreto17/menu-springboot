package com.wmdigital.menu_springboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.wmdigital.menu_springboot.dao.RoleRepository;
import com.wmdigital.menu_springboot.entity.Role;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;

@Service
public class RoleService extends AbstractEntityService<Role>  {
	
	private final RoleRepository roleDAO;

	protected RoleService(RoleRepository roleDAO) {
		super(Role.class, "role");
		
		this.roleDAO = roleDAO;
	}

	@Override
	protected JpaRepository<Role, UUID> getDao() {
	
		return roleDAO;
	}

	@Override
	protected void validateSave(Role entity) {
		
		
	}

	@Override
	protected void validateEdit(Role entity) {

		
	}

	@Override
	protected void validateDelete(UUID id) {

		
	}

	@Override
	protected String getIdEntity(Role entity) {
	
		return entity.getId().toString();
	}

	@Override
	public List<Role> findAllNew() {
	
		return roleDAO.findAll();
	}

	public Role findByName(String string) {
		return roleDAO.findByName(string).get();
	}
}
