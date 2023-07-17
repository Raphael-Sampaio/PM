package com.example.echo.service;

import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.repository.RedeTotensRepository;
import com.example.echo.repository.TotemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

 class TotemServiceTest {
    @Mock
    private TotemRepository totemRepository;
    @Mock
    private RedeTotensRepository redeTotensRepository;

    private TotemService totemService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        totemService = new TotemService(totemRepository);
    }


    @Test
     void testCadastrarTotem() {
        Totem totem = new Totem();
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        Mockito.when(totemRepository.salvarTotem(totem)).thenReturn(totem);

        Totem result = totemRepository.salvarTotem(totem);

        Assertions.assertEquals(totem, result);

        verify(totemRepository, times(1)).salvarTotem(totem);
    }
    @Test
     void testCadastrarTotem2() {
       Totem totem = new Totem();
       totem.setId(1);

       RedeTotem redeTotem = new RedeTotem();
       redeTotem.setId(totem.getId());
       redeTotem.setTotem(totem);
       redeTotem.setBicicletas(Collections.emptyList());
       redeTotem.setTrancas(Collections.emptyList());

       when(totemRepository.salvarTotem(totem)).thenReturn(totem);
       when(redeTotensRepository.salvarRedeTotens(redeTotem)).thenReturn(redeTotem);

       Totem result = totemService.cadastrarTotem(totem);

       Assertions.assertEquals(totem, result);

       verify(totemRepository, times(1)).salvarTotem(totem);
    }


    @Test
     void testRecuperarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemRepository.findById(1)).thenReturn(totem);

        Totem result = totemRepository.findById(1);

        Assertions.assertEquals(totem, result);

        verify(totemRepository, times(1)).findById(1);
    }

    @Test
     void testDeletarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemRepository.findById(1)).thenReturn(totem);

        Totem result = totem;
                totemRepository.deleteTotem(1);

        Assertions.assertEquals(totem, result);

        verify(totemRepository, times(1)).deleteTotem(1);
    }

    @Test
     void testDeletarTotem2() {
       int idTotem = 1;
       Totem totem = new Totem();
       totem.setId(idTotem);

       when(totemRepository.findById(idTotem)).thenReturn(totem);

       Totem result = totemService.deletarTotem(idTotem);

       Assertions.assertNotNull(result);
       Assertions.assertEquals(totem, result);

       verify(totemRepository, times(1)).deleteTotem(idTotem);
    }

    @Test
     void testAtualizarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totemRepository.findById(1)).thenReturn(totem);
        when(totemRepository.alterarTotem(totem, 1)).thenReturn(totem);

        Totem result = totemRepository.alterarTotem(totem, 1);

        Assertions.assertEquals(totem, result);

        verify(totemRepository, times(1)).alterarTotem(totem, 1);
    }

    @Test
     void testRecuperarTodosTotens() {
        List<Totem> totems = new ArrayList<>();
        totems.add(new Totem());
        totems.add(new Totem());

        when(totemRepository.findAll()).thenReturn(totems);

        List<Totem> result = totemRepository.findAll();

        Assertions.assertEquals(totems, result);

        verify(totemRepository, times(1)).findAll();
    }

    @Test
     void testRecuperarTotem2() {
       int idTotem = 1;
       Totem totem = new Totem();
       totem.setId(idTotem);

       when(totemRepository.findById(idTotem)).thenReturn(totem);

       Totem result = totemService.recuperarTotem(idTotem);

       Assertions.assertNotNull(result);
       Assertions.assertEquals(totem, result);
    }

    @Test
     void testAtualizarTotem2() {
       int idTotem = 1;
       Totem totem = new Totem();
       totem.setId(idTotem);

       when(totemRepository.findById(idTotem)).thenReturn(totem);
       when(totemRepository.alterarTotem(totem, idTotem)).thenReturn(totem);

       Totem result = totemService.atualizarTotem(totem, idTotem);

       Assertions.assertNotNull(result);
       Assertions.assertEquals(totem, result);
    }

    @Test
     void testRecuperarTodosTotens2() {
       List<Totem> totems = new ArrayList<>();
       totems.add(new Totem());
       totems.add(new Totem());
       totems.add(new Totem());

       when(totemRepository.findAll()).thenReturn(totems);

       List<Totem> result = totemService.recuperarTodosTotens();

       Assertions.assertNotNull(result);
       Assertions.assertEquals(totems.size(), result.size());
       Assertions.assertEquals(totems, result);
    }
}