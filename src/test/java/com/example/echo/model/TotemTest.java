package com.example.echo.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TotemTest {
    @Test
    void testGetId() {
        Totem totem = new Totem();
        int expectedId = 123;
        totem.setId(expectedId);
        int actualId = totem.getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    void testSetId() {
        Totem totem = new Totem();
        int expectedId = 123;
        totem.setId(expectedId);
        int actualId = totem.getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    void testGetLocalizacao() {
        Totem totem = new Totem();
        String expectedLocalizacao = "Sala 1";
        totem.setLocalizacao(expectedLocalizacao);
        String actualLocalizacao = totem.getLocalizacao();
        Assertions.assertEquals(expectedLocalizacao, actualLocalizacao);
    }

    @Test
    void testSetLocalizacao() {
        Totem totem = new Totem();
        String expectedLocalizacao = "Sala 1";
        totem.setLocalizacao(expectedLocalizacao);
        String actualLocalizacao = totem.getLocalizacao();
        Assertions.assertEquals(expectedLocalizacao, actualLocalizacao);
    }

    @Test
    void testGetDescricao() {
        Totem totem = new Totem();
        String expectedDescricao = "Descrição do totem";
        totem.setDescricao(expectedDescricao);
        String actualDescricao = totem.getDescricao();
        Assertions.assertEquals(expectedDescricao, actualDescricao);
    }

    @Test
    void testSetDescricao() {
        Totem totem = new Totem();
        String expectedDescricao = "Descrição do totem";
        totem.setDescricao(expectedDescricao);
        String actualDescricao = totem.getDescricao();
        Assertions.assertEquals(expectedDescricao, actualDescricao);
    }
}