package com.anselmopfeifer.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.anselmopfeifer.cobranca.model.StatusTitulo;
import com.anselmopfeifer.cobranca.model.Titulo;
import com.anselmopfeifer.cobranca.repository.Titulos;
import com.anselmopfeifer.cobranca.repository.filter.TituloFiler;

@Service
public class CadastroTituloService {
	
	@Autowired
	private Titulos titulos;

	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato da data inválido");
		}

	}

	public void excluir(Long codigo) {
		titulos.delete(codigo);
	}

	public String receber(Long codigo) {
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
		
	}
	
	public List<Titulos> filtrar (TituloFiler filtro){
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}
	
}