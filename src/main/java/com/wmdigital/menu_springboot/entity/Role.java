package com.wmdigital.menu_springboot.entity;

import com.wmdigital.menu_springboot.framework.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseEntity {
	
	@Column(name = "name", nullable = false, unique = true, length = 50)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
