package com.example.echo.repository;

import com.example.echo.model.Totem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


 class TotemRepositoryTest {
    @Mock
    private Map<Integer, Totem> totens;

    private TotemRepository totemRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        totemRepository = new TotemRepository();
    }


    @Test
     void testSalvarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totens.put(1, totem)).thenReturn(null);

        Totem result = totemRepository.salvarTotem(totem);

        Assertions.assertEquals(totem, result);

    }

    @Test
     void testAlterarTotem() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totens.put(1, totem)).thenReturn(null);

        Totem result = totemRepository.alterarTotem(totem, 1);

        Assertions.assertEquals(totem, result);

    }

    @Test
     void testDeleteTotem() {
        int idTotem = 1;
        Totem totem = new Totem();
        totem.setId(idTotem);

        totemRepository.salvarTotem(totem);

        when(totens.remove(idTotem)).thenReturn(null);

        Totem retorno = totemRepository.findById(idTotem);
        assertEquals(totem, retorno);
        totemRepository.deleteTotem(idTotem);
        assertNull(totemRepository.findById(idTotem));
    }

    @Test
     void testFindById() {
        Totem totem = new Totem();
        totem.setId(1);
        totem.setLocalizacao("Sala 1");
        totem.setDescricao("Descrição do totem");

        when(totens.get(1)).thenReturn(totem);

        Totem result = totemRepository.findById(1);

        Assertions.assertNull(result);

    }

    @Test
     void testFindAll() {
        List<Totem> totemsList = new ArrayList<>();
        totemsList.add(new Totem());
        totemsList.add(new Totem());

        when(totens.values()).thenReturn(totemsList);

        List<Totem> result = totemRepository.findAll();

        Assertions.assertEquals(Collections.emptyList(), result);

    }
}