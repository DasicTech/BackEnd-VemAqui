package com.dasictech.vemaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.dasictech.vemaqui.model.Usuario;
import com.dasictech.vemaqui.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "ap1/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
    private  HttpServletRequest request;
	
	@PostMapping("/form")
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.cadastrar(usuario);
		
	}

	  @PostMapping(value = "/form", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	   public ResponseEntity<Void> criaUsuario(
	            @RequestParam(value = "nome", required = false) String nome,
	            @RequestParam(value = "email", required = false) String email,
	            @RequestParam(value = "senha", required = false) String senha,
				 @RequestParam(value = "telefone", required = false) String telefone

	    ) {
	        Usuario usuario = new Usuario(nome, email, senha, telefone);
	        this.usuarioService.cadastrar(usuario);

	        String redirectUrl = request.getHeader("origin");

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Location", redirectUrl+"resources/templates/home.html");

	        return new ResponseEntity<>(headers, HttpStatus.FOUND);
	        }

	   @PostMapping(value = "/login/form", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	    public ResponseEntity<Void> login(
	            @RequestParam(value = "email", required = false) String email,
	            @RequestParam(value = "senha", required = false) String senha

	    ) {
	        Usuario usuario = new Usuario(email, senha);
	        final boolean autorizado = usuarioService.login(usuario);

	        String redirectUrl = request.getHeader("origin");

	        HttpHeaders headers = new HttpHeaders();
	        if(autorizado == true){

	            headers.add("Location", redirectUrl+"/home.html");
	        }else{

	        headers.add("Location", redirectUrl+"/erro.html");
	        }
	        return new ResponseEntity<>(headers, HttpStatus.FOUND);

	    }
}
