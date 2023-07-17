package com.example.echo.controller.body;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class CadastroBicicletaRedeTest {

    @Test
     void testGetSetIdBicicleta() {
        int idBicicleta = 1;
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        cadastro.setIdBicicleta(idBicicleta);
        assertEquals(idBicicleta, cadastro.getIdBicicleta());
    }

    @Test
     void testGetSetIdTranca() {
        int idTranca = 1;
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        cadastro.setIdTranca(idTranca);
        assertEquals(idTranca, cadastro.getIdTranca());
    }

    @Test
     void testGetSetIdFuncionario() {
        int idFuncionario = 1;
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        cadastro.setIdFuncionario(idFuncionario);
        assertEquals(idFuncionario, cadastro.getIdFuncionario());
    }

    @Test
     void testGetSetStatusAcaoReparador() {
        String statusAcaoReparador = "Em reparo";
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        cadastro.setStatusAcaoReparador(statusAcaoReparador);
        assertEquals(statusAcaoReparador, cadastro.getStatusAcaoReparador());
    }

}
