package com.example.echo.service;

import com.example.echo.model.RedeTotem;
import com.example.echo.repository.RedeTotensRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 class RedeTotensServiceTest {

    private RedeTotensService service;
    private RedeTotensRepository repository;

    @BeforeEach
     void setUp() {
        repository = mock(RedeTotensRepository.class);
        service = new RedeTotensService(repository);
    }

    @Test
     void testCadastrarRedeTotens() {
        RedeTotem redeTotem = new RedeTotem();
        when(repository.salvarRedeTotens(redeTotem)).thenReturn(redeTotem);

        RedeTotem savedRedeTotem = service.cadastrarRedeTotens(redeTotem);

        assertNotNull(savedRedeTotem);
        assertEquals(redeTotem, savedRedeTotem);
        verify(repository, times(1)).salvarRedeTotens(redeTotem);
    }

    @Test
     void testRecuperarRedeTotens() {
        int idRedeTotens = 1;
        RedeTotem redeTotem = new RedeTotem();
        when(repository.findById(idRedeTotens)).thenReturn(redeTotem);

        RedeTotem foundRedeTotem = service.recuperarRedeTotens(idRedeTotens);

        assertNotNull(foundRedeTotem);
        assertEquals(redeTotem, foundRedeTotem);
        verify(repository, times(1)).findById(idRedeTotens);
    }

    @Test
     void testRecuperarRedeTotensPorTranca() {
        int idTranca = 1;
        RedeTotem redeTotem = new RedeTotem();
        when(repository.findByTranca(idTranca)).thenReturn(redeTotem);

        RedeTotem foundRedeTotem = service.recuperarRedeTotensPorTranca(idTranca);

        assertNotNull(foundRedeTotem);
        assertEquals(redeTotem, foundRedeTotem);
        verify(repository, times(1)).findByTranca(idTranca);
    }

    @Test
     void testAtualizarRedeTotens() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        RedeTotem redeTotemRecuperado = new RedeTotem();
        when(repository.findById(id)).thenReturn(redeTotemRecuperado);
        when(repository.alterarRedeTotens(redeTotem, id)).thenReturn(redeTotem);

        RedeTotem updatedRedeTotem = service.atualizarRedeTotens(redeTotem, id);

        assertNotNull(updatedRedeTotem);
        assertEquals(redeTotem, updatedRedeTotem);
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).alterarRedeTotens(redeTotem, id);
    }

    @Test
     void testDeletarRedeTotens() {
        int idRedeTotens = 1;
        RedeTotem redeTotemRecuperado = new RedeTotem();
        when(repository.findById(idRedeTotens)).thenReturn(redeTotemRecuperado);

        RedeTotem deletedRedeTotem = service.deletarRedeTotens(idRedeTotens);

        assertNotNull(deletedRedeTotem);
        assertEquals(redeTotemRecuperado, deletedRedeTotem);
        verify(repository, times(1)).findById(idRedeTotens);
        verify(repository, times(1)).deleteRedeTotens(idRedeTotens);
    }

    @Test
     void testRecuperarTodosTotens() {
        List<RedeTotem> redesTotens = Arrays.asList(new RedeTotem(), new RedeTotem());
        when(repository.findAll()).thenReturn(redesTotens);

        List<RedeTotem> foundRedesTotens = service.recuperarTodosTotens();

        assertNotNull(foundRedesTotens);
        assertEquals(redesTotens.size(), foundRedesTotens.size());
        assertEquals(redesTotens, foundRedesTotens);
        verify(repository, times(1)).findAll();
    }
}
