package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Usuario;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
@Slf4j
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado");
        }
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
