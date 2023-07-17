package com.example.echo.controller;

import com.example.echo.model.Bicicleta;
import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import com.example.echo.service.RedeTotensService;
import com.example.echo.service.TotemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class TotemControllerTest {

    @Mock
    private TotemService totemService;

    @Mock
    private RedeTotensService redeTotensService;

    private TotemController totemController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        totemController = new TotemController(totemService, redeTotensService);
    }

    @Test
    void testCadastrarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemService.cadastrarTotem(totem)).thenReturn(totem);

        ResponseEntity<Totem> response = totemController.cadastrarTotem(totem);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(totem, response.getBody());

        verify(totemService, times(1)).cadastrarTotem(totem);
    }

    @Test
    void testRecuperarTotemPorId_existingTotem() {
        int id = 1;
        Totem totem = new Totem();
        totem.setId(id);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemService.recuperarTotem(id)).thenReturn(totem);

        ResponseEntity<Totem> response = totemController.recuperarTotemPorId(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(totem, response.getBody());

        verify(totemService, times(1)).recuperarTotem(id);
    }

    @Test
    void testRecuperarTotemPorId_nonExistingTotem() {
        int id = 1;

        when(totemService.recuperarTotem(id)).thenReturn(null);

        ResponseEntity<Totem> response = totemController.recuperarTotemPorId(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(totemService, times(1)).recuperarTotem(id);
    }

    @Test
    void testRecuperarTrancasPorIdTotem_existingRedeTotem() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(id);
        redeTotem.setTrancas(new ArrayList<>());

        when(redeTotensService.recuperarRedeTotens(id)).thenReturn(redeTotem);

        ResponseEntity<List<Tranca>> response = totemController.recuperarTrancasPorIdTotem(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(redeTotem.getTrancas(), response.getBody());

        verify(redeTotensService, times(1)).recuperarRedeTotens(id);
    }

    @Test
    void testRecuperarTrancasPorIdTotem_nonExistingRedeTotem() {
        int id = 1;

        when(redeTotensService.recuperarRedeTotens(id)).thenReturn(null);

        ResponseEntity<List<Tranca>> response = totemController.recuperarTrancasPorIdTotem(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(redeTotensService, times(1)).recuperarRedeTotens(id);
    }

    @Test
    void testRecuperarBicicletasPorIdTotem_existingRedeTotem() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(id);
        redeTotem.setBicicletas(new ArrayList<>());

        when(redeTotensService.recuperarRedeTotens(id)).thenReturn(redeTotem);

        ResponseEntity<List<Bicicleta>> response = totemController.recuperarBicicletasPorIdTotem(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(redeTotem.getBicicletas(), response.getBody());

        verify(redeTotensService, times(1)).recuperarRedeTotens(id);
    }

    @Test
    void testRecuperarBicicletasPorIdTotem_nonExistingRedeTotem() {
        int id = 1;

        when(redeTotensService.recuperarRedeTotens(id)).thenReturn(null);

        ResponseEntity<List<Bicicleta>> response = totemController.recuperarBicicletasPorIdTotem(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(redeTotensService, times(1)).recuperarRedeTotens(id);
    }

    @Test
    void testRecuperarTodosTotens() {
        List<Totem> totens = new ArrayList<>();
        totens.add(new Totem());
        totens.add(new Totem());

        when(totemService.recuperarTodosTotens()).thenReturn(totens);

        ResponseEntity<List<Totem>> response = totemController.recuperarTodosTotens();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(totens, response.getBody());

        verify(totemService, times(1)).recuperarTodosTotens();
    }

    @Test
    void testAlterarTotem_existingTotem() {
        int id = 1;
        Totem totem = new Totem();
        totem.setId(id);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemService.atualizarTotem(totem, id)).thenReturn(totem);

        ResponseEntity<Totem> response = totemController.alterarTotem(totem, id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(totem, response.getBody());

        verify(totemService, times(1)).atualizarTotem(totem, id);
    }

    @Test
    void testAlterarTotem_nonExistingTotem() {
        int id = 1;
        Totem totem = new Totem();
        totem.setId(id);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemService.atualizarTotem(totem, id)).thenReturn(null);

        ResponseEntity<Totem> response = totemController.alterarTotem(totem, id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(totemService, times(1)).atualizarTotem(totem, id);
    }

    @Test
    void testDeletarTotem_existingTotem() {
        int id = 1;
        Totem totem = new Totem();
        totem.setId(id);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemService.deletarTotem(id)).thenReturn(totem);

        ResponseEntity<Totem> response = totemController.deletarTotem(id);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(totem, response.getBody());

        verify(totemService, times(1)).deletarTotem(id);
    }

    @Test
    void testDeletarTotem_nonExistingTotem() {
        int id = 1;

        when(totemService.deletarTotem(id)).thenReturn(null);

        ResponseEntity<Totem> response = totemController.deletarTotem(id);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(totemService, times(1)).deletarTotem(id);
    }
}
