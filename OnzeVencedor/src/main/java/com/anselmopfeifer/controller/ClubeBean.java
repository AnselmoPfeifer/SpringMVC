package com.anselmopfeifer.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.anselmopfeifer.entity.Clube;
import com.anselmopfeifer.service.ClubeService;

@ManagedBean(name = "clubeBean")
@ViewScoped
public class ClubeBean extends BaseBean {
	@ManagedProperty("#{clubeService}")
	private ClubeService model;
	private Clube clube;
	private List<Clube> clubes;
	private String nomeClube;
	private boolean editMode;

	public Clube getClube() {
		if (clube == null) {
			clube = new Clube();
		}
		return clube;
	}

	public void salvar() {
		System.out.println("idf clube " + clube.getIdf());
		if (clube.getIdf() == null || clube.getIdf().intValue() == 0) {
			clube = model.createClube(clube);
			clube = new Clube();
			addInfoMessage("Clube criado com sucesso.");
		} else {
			model.updateClube(clube);
			addInfoMessage("Clube alterado com sucesso.");
		}
	}

	public void delete() {
		model.deleteClube(clube);
		if (nomeClube != null && !nomeClube.isEmpty())
			clubes = model.getClubesByName(nomeClube);
		else
			clubes = model.getAllClubes();
	}

	public void create() {
		this.clube = new Clube();
		this.editMode = true;
	}

	public void update() {
		this.editMode = true;
	}

	public void cancel() {
		this.editMode = false;
	}

	public void filtrarClube(AjaxBehaviorEvent event) {
		if (nomeClube != null && !nomeClube.isEmpty()) {
			clubes = model.getClubesByName(nomeClube);
		} else {
			clubes = model.getAllClubes();
		}
	}

	public List<Clube> getClubes() {
		if (clubes == null) {
			clubes = model.getAllClubes();
		}
		return clubes;
	}

}
