package com.anselmopfeifer.cobranca.controller;

import javax.annotation.ManagedBean;

import org.springframework.context.annotation.Scope;

@ManagedBean
@Scope(value="session")
public class Nome {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
