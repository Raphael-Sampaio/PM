package com.example.echo.model;

import java.util.List;

public class Totem {
    private int id;
    private String localizacao;
    private String descricao;

    public List<Tranca> getTrancas() {
        return trancas;
    }

    public void setTrancas(List<Tranca> trancas) {
        this.trancas = trancas;
    }

    private List<Tranca> trancas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
