package com.example.farmciagen.controller;

import com.example.farmciagen.model.Categoria;
import com.example.farmciagen.repository.CategoriaRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CategoriaController {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepositorio.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoriaPorId(@PathVariable Long id){
        return categoriaRepositorio.findById(id);
    }
    @PostMapping
    public Categoria criarCategoria(@Valid @RequestBody Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }
    @PutMapping
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
        Optional<Categoria> categoriaExistente = categoriaRepositorio.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNome(categoriaAtualizada.getNome());
            return categoriaRepositorio.save(categoria);
        } else {
            throw new IllegalArgumentException("Id da categoria esta invalido: " + id);
        }
    }
    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaRepositorio.deleteById(id);
    }
}

