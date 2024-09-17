package com.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.model.Usuario;
import com.service.TokenService;
import com.service.UsuarioService;
import com.dto.AuthDto;
import com.dto.UsuarioDto;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;



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
	
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthDto data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
		var auth = this.authManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario)auth.getPrincipal());
		System.out.println(usernamePassword);
		return ResponseEntity.ok(token);
	}
}
