package com.wmdigital.menu_springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wmdigital.menu_springboot.dao.RoleRepository;
import com.wmdigital.menu_springboot.dao.UsuarioRepository;
import com.wmdigital.menu_springboot.entity.Usuario;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService extends AbstractEntityService<Usuario> {

	private final UsuarioRepository usuarioDAO;
	
	private final RoleRepository roleDAO;
	
	private final PasswordEncoder encoder;
	
	protected UsuarioService(UsuarioRepository usuarioDAO, RoleRepository roleDAO, PasswordEncoder encoder) {
		super(Usuario.class, "usuario");
	
		this.usuarioDAO = usuarioDAO;
		this.roleDAO = roleDAO;
		this.encoder = encoder;
	}

	@Override
	protected JpaRepository<Usuario, UUID> getDao() {
		
		return usuarioDAO;
	}

	@Override
	protected String getIdEntity(Usuario entity) {
		
		return entity.getId().toString();
	}

	@Override
	public List<Usuario> findAllNew() {
		
		return usuarioDAO.findAll();
	}

	
	public Usuario saveWithPasswordHandling(Usuario u) {
	        if (u.getPassword() != null && !u.getPassword().startsWith("$2")) {
	            u.setPassword(encoder.encode(u.getPassword()));
	        }
	        return usuarioDAO.save(u);
	    }
	
	@Override
	public Usuario save(Usuario u) {

	    if (u.getRole() == null || u.getRole().getId() == null) {
	        throw new IllegalArgumentException("Selecione uma role.");
	    }
	    u.setRole(roleDAO.getReferenceById(u.getRole().getId()));

	    // (2) Senha
	    if (u.getId() != null) {
	        Usuario db = usuarioDAO.findById(u.getId())
	                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

	        if (u.getPassword() == null || u.getPassword().isBlank()) {
	            u.setPassword(db.getPassword()); // mantém hash antigo
	        } else if (!isEncoded(u.getPassword())) {
	            u.setPassword(encoder.encode(u.getPassword()));
	        }
	    } else {
	        if (u.getPassword() == null || u.getPassword().isBlank()) {
	            throw new IllegalArgumentException("Senha obrigatória.");
	        }
	        if (!isEncoded(u.getPassword())) {
	            u.setPassword(encoder.encode(u.getPassword()));
	        }
	    }

	    // (3) Opcional: garantir ativo ao criar
	    if (u.getId() == null) {
	        u.setAtivo(Boolean.TRUE);
	    }
		  
	        return usuarioDAO.save(u);
	}
	
	
	private boolean isEncoded(String p) {
        // cobre BCrypt puro ($2a/$2b/$2y) e Delegating ("{bcrypt}")
        return p.startsWith("{bcrypt}") || p.startsWith("$2a$") || p.startsWith("$2b$") || p.startsWith("$2y$");
    }
	
	public Optional<Usuario>  findByUserName(String username) {
		
		Optional<Usuario> usu = usuarioDAO.findByUsername(username);
		
		return usu;
	}
	
	@Override
	protected void validateSave(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateEdit(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateDelete(UUID id) {
		// TODO Auto-generated method stub
		
	}
}
