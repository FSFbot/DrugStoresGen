package com.example.farmciagen.controller;

import com.example.farmciagen.model.Produtos;
import com.example.farmciagen.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class produtoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produtos> listarProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produtos criarProduto(@Valid @RequestBody Produtos produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produtos atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produtos produtoAtualizado) {
        Optional<Produtos> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produtos produtos = produtoExistente.get();
            produtos.setNomeProduto(produtoAtualizado.getNomeProduto());
            return produtoRepository.save(produtos);
        } else {
            throw new IllegalArgumentException("ID do produto inválido " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
