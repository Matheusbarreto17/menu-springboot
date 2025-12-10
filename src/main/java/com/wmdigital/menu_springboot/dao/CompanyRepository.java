package com.wmdigital.menu_springboot.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmdigital.menu_springboot.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID>{

}
