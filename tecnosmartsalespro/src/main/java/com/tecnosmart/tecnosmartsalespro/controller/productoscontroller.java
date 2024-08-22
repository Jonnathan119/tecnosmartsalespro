package com.tecnosmart.tecnosmartsalespro.controller;

import com.tecnosmart.tecnosmartsalespro.model.productos;
import com.tecnosmart.tecnosmartsalespro.service.productoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class productoscontroller {

    @Autowired
    private productoservice productoService;

    @GetMapping
    public List<productos> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<productos> obtenerProductoPorId(@PathVariable Long id) {
        Optional<productos> productos = productoService.obtenerProductoPorId(id);
        return productos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public productos guardarProducto(@RequestBody productos productos) {
        return productoService.guardarProducto(productos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}