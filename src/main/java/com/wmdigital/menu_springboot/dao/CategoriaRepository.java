package com.wmdigital.menu_springboot.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmdigital.menu_springboot.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

	Optional<Categoria> findByUsername(String name);
}
