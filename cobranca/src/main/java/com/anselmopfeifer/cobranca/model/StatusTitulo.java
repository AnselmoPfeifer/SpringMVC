package com.anselmopfeifer.cobranca.model;
/**
 * Created by anselmo on 21/04/16.
 */
public enum StatusTitulo {
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusTitulo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

