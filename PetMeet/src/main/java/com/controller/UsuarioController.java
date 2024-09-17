package com.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.Usuario;
import com.service.UsuarioService;
import com.dto.UsuarioDto;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

	@PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuarioDto));
    }
	

	@GetMapping("/todos")
    public ResponseEntity<List<Usuario>> buscarUsuarios() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.buscarUsuarios());
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable UUID id) {
		usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
	
}
