package com.example.echo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class TrancaTest {
    @Test
     void testGetId() {
        Tranca tranca = new Tranca();
        int expectedId = 1;
        tranca.setId(expectedId);
        int actualId = tranca.getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
     void testSetId() {
        Tranca tranca = new Tranca();
        int expectedId = 1;
        tranca.setId(expectedId);
        int actualId = tranca.getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
     void testGetBicicleta() {
        Tranca tranca = new Tranca();
        Bicicleta expectedBicicleta = new Bicicleta();
        tranca.setBicicleta(expectedBicicleta);
        Bicicleta actualBicicleta = tranca.getBicicleta();
        Assertions.assertEquals(expectedBicicleta, actualBicicleta);
    }

    @Test
     void testSetBicicleta() {
        Tranca tranca = new Tranca();
        Bicicleta expectedBicicleta = new Bicicleta();
        tranca.setBicicleta(expectedBicicleta);
        Bicicleta actualBicicleta = tranca.getBicicleta();
        Assertions.assertEquals(expectedBicicleta, actualBicicleta);
    }

    @Test
     void testGetNumero() {
        Tranca tranca = new Tranca();
        int expectedNumero = 123;
        tranca.setNumero(expectedNumero);
        int actualNumero = tranca.getNumero();
        Assertions.assertEquals(expectedNumero, actualNumero);
    }

    @Test
     void testSetNumero() {
        Tranca tranca = new Tranca();
        int expectedNumero = 123;
        tranca.setNumero(expectedNumero);
        int actualNumero = tranca.getNumero();
        Assertions.assertEquals(expectedNumero, actualNumero);
    }

    @Test
     void testGetLocalizacao() {
        Tranca tranca = new Tranca();
        String expectedLocalizacao = "Sala 1";
        tranca.setLocalizacao(expectedLocalizacao);
        String actualLocalizacao = tranca.getLocalizacao();
        Assertions.assertEquals(expectedLocalizacao, actualLocalizacao);
    }

    @Test
     void testSetLocalizacao() {
        Tranca tranca = new Tranca();
        String expectedLocalizacao = "Sala 1";
        tranca.setLocalizacao(expectedLocalizacao);
        String actualLocalizacao = tranca.getLocalizacao();
        Assertions.assertEquals(expectedLocalizacao, actualLocalizacao);
    }

    @Test
     void testGetAnoDeFabricacao() {
        Tranca tranca = new Tranca();
        String expectedAnoDeFabricacao = "2021";
        tranca.setAnoDeFabricacao(expectedAnoDeFabricacao);
        String actualAnoDeFabricacao = tranca.getAnoDeFabricacao();
        Assertions.assertEquals(expectedAnoDeFabricacao, actualAnoDeFabricacao);
    }

    @Test
     void testSetAnoDeFabricacao() {
        Tranca tranca = new Tranca();
        String expectedAnoDeFabricacao = "2021";
        tranca.setAnoDeFabricacao(expectedAnoDeFabricacao);
        String actualAnoDeFabricacao = tranca.getAnoDeFabricacao();
        Assertions.assertEquals(expectedAnoDeFabricacao, actualAnoDeFabricacao);
    }
    @Test
     void testGetModelo() {
        Tranca tranca = new Tranca();
        String expectedModelo = "Modelo A";
        tranca.setModelo(expectedModelo);
        String actualModelo = tranca.getModelo();
        Assertions.assertEquals(expectedModelo, actualModelo);
    }

    @Test
     void testSetModelo() {
        Tranca tranca = new Tranca();
        String expectedModelo = "Modelo A";
        tranca.setModelo(expectedModelo);
        String actualModelo = tranca.getModelo();
        Assertions.assertEquals(expectedModelo, actualModelo);
    }

    @Test
     void testGetStatus() {
        Tranca tranca = new Tranca();
        String expectedStatus = "Ativa";
        tranca.setStatus(expectedStatus);
        String actualStatus = tranca.getStatus();
        Assertions.assertEquals(expectedStatus, actualStatus);
    }

    @Test
     void testSetStatus() {
        Tranca tranca = new Tranca();
        String expectedStatus = "Ativa";
        tranca.setStatus(expectedStatus);
        String actualStatus = tranca.getStatus();
        Assertions.assertEquals(expectedStatus, actualStatus);
    }
}
