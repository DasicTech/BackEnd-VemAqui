package com.dasictech.vemaqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dasictech.vemaqui.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByEmailAndSenha(String email, String senha);
}
