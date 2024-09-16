package com.service;

import org.springframework.stereotype.Service;

import com.dto.UsuarioDto;
import com.model.Usuario;
import com.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}


	@Transactional
    public Usuario cadastrarUsuario(UsuarioDto usuarioDto) {
        Usuario user = new Usuario();
        user.setNome(usuarioDto.nome());
        user.setEmail(usuarioDto.email());
        user.setSenha(usuarioDto.senha());
        user.setPerfil(usuarioDto.perfil());
      

        
        return usuarioRepository.save(user);
    }

}
