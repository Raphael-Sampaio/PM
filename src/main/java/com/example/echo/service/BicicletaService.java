package com.example.echo.service;

import com.example.echo.client.ExternoClient;
import com.example.echo.model.*;
import com.example.echo.controller.body.CadastroBicicletaRede;
import com.example.echo.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicicletaService {
    private final BicicletaRepository bicicletaRepository;
    private final TrancaService trancaService;
    private final TotemService totemService;
    private final ExternoClient externoClient;

    @Autowired
    public BicicletaService(BicicletaRepository bicicletaRepository, TrancaService trancaService, TotemService totemService, ExternoClient externoClient) {
        this.bicicletaRepository = bicicletaRepository;
        this.trancaService = trancaService;
        this.totemService = totemService;
        this.externoClient = externoClient;
    }

    public Bicicleta cadastrarBicicleta(Bicicleta bicicleta) {
        return bicicletaRepository.salvarBicicleta(bicicleta);
    }

    public Bicicleta recuperarBicicleta(int idBicicleta) {
        return bicicletaRepository.findById(idBicicleta);
    }

    public Bicicleta atualizarBicicleta(Bicicleta bicicleta, int id) {
        Bicicleta bicicletaRecuperado = bicicletaRepository.findById(id);
        if (bicicletaRecuperado != null) {
            return bicicletaRepository.alterarBicicleta(bicicleta, id);
        }
        return null;
    }

    public Bicicleta atualizarStatusBicicleta(int id, String status) {
        Bicicleta bicicletaRecuperado = bicicletaRepository.findById(id);
        if (bicicletaRecuperado != null) {
            bicicletaRecuperado.setStatus(status);
            return bicicletaRepository.alterarBicicleta(bicicletaRecuperado, id);
        }
        return null;
    }

    public Bicicleta deletarBicicleta (int idBicicleta) {
        Bicicleta bicicletaRecuperado = bicicletaRepository.findById(idBicicleta);
        if (bicicletaRecuperado != null) {
            bicicletaRepository.deleteBicicleta(idBicicleta);
            return bicicletaRecuperado;
        }
        return null;
    }


    public boolean incluirBicicletaRede(CadastroBicicletaRede cadastroBicicletaRede) {
        Bicicleta bicicletaRecuperada = this.recuperarBicicleta(cadastroBicicletaRede.getIdBicicleta());
        Tranca trancaRecuperada = trancaService.recuperarTranca(cadastroBicicletaRede.getIdTranca());
        Totem totemRecuperado = totemService.recuperarTotemPorTranca(cadastroBicicletaRede.getIdTranca());

        if(bicicletaRecuperada != null && trancaRecuperada != null && totemRecuperado != null) {
            trancaRecuperada.setBicicleta(bicicletaRecuperada);
            trancaService.atualizarTranca(trancaRecuperada, trancaRecuperada.getId());
            trancaService.trancarTranca(trancaRecuperada);

            totemService.atualizarTotem(totemRecuperado, totemRecuperado.getId());

            bicicletaRecuperada.setStatus("DISPONIVEL");
            this.atualizarBicicleta(bicicletaRecuperada, bicicletaRecuperada.getId());
            String corpoEmail = "Caro funcionário " + cadastroBicicletaRede.getIdFuncionario() + " a bicicleta"
                    + bicicletaRecuperada.getId() + " foi inserida no totem "
                    + totemRecuperado.getId() + " e na tranca " + trancaRecuperada.getId();
            Email email = new Email("pmemail@gmail.com", "Tranca cadastrada", corpoEmail);
//            externoClient.enviarEmail(email);
            return true;
        }
        return false;
    }

    public boolean retirarBicicletaDaRede(CadastroBicicletaRede cadastroBicicletaRede) {
        Bicicleta bicicletaRecuperada = this.recuperarBicicleta(cadastroBicicletaRede.getIdBicicleta());
        Tranca trancaRecuperada = trancaService.recuperarTranca(cadastroBicicletaRede.getIdTranca());
        Totem redeRecuperada = totemService.recuperarTotemPorTranca(cadastroBicicletaRede.getIdTranca());

        if(bicicletaRecuperada != null && trancaRecuperada != null && redeRecuperada != null) {
            trancaRecuperada.setBicicleta(null);
            totemService.atualizarTotem(redeRecuperada, redeRecuperada.getId());

            trancaRecuperada.setBicicleta(null);
            trancaService.atualizarTranca(trancaRecuperada, trancaRecuperada.getId());
            trancaService.destrancarTranca(trancaRecuperada);

            bicicletaRecuperada.setStatus(cadastroBicicletaRede.getStatusAcaoReparador());
            this.atualizarBicicleta(bicicletaRecuperada, bicicletaRecuperada.getId());

            String corpoEmail = "Bicicleta" + bicicletaRecuperada.getId() + "retirada do totem"
                    + redeRecuperada.getId() + " e da tranca " + trancaRecuperada.getId();

            Email email = new Email("pmemail@gmail.com","Bicicleta Removida", corpoEmail);

//            externoClient.enviarEmail(email);
            return true;
        }
        return false;
    }

    public List<Bicicleta> recuperarTodosTotens() {
        return bicicletaRepository.findAll();
    }
}
