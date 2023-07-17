package com.example.echo.repository;

import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class RedeTotensRepositoryTest {

    private RedeTotensRepository repository;

    @BeforeEach
     void setUp() {
        repository = new RedeTotensRepository();
    }
    @Test
    void testFindAll() {
       RedeTotem redeTotem1 = new RedeTotem();
       RedeTotem redeTotem2 = new RedeTotem();
       Totem totem = new Totem();
       totem.setId(1);
       redeTotem1.setTotem(totem);
       Totem totem2 = new Totem();
       totem.setId(2);
       redeTotem2.setTotem(totem2);
       repository.salvarRedeTotens(redeTotem1);
       repository.salvarRedeTotens(redeTotem2);
       List<RedeTotem> redesTotens = repository.findAll();
       assertTrue(redesTotens.contains(redeTotem1));
       assertTrue(redesTotens.contains(redeTotem2));
    }

    @Test
     void testSalvarRedeTotens() {
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(1);
        Totem totem = new Totem();
        totem.setId(1);
        redeTotem.setTotem(totem);
        RedeTotem savedRedeTotem = repository.salvarRedeTotens(redeTotem);
        assertEquals(redeTotem, savedRedeTotem);
    }

    @Test
     void testAlterarRedeTotens() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        RedeTotem updatedRedeTotem = repository.alterarRedeTotens(redeTotem, id);
        assertEquals(id, updatedRedeTotem.getId());
        assertEquals(redeTotem, updatedRedeTotem);
    }

    @Test
     void testDeleteRedeTotens() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        redeTotem.setId(1);
        Totem totem = new Totem();
        totem.setId(1);
        redeTotem.setTotem(totem);
        repository.salvarRedeTotens(redeTotem);
        repository.deleteRedeTotens(id);
        assertNull(repository.findById(id));
    }

    @Test
     void testFindById() {
        int id = 1;
        RedeTotem redeTotem = new RedeTotem();
        Totem totem = new Totem();
        totem.setId(1);
        redeTotem.setTotem(totem);
        repository.salvarRedeTotens(redeTotem);
        RedeTotem foundRedeTotem = repository.findById(id);
        assertNotNull(foundRedeTotem);
        assertEquals(id, foundRedeTotem.getId());
        assertEquals(redeTotem, foundRedeTotem);
    }

    @Test
     void testFindByTranca() {
        int idTranca = 1;
        RedeTotem redeTotem = new RedeTotem();
        Tranca trancav = new Tranca();
        List<Tranca> trancas = new ArrayList<>();
        trancas.add(trancav);
        trancav.setId(1);
        redeTotem.setTrancas(trancas);
        Totem totem = new Totem();
        totem.setId(1);
        redeTotem.setTotem(totem);
        repository.salvarRedeTotens(redeTotem);
        RedeTotem foundRedeTotem = repository.findByTranca(idTranca);
        assertNotNull(foundRedeTotem);
        assertTrue(foundRedeTotem.getTrancas().stream().anyMatch(tranca -> tranca.getId() == idTranca));
    }



}
