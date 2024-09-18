package com.service;

import java.util.List;
import java.util.UUID;

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
       
        
        user.setSenha(usuarioDto.senha());
        user.setNome(usuarioDto.nome());
        user.setEmail(usuarioDto.email());
        user.setPerfil(3);

      

        
        return usuarioRepository.save(user);
    }
	
	public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }
	
	
	@Transactional
    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);;
    }
}
