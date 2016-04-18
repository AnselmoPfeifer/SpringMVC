package com.anselmopfeifer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atleta implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDF_ATLETA")
	private Integer idf;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "DTA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dtaNascimento;
	@Column(name = "IDF_POSICAO")
	@Enumerated(EnumType.ORDINAL)
	private Posicao posicao;
	@ManyToOne
	@JoinColumn(name = "IDF_CLUBE")
	private Clube clube;

}
