package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Producto;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.ProductoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay productos disponibles"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
})
@RestController
@RequestMapping("/api/v1/productos")
@Slf4j
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping()
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto productoGuardado = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isEmpty()) {
            throw new NotFoundException("No se encontró el producto a eliminar.");
        }
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
