package com.dasictech.vemaqui.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "TB_ESTABELECIMENTOS")
public class EstabelecimentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String endereco;
	private String descricao;
	private String telefone;
	private String email;
	private String hora_abertura;
	private String hora_fechamento;



	public EstabelecimentoModel() {

	}

	public EstabelecimentoModel(String nome, String endereco, String descricao, String telefone, String email,
			String hora_abertura, String hora_fechamento, String tipoEstabelecimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.hora_abertura = hora_abertura;
		this.hora_fechamento = hora_fechamento;
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	private String tipoEstabelecimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHora_abertura() {
		return hora_abertura;
	}

	public void setHora_abertura(String hora_abertura) {
		this.hora_abertura = hora_abertura;
	}

	public String getHora_fechamento() {
		return hora_fechamento;
	}

	public void setHora_fechamento(String hora_fechamento) {
		this.hora_fechamento = hora_fechamento;
	}


	
	
}
