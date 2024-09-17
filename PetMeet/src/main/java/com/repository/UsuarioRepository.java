package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	UserDetails findByEmail(String email);

}
