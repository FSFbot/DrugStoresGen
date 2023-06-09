package com.example.farmciagen.repository;


import com.example.farmciagen.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository  extends JpaRepository<Produtos,Long> {
    public List<Produtos> findAllByNomeProdutoContainingIgnoreCase(@Param("nomeProduto") String nomeProduto);
}


