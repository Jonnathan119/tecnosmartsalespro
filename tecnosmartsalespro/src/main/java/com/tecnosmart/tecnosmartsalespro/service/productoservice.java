package com.tecnosmart.tecnosmartsalespro.service;

import com.tecnosmart.tecnosmartsalespro.model.productos;
import com.tecnosmart.tecnosmartsalespro.repository.productosrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productoservice {

    @Autowired
    private productosrepository productoRepository;

    public List<productos> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Optional<productos> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public productos guardarProducto(productos producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}