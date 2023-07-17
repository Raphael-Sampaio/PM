package com.example.echo.controller;

import com.example.echo.model.Bicicleta;
import com.example.echo.model.RedeTotem;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import com.example.echo.service.RedeTotensService;
import com.example.echo.service.TotemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totem")

public class TotemController {

    private final TotemService totemService;
    private final RedeTotensService redeTotensService;

    @Autowired
    public TotemController(TotemService totemService, RedeTotensService redeTotensService) {
        this.totemService = totemService;
        this.redeTotensService = redeTotensService;
    }

    @PostMapping
    public ResponseEntity<Totem> cadastrarTotem(@RequestBody Totem totem) {
        Totem novoTotem = totemService.cadastrarTotem(totem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTotem);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Totem> recuperarTotemPorId(@PathVariable int id) {
        Totem totemRecuperado = totemService.recuperarTotem(id);
        if(totemRecuperado !=null) {
            return ResponseEntity.ok().body(totemRecuperado);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/trancas")
    public ResponseEntity<List<Tranca>> recuperarTrancasPorIdTotem(@PathVariable int id) {
        RedeTotem rede = redeTotensService.recuperarRedeTotens(id);
        if(rede !=null) {
            return ResponseEntity.ok().body(rede.getTrancas());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/bicicletas")
    public ResponseEntity<List<Bicicleta>> recuperarBicicletasPorIdTotem(@PathVariable int id) {
        RedeTotem rede = redeTotensService.recuperarRedeTotens(id);
        if(rede !=null) {
            return ResponseEntity.ok().body(rede.getBicicletas());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Totem>> recuperarTodosTotens(){
      return ResponseEntity.ok(totemService.recuperarTodosTotens());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Totem> alterarTotem(@RequestBody Totem totem, @PathVariable int id){
        Totem totemSalvo = totemService.atualizarTotem(totem, id);

        if (totemSalvo != null) {
            return ResponseEntity.ok(totemSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Totem> deletarTotem(@PathVariable int id) {
        Totem totemDeletado = totemService.deletarTotem(id);

        if(totemDeletado != null) {
            return ResponseEntity.ok().body(totemDeletado);
        }
        return ResponseEntity.notFound().build();
    }

}
