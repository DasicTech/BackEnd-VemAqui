package com.dasictech.vemaqui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasictech.vemaqui.model.Usuario;
import com.dasictech.vemaqui.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Salvar o usuario
	public Usuario cadastrar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Boolean login(Usuario usuario) {
		final Usuario usuarioLocalizado =
				this.usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(usuarioLocalizado == null) {
			return false;
		} else {
			return true;
		}
	}
}
