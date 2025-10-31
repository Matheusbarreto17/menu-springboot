package com.wmdigital.menu_springboot.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmdigital.menu_springboot.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	Optional<Usuario> findByUsername(String username);
}
