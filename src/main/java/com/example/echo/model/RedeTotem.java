package com.example.echo.model;

import java.util.List;

public class RedeTotem {

    int id;
    Totem totem;
    List<Tranca> trancas;
    List<Bicicleta> bicicletas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Totem getTotem() {
        return totem;
    }

    public void setTotem(Totem totem) {
        this.totem = totem;
    }

    public List<Tranca> getTrancas() {
        return trancas;
    }

    public void setTrancas(List<Tranca> trancas) {
        this.trancas = trancas;
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(List<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }
}
