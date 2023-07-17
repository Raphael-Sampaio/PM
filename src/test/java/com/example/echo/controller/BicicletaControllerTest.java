package com.example.echo.controller;

import com.example.echo.controller.body.CadastroBicicletaRede;
import com.example.echo.model.Bicicleta;
import com.example.echo.service.BicicletaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BicicletaControllerTest {

   @Mock
   private BicicletaService bicicletaService;

   @InjectMocks
   private BicicletaController bicicletaController;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void cadastrarBicicleta() {
      
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.cadastrarBicicleta(bicicleta)).thenReturn(bicicleta);

      
      ResponseEntity<Bicicleta> response = bicicletaController.cadastrarBicicleta(bicicleta);


      Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicleta, response.getBody());
      verify(bicicletaService, times(1)).cadastrarBicicleta(bicicleta);
   }

   @Test
   void integrarBicicletaNaRede() {
      
      CadastroBicicletaRede cadastroBicicletaRede = new CadastroBicicletaRede();
      when(bicicletaService.incluirBicicletaRede(cadastroBicicletaRede)).thenReturn(true);

      
      ResponseEntity<Bicicleta> response = bicicletaController.integrarBicicletaNaRede(cadastroBicicletaRede);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      verify(bicicletaService, times(1)).incluirBicicletaRede(cadastroBicicletaRede);
   }

   @Test
   void integrarBicicletaNaRede2() {
      
      CadastroBicicletaRede cadastroBicicletaRede = new CadastroBicicletaRede();
      when(bicicletaService.incluirBicicletaRede(cadastroBicicletaRede)).thenReturn(false);

      
      ResponseEntity<Bicicleta> response = bicicletaController.integrarBicicletaNaRede(cadastroBicicletaRede);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).incluirBicicletaRede(cadastroBicicletaRede);
   }

   @Test
   void retirarBicicletaDaRede() {
      
      CadastroBicicletaRede cadastroBicicletaRede = new CadastroBicicletaRede();
      when(bicicletaService.retirarBicicletaDaRede(cadastroBicicletaRede)).thenReturn(true);

      
      ResponseEntity<Bicicleta> response = bicicletaController.retirarBicicletaDaRede(cadastroBicicletaRede);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      verify(bicicletaService, times(1)).retirarBicicletaDaRede(cadastroBicicletaRede);
   }

   @Test
   void retirarBicicletaDaRede2() {
      
      CadastroBicicletaRede cadastroBicicletaRede = new CadastroBicicletaRede();
      when(bicicletaService.retirarBicicletaDaRede(cadastroBicicletaRede)).thenReturn(false);

      
      ResponseEntity<Bicicleta> response = bicicletaController.retirarBicicletaDaRede(cadastroBicicletaRede);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).retirarBicicletaDaRede(cadastroBicicletaRede);
   }

   @Test
   void recuperarBicicletaPorId() {
      
      int bicicletaId = 1;
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.recuperarBicicleta(bicicletaId)).thenReturn(bicicleta);

      
      ResponseEntity<Bicicleta> response = bicicletaController.recuperarBicicletaPorId(bicicletaId);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicleta, response.getBody());
      verify(bicicletaService, times(1)).recuperarBicicleta(bicicletaId);
   }

   @Test
   void recuperarBicicletaPorId2() {
      
      int bicicletaId = 1;
      when(bicicletaService.recuperarBicicleta(bicicletaId)).thenReturn(null);

      
      ResponseEntity<Bicicleta> response = bicicletaController.recuperarBicicletaPorId(bicicletaId);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).recuperarBicicleta(bicicletaId);
   }

   @Test
   void recuperarTodasBicicletas() {
      
      List<Bicicleta> bicicletas = new ArrayList<>();
      bicicletas.add(new Bicicleta());
      bicicletas.add(new Bicicleta());
      when(bicicletaService.recuperarTodosTotens()).thenReturn(bicicletas);

      
      ResponseEntity<List<Bicicleta>> response = bicicletaController.recuperarTodasBicicletas();


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicletas, response.getBody());
      verify(bicicletaService, times(1)).recuperarTodosTotens();
   }

   @Test
   void alterarBicicleta() {
      
      int bicicletaId = 1;
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.atualizarBicicleta(bicicleta, bicicletaId)).thenReturn(bicicleta);

      
      ResponseEntity<Bicicleta> response = bicicletaController.alterarBicicleta(bicicleta, bicicletaId);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicleta, response.getBody());
      verify(bicicletaService, times(1)).atualizarBicicleta(bicicleta, bicicletaId);
   }

   @Test
   void alterarBicicleta2() {
      
      int bicicletaId = 1;
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.atualizarBicicleta(bicicleta, bicicletaId)).thenReturn(null);

      
      ResponseEntity<Bicicleta> response = bicicletaController.alterarBicicleta(bicicleta, bicicletaId);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).atualizarBicicleta(bicicleta, bicicletaId);
   }

   @Test
   void deletarBicicleta() {
      
      int bicicletaId = 1;
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.deletarBicicleta(bicicletaId)).thenReturn(bicicleta);

      
      ResponseEntity<Bicicleta> response = bicicletaController.deletarBicicleta(bicicletaId);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicleta, response.getBody());
      verify(bicicletaService, times(1)).deletarBicicleta(bicicletaId);
   }

   @Test
   void deletarBicicleta2() {
      
      int bicicletaId = 1;
      when(bicicletaService.deletarBicicleta(bicicletaId)).thenReturn(null);

      
      ResponseEntity<Bicicleta> response = bicicletaController.deletarBicicleta(bicicletaId);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).deletarBicicleta(bicicletaId);
   }

   @Test
   void alterarStatusBicicleta() {
      
      int bicicletaId = 1;
      String status = "ativo";
      Bicicleta bicicleta = new Bicicleta();
      when(bicicletaService.atualizarStatusBicicleta(bicicletaId, status)).thenReturn(bicicleta);

      
      ResponseEntity<Bicicleta> response = bicicletaController.alterarStatusBicicleta(bicicletaId, status);


      Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
      Assertions.assertNotNull(response.getBody());
      Assertions.assertEquals(bicicleta, response.getBody());
      verify(bicicletaService, times(1)).atualizarStatusBicicleta(bicicletaId, status);
   }

   @Test
   void alterarStatusBicicleta2() {
      
      int bicicletaId = 1;
      String status = "ativo";
      when(bicicletaService.atualizarStatusBicicleta(bicicletaId, status)).thenReturn(null);

      
      ResponseEntity<Bicicleta> response = bicicletaController.alterarStatusBicicleta(bicicletaId, status);


      Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
      verify(bicicletaService, times(1)).atualizarStatusBicicleta(bicicletaId, status);
   }
}
