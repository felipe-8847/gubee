package com.projetojavagubee.gubee.controllers;


import com.projetojavagubee.gubee.entity.Product;
import com.projetojavagubee.gubee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> buscarTodos() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        return productRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> cadastrarProduto(@Valid @RequestBody Product produto1) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(produto1));
    }

    @PutMapping
    public ResponseEntity<Product> atualizarProduto(@Valid @RequestBody Product produto1) {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(produto1));
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@Valid @PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
