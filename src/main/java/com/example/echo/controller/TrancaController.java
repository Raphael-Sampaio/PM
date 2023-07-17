package com.example.echo.controller;

import com.example.echo.controller.body.CadastroTrancaRede;
import com.example.echo.model.Bicicleta;
import com.example.echo.model.Tranca;
import com.example.echo.service.TrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tranca")
public class TrancaController {

    private final TrancaService trancaService;
    @Autowired
    public TrancaController(TrancaService trancaService) {
        this.trancaService = trancaService;
    }

    @PostMapping
    public ResponseEntity<Tranca> cadastrarTranca(@RequestBody Tranca tranca) {
        Tranca novaTranca = trancaService.cadastrarTranca(tranca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTranca);
    }

    @PostMapping("/integrarNaRede")
    public ResponseEntity<Tranca> integrarTranca(@RequestBody CadastroTrancaRede cadastroTrancaRede) {
        if(trancaService.integrarTrancaNaRede(cadastroTrancaRede)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/retirarDaRede")
    public ResponseEntity<Tranca> retirarDaRede(@RequestBody CadastroTrancaRede cadastroTrancaRede) {
        if(trancaService.retirarTrancaDaRede(cadastroTrancaRede)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tranca> recuperarTrancaPorId(@PathVariable int id) {
        Tranca trancaRecuperada = trancaService.recuperarTranca(id);
        if(trancaRecuperada !=null) {
            return ResponseEntity.ok().body(trancaRecuperada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/bicicleta")
    public ResponseEntity<Bicicleta> recuperarBicicletaPorIdTranca(@PathVariable int id) {
        Tranca trancaRecuperada = trancaService.recuperarTranca(id);
        if(trancaRecuperada !=null) {
            return ResponseEntity.ok().body(trancaRecuperada.getBicicleta());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Tranca>> recuperarTodasTrancas(){
        return ResponseEntity.ok(trancaService.recuperarTodosTotens());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tranca> alterarTranca(@RequestBody Tranca tranca, @PathVariable int id){
        Tranca trancaSalvo = trancaService.atualizarTranca(tranca, id);

        if (trancaSalvo != null) {
            return ResponseEntity.ok(trancaSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/trancar")
    public ResponseEntity<Tranca> trancarTranca(@PathVariable int id){
        Tranca trancaSalvo = trancaService.recuperarTranca(id);

        if (trancaSalvo != null) {
            trancaService.trancarTranca(trancaSalvo);
            return ResponseEntity.ok(trancaSalvo);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/destrancar")
    public ResponseEntity<Tranca> destrancarTranca(@PathVariable int id){
        Tranca trancaSalvo = trancaService.recuperarTranca(id);

        if (trancaSalvo != null) {
            trancaService.destrancarTranca(trancaSalvo);
            return ResponseEntity.ok(trancaSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tranca> deletarTranca(@PathVariable int id) {
        Tranca trancaDeletado = trancaService.deletarTranca(id);

        if(trancaDeletado != null) {
            return ResponseEntity.ok().body(trancaDeletado);
        }
        return ResponseEntity.notFound().build();
    }
}
