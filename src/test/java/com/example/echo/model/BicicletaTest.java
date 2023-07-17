package com.example.echo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BicicletaTest {

    @Test
    void testGetId() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(id);

        Assertions.assertEquals(id, bicicleta.getId());
    }

    @Test
    void testSetId() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(id);

        Assertions.assertEquals(id, bicicleta.getId());
    }

    @Test
    void testGetMarca() {
        String marca = "Brand";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setMarca(marca);

        Assertions.assertEquals(marca, bicicleta.getMarca());
    }

    @Test
    void testSetMarca() {
        String marca = "Brand";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setMarca(marca);

        Assertions.assertEquals(marca, bicicleta.getMarca());
    }

    @Test
    void testGetModelo() {
        String modelo = "Model";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setModelo(modelo);

        Assertions.assertEquals(modelo, bicicleta.getModelo());
    }

    @Test
    void testSetModelo() {
        String modelo = "Model";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setModelo(modelo);

        Assertions.assertEquals(modelo, bicicleta.getModelo());
    }

    @Test
    void testGetAno() {
        String ano = "2022";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setAno(ano);

        Assertions.assertEquals(ano, bicicleta.getAno());
    }

    @Test
    void testSetAno() {
        String ano = "2022";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setAno(ano);

        Assertions.assertEquals(ano, bicicleta.getAno());
    }

    @Test
    void testGetNumero() {
        int numero = 123;
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setNumero(numero);

        Assertions.assertEquals(numero, bicicleta.getNumero());
    }

    @Test
    void testSetNumero() {
        int numero = 123;
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setNumero(numero);

        Assertions.assertEquals(numero, bicicleta.getNumero());
    }

    @Test
    void testGetStatus() {
        String status = "Available";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setStatus(status);

        Assertions.assertEquals(status, bicicleta.getStatus());
    }

    @Test
    void testSetStatus() {
        String status = "Available";
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setStatus(status);

        Assertions.assertEquals(status, bicicleta.getStatus());
    }

}
