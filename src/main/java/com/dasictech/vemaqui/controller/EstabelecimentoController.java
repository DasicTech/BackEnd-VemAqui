package com.dasictech.vemaqui.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dasictech.vemaqui.model.EstabelecimentoModel;
import com.dasictech.vemaqui.model.Usuario;
import com.dasictech.vemaqui.repository.EstabelecimentoRepository;
import com.dasictech.vemaqui.service.EstabelecimentoService; 

import jakarta.servlet.http.HttpServletRequest;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/v1/estabelecimentos")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
    private  HttpServletRequest request;
	
	public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
        this.estabelecimentoService = estabelecimentoService;
    }
  
	//Requisição para criar estabelecimento
	  @PostMapping(value = "/form")
	    public EstabelecimentoModel criarEstabelecimento(@RequestBody EstabelecimentoModel estabelecimento) {
			return estabelecimentoService.criarEstabelecimento(estabelecimento);   
	  }
	  
	  
	  // Requisição para pegar todos os estabelecimentos
	   @GetMapping("/vizualizar")
	    public ResponseEntity<List<EstabelecimentoModel>> getTodosEstabelecimentos() {
	        List<EstabelecimentoModel> estabelecimentos = estabelecimentoService.obterTodosEstabelecimentos();
	        return ResponseEntity.ok(estabelecimentos);
	    } 
	   

	  
	   //Requisição para pegar o estabelecimento pelo Id
	   // @GetMapping("/{id}")
	    //public ResponseEntity<EstabelecimentoModel> getEstabelecimentoById(@PathVariable Long id) {
	       //EstabelecimentoModel estabelecimento = estabelecimentoService.obterEstabelecimentoPorId(id);
	      // return ResponseEntity.ok(estabelecimento);
	   // }
	  
	    
	  //Requisição para atualizar o estabelecimento
	    @PutMapping("/atualizar/{id}")
	    public ResponseEntity updateEstabelecimento(@PathVariable Long id, @RequestBody EstabelecimentoModel estabelecimento) {
	        estabelecimentoService.atualizarEstabelecimento(id, estabelecimento);
	        return ResponseEntity.ok().build();
	    }
	  //Requisição para deletar o estabelecimento
	    @DeleteMapping("/deletar/{id}")
	    public void deleteEstabelecimento(@PathVariable Long id) {
	        estabelecimentoService.deletarEstabelecimento(id);
	    }
	    
	   // @GetMapping("{id}")
	    // public ModelAndView detalhesEstabelecimento(@PathVariable Long id) {
	       // Optional<EstabelecimentoModel> estabelecimento = estabelecimentoRepository.findById(id);
	       // ModelAndView modelAndView = new ModelAndView("detalhe"); // Nome da página de detalhes
	        // modelAndView.addObject("estabelecimento", estabelecimento.orElse(null)); // Pode ser null se não encontrar o estabelecimento
	        // return modelAndView;
	    // }
	    
	  /*  @GetMapping("{id}")
	    public ModelAndView mostrarEstabelecimento(@PathVariable Long id, Model model) {
	        Optional<EstabelecimentoModel> estabelecimentoOptional = estabelecimentoRepository.findById(id);
	        ModelAndView modelAndView = new ModelAndView("detalhe");
	        if (estabelecimentoOptional.isPresent()) {
	        	
	            model.addAttribute("estabelecimento", estabelecimentoOptional.get());
	            
	            return modelAndView;
	        }
	        
	        return modelAndView;

	         // Nome da página HTML onde você quer mostrar os valores
	    } */
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<EstabelecimentoModel> obterDetalhesEstabelecimento(@PathVariable Long id) {
	        try {
	            EstabelecimentoModel estabelecimento = estabelecimentoService.obterEstabelecimentoPorId(id);
	            return ResponseEntity.ok(estabelecimento);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}


