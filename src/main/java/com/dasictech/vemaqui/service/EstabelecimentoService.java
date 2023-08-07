package com.dasictech.vemaqui.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dasictech.vemaqui.model.EstabelecimentoModel;
import com.dasictech.vemaqui.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	
	// criando atributo do tipo "EstabelecimentoRepository"
	private EstabelecimentoRepository estabelecimentoRepository;
	
	//Construtor
	public EstabelecimentoService(EstabelecimentoRepository estabelecimentoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository; 
	}
	
	//metodo para criar estabelecimentos
	// talvez o "estabelecimento" do parametro seja o nome da tabela
	public EstabelecimentoModel criarEstabelecimento(EstabelecimentoModel estabelecimento) {
		EstabelecimentoModel estabelecimentoSalvo = estabelecimentoRepository.save(estabelecimento);
		return estabelecimentoSalvo;
	}
	
	//metodo para retornar estabelecimento por id
	public EstabelecimentoModel obterEstabelecimentoPorId(Long id) {
		Optional<EstabelecimentoModel> estabelecimentoOptional = estabelecimentoRepository.findById(id);
		//procurar se o estabelecimento existe
		if(estabelecimentoOptional.isPresent()) {
			EstabelecimentoModel estabelecimento = estabelecimentoOptional.get();
			return estabelecimento;
		}else {
			// exception para caso não encontre
			throw new RuntimeException("Estabelecimento não Encontrado.");
		}
		
	}
	
	//metodo para pegar todos os estabelecimentos
	public List<EstabelecimentoModel> obterTodosEstabelecimentos(){
		List<EstabelecimentoModel> estabelecimentos = estabelecimentoRepository.findAll();
		return estabelecimentos;
	}
	
	public void atualizarEstabelecimento(Long id, EstabelecimentoModel estabelecimento) {
		Optional<EstabelecimentoModel> estabelecimentoOptional = estabelecimentoRepository.findById(id);
		if(estabelecimentoOptional.isPresent()) {
			EstabelecimentoModel estabelecimentoAtualizado = estabelecimentoOptional.get();
			//estabelecimentoAtualizado.setId(estabelecimento.getId());
			estabelecimentoAtualizado.setNome(estabelecimento.getNome());
			estabelecimentoAtualizado.setEndereco(estabelecimento.getEndereco());
			estabelecimentoAtualizado.setTipoEstabelecimento(estabelecimento.getTipoEstabelecimento());
			estabelecimentoAtualizado.setTelefone(estabelecimento.getTelefone());
			estabelecimentoRepository.save(estabelecimentoAtualizado);
			System.out.print("Estabelecimento Atualizado");
		} else {
			throw new RuntimeException("Estabelecimento não encontrado.");
		}
	}
	
	public void deletarEstabelecimento(Long id) {
		Optional<EstabelecimentoModel> estabelecimentoOptional = estabelecimentoRepository.findById(id);
		if(estabelecimentoOptional.isPresent()){
			estabelecimentoRepository.delete(estabelecimentoOptional.get());
		} else {
            throw new RuntimeException("Estabelecimento não encontrado.");
        }
	}
}
