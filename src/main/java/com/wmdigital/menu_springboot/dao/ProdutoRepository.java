package com.wmdigital.menu_springboot.dao;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wmdigital.menu_springboot.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{

	Optional<Produto> findByUsername(String name);
}
