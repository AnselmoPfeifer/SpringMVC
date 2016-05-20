package com.anselmopfeifer.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.anselmopfeifer.cobranca.model.Titulo;
import com.anselmopfeifer.cobranca.repository.Titulos;

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

}
