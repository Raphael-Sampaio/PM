package com.example.echo.repository;

import com.example.echo.model.Tranca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

 class TrancaRepositoryTest {
    @Mock
    private Map<Integer, Tranca> trancas;

    private TrancaRepository trancaRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        trancaRepository = new TrancaRepository();
    }

    @Test
     void testSalvarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancas.put(1, tranca)).thenReturn(null);

        Tranca result = trancaRepository.salvarTranca(tranca);

        Assertions.assertEquals(tranca, result);

    }

    @Test
     void testAlterarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancas.put(1, tranca)).thenReturn(null);

        Tranca result = trancaRepository.alterarTranca(tranca, 1);

        Assertions.assertEquals(tranca, result);

    }

    @Test
     void testDeleteTranca() {
       int idTranca = 1;
       Tranca tranca = new Tranca();
       tranca.setId(idTranca);

       trancaRepository.salvarTranca(tranca);

       when(trancas.remove(idTranca)).thenReturn(null);

       Tranca retorno = trancaRepository.findById(idTranca);
       assertEquals(tranca, retorno);
       trancaRepository.deleteTranca(idTranca);
       assertNull(trancaRepository.findById(idTranca));
    }

    @Test
     void testFindById() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancas.get(1)).thenReturn(tranca);

        Tranca result = trancaRepository.findById(1);

        Assertions.assertNull(result);

    }

    @Test
     void testFindAll() {
        List<Tranca> trancasList = trancas.values().stream().collect(Collectors.toList());

        when(trancas.values()).thenReturn(trancasList);

        List<Tranca> result = trancaRepository.findAll();

        Assertions.assertEquals(trancasList, result);

    }
}