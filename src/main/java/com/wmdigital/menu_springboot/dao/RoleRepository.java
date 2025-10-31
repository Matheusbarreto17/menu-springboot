package com.wmdigital.menu_springboot.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmdigital.menu_springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

	Optional<Role> findByName(String name);
}
