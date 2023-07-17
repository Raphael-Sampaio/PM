package com.example.echo.controller.body;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class CadastroTrancaRedeTest {

    @Test
     void testGetSetIdTotem() {
        int idTotem = 1;
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setIdTotem(idTotem);
        assertEquals(idTotem, cadastro.getIdTotem());
    }

    @Test
     void testGetSetIdTranca() {
        int idTranca = 1;
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setIdTranca(idTranca);
        assertEquals(idTranca, cadastro.getIdTranca());
    }

    @Test
     void testGetSetIdFuncionario() {
        int idFuncionario = 1;
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setIdFuncionario(idFuncionario);
        assertEquals(idFuncionario, cadastro.getIdFuncionario());
    }

    @Test
     void testGetSetStatusAcaoReparador() {
        String statusAcaoReparador = "Em reparo";
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setStatusAcaoReparador(statusAcaoReparador);
        assertEquals(statusAcaoReparador, cadastro.getStatusAcaoReparador());
    }

}
