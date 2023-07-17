package com.example.echo.controller;

import com.example.echo.controller.body.CadastroTrancaRede;
import com.example.echo.model.Bicicleta;
import com.example.echo.model.Tranca;
import com.example.echo.service.TrancaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class TrancaControllerTest {

   private TrancaController trancaController;
   private TrancaService trancaService;

   @BeforeEach
   void setUp() {
      trancaService = Mockito.mock(TrancaService.class);
      trancaController = new TrancaController(trancaService);
   }

   @Test
   void testCadastrarTranca() {
      Tranca tranca = new Tranca();
      Tranca novaTranca = new Tranca();
      novaTranca.setId(1);

      when(trancaService.cadastrarTranca(tranca)).thenReturn(novaTranca);

      ResponseEntity<Tranca> response = trancaController.cadastrarTranca(tranca);

      Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
      Assertions.assertEquals(novaTranca, response.getBody());

      verify(trancaService, times(1)).cadastrarTranca(tranca);
   }

   @Test
   void testIntegrarTranca_existingTranca() {
      CadastroTrancaRede cadastroTrancaRede = new CadastroTrancaRede();
      cadastroTrancaRede.setIdTranca(1);

      when(trancaService.integrarTrancaNaRede(cadastroTrancaRede)).thenReturn(true);

      ResponseEntity<Tranca> response = trancaController.integrarTranca(cadastroTrancaRede);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

      verify(trancaService, times(1)).integrarTrancaNaRede(cadastroTrancaRede);
   }

   @Test
   void testIntegrarTranca_nonExistingTranca() {
      CadastroTrancaRede cadastroTrancaRede = new CadastroTrancaRede();
      cadastroTrancaRede.setIdTranca(1);

      when(trancaService.integrarTrancaNaRede(cadastroTrancaRede)).thenReturn(false);

      ResponseEntity<Tranca> response = trancaController.integrarTranca(cadastroTrancaRede);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).integrarTrancaNaRede(cadastroTrancaRede);
   }

   @Test
   void testRetirarDaRede_existingTranca() {
      CadastroTrancaRede cadastroTrancaRede = new CadastroTrancaRede();
      cadastroTrancaRede.setIdTranca(1);

      when(trancaService.retirarTrancaDaRede(cadastroTrancaRede)).thenReturn(true);

      ResponseEntity<Tranca> response = trancaController.retirarDaRede(cadastroTrancaRede);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

      verify(trancaService, times(1)).retirarTrancaDaRede(cadastroTrancaRede);
   }

   @Test
   void testRetirarDaRede_nonExistingTranca() {
      CadastroTrancaRede cadastroTrancaRede = new CadastroTrancaRede();
      cadastroTrancaRede.setIdTranca(1);

      when(trancaService.retirarTrancaDaRede(cadastroTrancaRede)).thenReturn(false);

      ResponseEntity<Tranca> response = trancaController.retirarDaRede(cadastroTrancaRede);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).retirarTrancaDaRede(cadastroTrancaRede);
   }

   @Test
   void testRecuperarTrancaPorId_existingTranca() {
      int id = 1;
      Tranca tranca = new Tranca();
      tranca.setId(id);

      when(trancaService.recuperarTranca(id)).thenReturn(tranca);

      ResponseEntity<Tranca> response = trancaController.recuperarTrancaPorId(id);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(tranca, response.getBody());

      verify(trancaService, times(1)).recuperarTranca(id);
   }

   @Test
   void testRecuperarTrancaPorId_nonExistingTranca() {
      int id = 1;

      when(trancaService.recuperarTranca(id)).thenReturn(null);

      ResponseEntity<Tranca> response = trancaController.recuperarTrancaPorId(id);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).recuperarTranca(id);
   }

   @Test
   void testRecuperarBicicletaPorIdTranca_existingTranca() {
      int id = 1;
      Tranca tranca = new Tranca();
      tranca.setId(id);
      Bicicleta bicicleta = new Bicicleta();
      bicicleta.setId(1);
      bicicleta.setMarca("Marca da Bicicleta");
      tranca.setBicicleta(bicicleta);

      when(trancaService.recuperarTranca(id)).thenReturn(tranca);

      ResponseEntity<Bicicleta> response = trancaController.recuperarBicicletaPorIdTranca(id);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(bicicleta, response.getBody());

      verify(trancaService, times(1)).recuperarTranca(id);
   }

   @Test
   void testRecuperarBicicletaPorIdTranca_nonExistingTranca() {
      int id = 1;

      when(trancaService.recuperarTranca(id)).thenReturn(null);

      ResponseEntity<Bicicleta> response = trancaController.recuperarBicicletaPorIdTranca(id);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).recuperarTranca(id);
   }

   @Test
   void testRecuperarTodasTrancas() {
      List<Tranca> trancas = new ArrayList<>();
      trancas.add(new Tranca());
      trancas.add(new Tranca());

      when(trancaService.recuperarTodosTotens()).thenReturn(trancas);

      ResponseEntity<List<Tranca>> response = trancaController.recuperarTodasTrancas();

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(trancas, response.getBody());

      verify(trancaService, times(1)).recuperarTodosTotens();
   }

   @Test
   void testAlterarTranca_existingTranca() {
      int id = 1;
      Tranca tranca = new Tranca();
      tranca.setId(id);

      when(trancaService.atualizarTranca(tranca, id)).thenReturn(tranca);

      ResponseEntity<Tranca> response = trancaController.alterarTranca(tranca, id);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(tranca, response.getBody());

      verify(trancaService, times(1)).atualizarTranca(tranca, id);
   }

   @Test
   void testAlterarTranca_nonExistingTranca() {
      int id = 1;
      Tranca tranca = new Tranca();

      when(trancaService.atualizarTranca(tranca, id)).thenReturn(null);

      ResponseEntity<Tranca> response = trancaController.alterarTranca(tranca, id);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).atualizarTranca(tranca, id);
   }

   @Test
   void testDeletarTranca_existingTranca() {
      int id = 1;
      Tranca tranca = new Tranca();
      tranca.setId(id);

      when(trancaService.deletarTranca(id)).thenReturn(tranca);

      ResponseEntity<Tranca> response = trancaController.deletarTranca(id);

      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertEquals(tranca, response.getBody());

      verify(trancaService, times(1)).deletarTranca(id);
   }

   @Test
   void testDeletarTranca_nonExistingTranca() {
      int id = 1;

      when(trancaService.deletarTranca(id)).thenReturn(null);

      ResponseEntity<Tranca> response = trancaController.deletarTranca(id);

      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

      verify(trancaService, times(1)).deletarTranca(id);
   }
}
