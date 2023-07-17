package com.example.echo.service;

import com.example.echo.client.ExternoClient;
import com.example.echo.controller.body.CadastroTrancaRede;
import com.example.echo.model.Bicicleta;
import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import com.example.echo.repository.TrancaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

 class TrancaServiceTest {
    @Mock
    private TrancaRepository trancaRepository;
    @Mock
    private TotemService redeTotensService;
    @Mock
    private ExternoClient externoClient;

    private TrancaService trancaService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        trancaService = new TrancaService(trancaRepository, redeTotensService, externoClient);
    }

    @Test
     void testCadastrarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancaRepository.salvarTranca(tranca)).thenReturn(tranca);

        Tranca result = trancaService.cadastrarTranca(tranca);

        Assertions.assertEquals(tranca, result);

        verify(trancaRepository, times(1)).salvarTranca(tranca);
    }

    @Test
     void testRecuperarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancaRepository.findById(1)).thenReturn(tranca);

        Tranca result = trancaService.recuperarTranca(1);

        Assertions.assertEquals(tranca, result);

        verify(trancaRepository, times(1)).findById(1);
    }

    @Test
     void testAtualizarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancaRepository.findById(1)).thenReturn(tranca);
        when(trancaRepository.alterarTranca(tranca, 1)).thenReturn(tranca);

        Tranca result = trancaService.atualizarTranca(tranca, 1);

        Assertions.assertEquals(tranca, result);

        verify(trancaRepository, times(1)).findById(1);
        verify(trancaRepository, times(1)).alterarTranca(tranca, 1);
    }

    @Test
     void testDeletarTranca() {
        Tranca tranca = new Tranca();
        tranca.setId(1);
        tranca.setNumero(123);
        tranca.setLocalizacao("Sala 1");

        when(trancaRepository.findById(1)).thenReturn(tranca);

        Tranca result = trancaService.deletarTranca(1);

        Assertions.assertEquals(tranca, result);

        verify(trancaRepository, times(1)).findById(1);
        verify(trancaRepository, times(1)).deleteTranca(1);
    }

    @Test
     void testRecuperarTodosTotens() {
        List<Tranca> trancasList = new ArrayList<>();
        trancasList.add(new Tranca());
        trancasList.add(new Tranca());

        when(trancaRepository.findAll()).thenReturn(trancasList);

        List<Tranca> result = trancaService.recuperarTodosTotens();

        Assertions.assertEquals(trancasList, result);

        verify(trancaRepository, times(1)).findAll();
    }

    @Test
     void testIntegrarTrancaNaRede() {
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setIdTranca(1);
        cadastro.setIdTotem(2);
        Bicicleta bicicletaRecuperada = new Bicicleta();
        bicicletaRecuperada.setId(1);
        List<Bicicleta> bikes = new ArrayList<>();
        bikes.add(bicicletaRecuperada);
        Tranca trancaRecuperada = new Tranca();
        trancaRecuperada.setId(1);
        List<Tranca> trancas = new ArrayList<>();
        Totem totem = new Totem();
        totem.setTrancas(trancas);
        totem.setId(1);
        RedeTotem redeRecuperada = new RedeTotem();
        redeRecuperada.setTrancas(trancas);
        redeRecuperada.setBicicletas(bikes);
        redeRecuperada.setTotem(totem);
       when(trancaService.recuperarTranca(cadastro.getIdTranca())).thenReturn(trancaRecuperada);
       when(redeTotensService.recuperarTotem(cadastro.getIdTotem())).thenReturn(totem);
       when(redeTotensService.atualizarTotem(totem, totem.getId())).thenReturn(totem);
//       when(externoClient.enviarEmail(anyString())).thenReturn(true);

       boolean result = trancaService.integrarTrancaNaRede(cadastro);

       Assertions.assertTrue(result);
       Assertions.assertTrue(redeRecuperada.getTrancas().contains(trancaRecuperada));
       Assertions.assertEquals("LIVRE", trancaRecuperada.getStatus());
       verify(redeTotensService, times(1)).recuperarTotem(cadastro.getIdTotem());
       verify(redeTotensService, times(1)).atualizarTotem(totem, totem.getId());
//       verify(externoClient, times(1)).enviarEmail(anyString());
    }

    @Test
     void testRetirarTrancaDaRede() {
        CadastroTrancaRede cadastro = new CadastroTrancaRede();
        cadastro.setIdTranca(1);
        cadastro.setIdTotem(2);
        Bicicleta bicicletaRecuperada = new Bicicleta();
        bicicletaRecuperada.setId(1);
        List<Bicicleta> bikes = new ArrayList<>();
        bikes.add(bicicletaRecuperada);
        Tranca trancaRecuperada = new Tranca();
        trancaRecuperada.setId(1);
        List<Tranca> trancas = new ArrayList<>();
        Totem totem = new Totem();
        totem.setId(1);
        trancas.add(trancaRecuperada);
        totem.setTrancas(trancas);
        RedeTotem redeRecuperada = new RedeTotem();
        redeRecuperada.setTrancas(trancas);
        redeRecuperada.setBicicletas(bikes);
        redeRecuperada.setTotem(totem);
       when(trancaService.recuperarTranca(cadastro.getIdTranca())).thenReturn(trancaRecuperada);
       when(redeTotensService.recuperarTotem(cadastro.getIdTotem())).thenReturn(totem);
       when(redeTotensService.atualizarTotem(totem, totem.getId())).thenReturn(totem);
//       when(externoClient.enviarEmail(anyString())).thenReturn(true);

       boolean result = trancaService.retirarTrancaDaRede(cadastro);

       Assertions.assertTrue(result);
       Assertions.assertFalse(redeRecuperada.getTrancas().contains(trancaRecuperada));
       Assertions.assertEquals(cadastro.getStatusAcaoReparador(), trancaRecuperada.getStatus());
       verify(redeTotensService, times(1)).recuperarTotem(cadastro.getIdTotem());
       verify(redeTotensService, times(1)).atualizarTotem(totem, totem.getId());
//       verify(externoClient, times(1)).enviarEmail(anyString());
    }
 }

