package com.example.echo.service;

import com.example.echo.client.ExternoClient;
import com.example.echo.controller.body.CadastroBicicletaRede;
import com.example.echo.model.Bicicleta;
import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import com.example.echo.repository.BicicletaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 class BicicletaServiceTest {

    @Mock
    private BicicletaService service;
    private BicicletaRepository repository;
    private TrancaService trancaService;
    private TotemService redeTotensService;
    private ExternoClient externoClient;

    @BeforeEach
     void setUp() {
        repository = mock(BicicletaRepository.class);
        trancaService = mock(TrancaService.class);
        redeTotensService = mock(TotemService.class);
        externoClient = mock(ExternoClient.class);
        service = new BicicletaService(repository, trancaService, redeTotensService, externoClient);
    }

    @Test
     void testCadastrarBicicleta() {
        Bicicleta bicicleta = new Bicicleta();
        when(repository.salvarBicicleta(bicicleta)).thenReturn(bicicleta);

        Bicicleta savedBicicleta = service.cadastrarBicicleta(bicicleta);

        assertNotNull(savedBicicleta);
        assertEquals(bicicleta, savedBicicleta);
        verify(repository, times(1)).salvarBicicleta(bicicleta);
    }

    @Test
     void testRecuperarBicicleta() {
        int idBicicleta = 1;
        Bicicleta bicicleta = new Bicicleta();
        when(repository.findById(idBicicleta)).thenReturn(bicicleta);

        Bicicleta foundBicicleta = service.recuperarBicicleta(idBicicleta);

        assertNotNull(foundBicicleta);
        assertEquals(bicicleta, foundBicicleta);
        verify(repository, times(1)).findById(idBicicleta);
    }

    @Test
     void testAtualizarBicicleta() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        Bicicleta bicicletaRecuperada = new Bicicleta();
        when(repository.findById(id)).thenReturn(bicicletaRecuperada);
        when(repository.alterarBicicleta(bicicleta, id)).thenReturn(bicicleta);

        Bicicleta updatedBicicleta = service.atualizarBicicleta(bicicleta, id);

        assertNotNull(updatedBicicleta);
        assertEquals(bicicleta, updatedBicicleta);
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).alterarBicicleta(bicicleta, id);
    }

    @Test
     void testAtualizarStatusBicicleta() {
        int id = 1;
        String status = "DISPONIVEL";
        Bicicleta bicicletaRecuperada = new Bicicleta();
        when(repository.findById(id)).thenReturn(bicicletaRecuperada);
        when(repository.alterarBicicleta(bicicletaRecuperada, id)).thenReturn(bicicletaRecuperada);

        Bicicleta updatedBicicleta = service.atualizarStatusBicicleta(id, status);

        assertNotNull(updatedBicicleta);
        assertEquals(status, updatedBicicleta.getStatus());
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).alterarBicicleta(bicicletaRecuperada, id);
    }

    @Test
     void testDeletarBicicleta() {
        int idBicicleta = 1;
        Bicicleta bicicletaRecuperada = new Bicicleta();
        when(repository.findById(idBicicleta)).thenReturn(bicicletaRecuperada);

        Bicicleta deletedBicicleta = service.deletarBicicleta(idBicicleta);

        assertNotNull(deletedBicicleta);
        assertEquals(bicicletaRecuperada, deletedBicicleta);
        verify(repository, times(1)).findById(idBicicleta);
        verify(repository, times(1)).deleteBicicleta(idBicicleta);
    }

    @Test
     void testIncluirBicicletaRede() {
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        Bicicleta bicicletaRecuperada = new Bicicleta();
        bicicletaRecuperada.setId(1);
        List<Bicicleta> bikes = new ArrayList<>();
        bikes.add(bicicletaRecuperada);
        Tranca trancaRecuperada = new Tranca();
        trancaRecuperada.setId(1);
        Totem totem = new Totem();
        totem.setId(1);
        RedeTotem redeRecuperada = new RedeTotem();
        redeRecuperada.setBicicletas(bikes);
        redeRecuperada.setTotem(totem);

        when(service.recuperarBicicleta(cadastro.getIdBicicleta())).thenReturn(bicicletaRecuperada);
        when(trancaService.recuperarTranca(cadastro.getIdTranca())).thenReturn(trancaRecuperada);
        when(redeTotensService.recuperarTotemPorTranca(cadastro.getIdTranca())).thenReturn(totem);
        when(redeTotensService.atualizarTotem(totem, totem.getId())).thenReturn(totem);
        when(trancaService.atualizarTranca(trancaRecuperada, trancaRecuperada.getId())).thenReturn(trancaRecuperada);
//        when(externoClient.enviarEmail(anyString())).thenReturn(true);

        boolean result = service.incluirBicicletaRede(cadastro);

        assertTrue(result);
        assertEquals("DISPONIVEL", bicicletaRecuperada.getStatus());
        verify(trancaService, times(1)).recuperarTranca(cadastro.getIdTranca());
        verify(redeTotensService, times(1)).recuperarTotemPorTranca(cadastro.getIdTranca());
        verify(redeTotensService, times(1)).atualizarTotem(totem, totem.getId());
        verify(trancaService, times(1)).atualizarTranca(trancaRecuperada, trancaRecuperada.getId());
        verify(trancaService, times(1)).trancarTranca(trancaRecuperada);
//        verify(externoClient, times(1)).enviarEmail(anyString());
    }

    @Test
     void testRetirarBicicletaDaRede() {
        CadastroBicicletaRede cadastro = new CadastroBicicletaRede();
        Bicicleta bicicletaRecuperada = new Bicicleta();
        bicicletaRecuperada.setId(1);
        List<Bicicleta> bikes = new ArrayList<>();
        bikes.add(bicicletaRecuperada);
        Tranca trancaRecuperada = new Tranca();
        trancaRecuperada.setId(1);
        Totem totem = new Totem();
        totem.setId(1);
        RedeTotem redeRecuperada = new RedeTotem();
        redeRecuperada.setBicicletas(bikes);
        redeRecuperada.setTotem(totem);

        when(service.recuperarBicicleta(cadastro.getIdBicicleta())).thenReturn(bicicletaRecuperada);
        when(trancaService.recuperarTranca(cadastro.getIdTranca())).thenReturn(trancaRecuperada);
        when(redeTotensService.recuperarTotemPorTranca(cadastro.getIdTranca())).thenReturn(totem);
        when(redeTotensService.atualizarTotem(totem, totem.getId())).thenReturn(totem);
        when(trancaService.atualizarTranca(trancaRecuperada, trancaRecuperada.getId())).thenReturn(trancaRecuperada);
//        when(externoClient.enviarEmail(anyString())).thenReturn(true);

        boolean result = service.retirarBicicletaDaRede(cadastro);

        assertTrue(result);
        assertNull(trancaRecuperada.getBicicleta());
        assertEquals(bicicletaRecuperada.getStatus(), cadastro.getStatusAcaoReparador());
        verify(trancaService, times(1)).recuperarTranca(cadastro.getIdTranca());
        verify(redeTotensService, times(1)).recuperarTotemPorTranca(cadastro.getIdTranca());
        verify(redeTotensService, times(1)).atualizarTotem(totem, totem.getId());
        verify(trancaService, times(1)).atualizarTranca(trancaRecuperada, trancaRecuperada.getId());
        verify(trancaService, times(1)).destrancarTranca(trancaRecuperada);
//        verify(externoClient, times(1)).enviarEmail(anyString());
    }

    @Test
     void testRecuperarTodosTotens() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        when(repository.findAll()).thenReturn(bicicletas);

        List<Bicicleta> retrievedBicicletas = service.recuperarTodosTotens();

        assertNotNull(retrievedBicicletas);
        assertEquals(bicicletas, retrievedBicicletas);
        verify(repository, times(1)).findAll();
    }
}

