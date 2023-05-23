package com.example.farmciagen.repository;

import com.example.farmciagen.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepositorio  extends JpaRepository<Categoria, Long> {
    public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}


