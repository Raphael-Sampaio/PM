package com.example.echo.controller;

import com.example.echo.model.Tranca;
import com.example.echo.service.TrancaService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class CiclistaControllerTest {

    private TrancaController trancaController;

    @Mock
    private TrancaService trancaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        trancaController = new TrancaController(trancaService);
    }
    @Test
    public void testCadastrarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setLocalizacao("Sala 1");

        when(trancaService.cadastrarTranca(tranca)).thenReturn(tranca);

        ResponseEntity<Tranca> response = trancaController.cadastrarTranca(tranca);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals(tranca, response.getBody());

        verify(trancaService, times(1)).cadastrarTranca(tranca);
    }
}

