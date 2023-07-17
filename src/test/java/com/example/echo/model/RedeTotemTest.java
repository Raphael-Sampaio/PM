package com.example.echo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RedeTotemTest {
    @Test
    void testGetId() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(id);

        Assertions.assertEquals(id, redeTotem.getId());
    }

    @Test
    void testSetId() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(id);

        Assertions.assertEquals(id, redeTotem.getId());
    }

    @Test
    void testGetTotem() {
        Totem totem = new Totem();
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setTotem(totem);

        Assertions.assertEquals(totem, redeTotem.getTotem());
    }

    @Test
    void testSetTotem() {
        Totem totem = new Totem();
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setTotem(totem);

        Assertions.assertEquals(totem, redeTotem.getTotem());
    }

    @Test
    void testGetTrancas() {
        List<Tranca> trancas = new ArrayList<>();
        trancas.add(new Tranca());
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setTrancas(trancas);

        Assertions.assertEquals(trancas, redeTotem.getTrancas());
    }

    @Test
    void testSetTrancas() {
        List<Tranca> trancas = new ArrayList<>();
        trancas.add(new Tranca());
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setTrancas(trancas);

        Assertions.assertEquals(trancas, redeTotem.getTrancas());
    }

    @Test
    void testGetBicicletas() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta());
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setBicicletas(bicicletas);

        Assertions.assertEquals(bicicletas, redeTotem.getBicicletas());
    }

    @Test
    void testSetBicicletas() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta());
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setBicicletas(bicicletas);

        Assertions.assertEquals(bicicletas, redeTotem.getBicicletas());
    }

}
