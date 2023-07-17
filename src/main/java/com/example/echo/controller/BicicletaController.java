package com.example.echo.controller;

import com.example.echo.model.Bicicleta;
import com.example.echo.controller.body.CadastroBicicletaRede;
import com.example.echo.service.BicicletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicleta")

public class BicicletaController {

    private final BicicletaService bicicletaService;

    @Autowired
    public BicicletaController(BicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    @PostMapping
    public ResponseEntity<Bicicleta> cadastrarBicicleta(@RequestBody Bicicleta bicicleta) {
        Bicicleta novoBicicleta = bicicletaService.cadastrarBicicleta(bicicleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBicicleta);
    }

    @PostMapping("/integrarNaRede")
    public ResponseEntity<Bicicleta> integrarBicicletaNaRede(@RequestBody CadastroBicicletaRede cadastroBicicletaRede) {
        if(bicicletaService.incluirBicicletaRede(cadastroBicicletaRede)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/retirarDaRede")
    public ResponseEntity<Bicicleta> retirarBicicletaDaRede(@RequestBody CadastroBicicletaRede cadastroBicicletaRede) {
        if(bicicletaService.retirarBicicletaDaRede(cadastroBicicletaRede)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> recuperarBicicletaPorId(@PathVariable int id) {
        Bicicleta bicicletaRecuperado = bicicletaService.recuperarBicicleta(id);
        if(bicicletaRecuperado !=null) {
            return ResponseEntity.ok().body(bicicletaRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Bicicleta>> recuperarTodasBicicletas(){
        return ResponseEntity.ok(bicicletaService.recuperarTodosTotens());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> alterarBicicleta(@RequestBody Bicicleta bicicleta, @PathVariable int id){
        Bicicleta bicicletaSalvo = bicicletaService.atualizarBicicleta(bicicleta, id);

        if (bicicletaSalvo != null) {
            return ResponseEntity.ok(bicicletaSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bicicleta> deletarBicicleta(@PathVariable int id) {
        Bicicleta bicicletaDeletado = bicicletaService.deletarBicicleta(id);

        if(bicicletaDeletado != null) {
            return ResponseEntity.ok().body(bicicletaDeletado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/status/{status}")
    public ResponseEntity<Bicicleta> alterarStatusBicicleta(@PathVariable int id, @PathVariable String status){
        Bicicleta bicicletaSalvo = bicicletaService.atualizarStatusBicicleta(id, status);

        if (bicicletaSalvo != null) {
            return ResponseEntity.ok(bicicletaSalvo);
        }
        return ResponseEntity.notFound().build();
    }

}
