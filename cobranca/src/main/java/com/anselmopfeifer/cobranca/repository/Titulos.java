package com.anselmopfeifer.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anselmopfeifer.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {
	public List<Titulos> findByDescricaoContaining(String descricao);
	
}
