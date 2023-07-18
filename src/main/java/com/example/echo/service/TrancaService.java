package com.example.echo.service;

import com.example.echo.client.ExternoClient;
import com.example.echo.controller.body.CadastroTrancaRede;
import com.example.echo.model.Email;
import com.example.echo.model.Totem;
import com.example.echo.model.Tranca;
import com.example.echo.repository.TrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrancaService {
    private final TrancaRepository trancaRepository;
    private final TotemService totemService;
    private final ExternoClient externoClient;

    @Autowired
    public TrancaService(TrancaRepository trancaRepository, TotemService redeTotensService, ExternoClient externoClient) {
        this.trancaRepository = trancaRepository;
        this.totemService = redeTotensService;
        this.externoClient = externoClient;
    }

    public Tranca cadastrarTranca(Tranca tranca) {
        return trancaRepository.salvarTranca(tranca);
    }

    public Tranca recuperarTranca(int idTranca) {
        return trancaRepository.findById(idTranca);
    }

    public Tranca destrancarTranca(Tranca tranca) {
        tranca.setStatus("LIVRE");
        tranca.setBicicleta(null);
        return this.atualizarTranca(tranca, tranca.getId());
    }

    public Tranca trancarTranca(Tranca tranca) {
        tranca.setStatus("OCUPADA");
        return this.atualizarTranca(tranca, tranca.getId());
    }

    public Tranca atualizarTranca(Tranca tranca, int id) {
        Tranca trancaRecuperado = trancaRepository.findById(id);
        if (trancaRecuperado != null) {
            return trancaRepository.alterarTranca(tranca, id);
        }
        return null;
    }

    public Tranca deletarTranca (int idTranca) {
        Tranca trancaRecuperado = trancaRepository.findById(idTranca);
        if (trancaRecuperado != null) {
            trancaRepository.deleteTranca(idTranca);
            return trancaRecuperado;
        }
        return null;
    }

    public boolean integrarTrancaNaRede(CadastroTrancaRede cadastroTrancaRede) {
        Tranca trancaRecuperada = this.recuperarTranca(cadastroTrancaRede.getIdTranca());
        Totem totemRecuperado = totemService.recuperarTotem(cadastroTrancaRede.getIdTotem());

        if(trancaRecuperada != null && totemRecuperado != null) {
            totemRecuperado.getTrancas().add(trancaRecuperada);
            totemService.atualizarTotem(totemRecuperado, totemRecuperado.getId());

            this.destrancarTranca(trancaRecuperada);

            String corpoEmail = "Caro funcionário " + cadastroTrancaRede.getIdFuncionario() + "a tranca "
                    + trancaRecuperada.getId() + " foi inserida no totem " + totemRecuperado.getId();
            Email email = new Email("pmemail@gmail.com", "Tranca cadastrada", corpoEmail);

//            externoClient.enviarEmail(email);
            return true;

        }
        return false;
    }

    public boolean retirarTrancaDaRede(CadastroTrancaRede cadastroTrancaRede) {
        Tranca trancaRecuperada = this.recuperarTranca(cadastroTrancaRede.getIdTranca());
        Totem redeRecuperada = totemService.recuperarTotem(cadastroTrancaRede.getIdTotem());

        if(trancaRecuperada != null && redeRecuperada != null) {
            redeRecuperada.getTrancas().remove(trancaRecuperada);
            totemService.atualizarTotem(redeRecuperada, redeRecuperada.getId());

            trancaRecuperada.setStatus(cadastroTrancaRede.getStatusAcaoReparador());
            this.atualizarTranca(trancaRecuperada, trancaRecuperada.getId());
            String corpoEmail = "Caro funcionário " + cadastroTrancaRede.getIdFuncionario() + "a tranca "
                    + trancaRecuperada.getId() + " foi retirada do totem " + redeRecuperada.getId();
            Email email = new Email("pmemail@gmail.com", "Tranca cadastrada", corpoEmail);

//            externoClient.enviarEmail(email);
            return true;
        }
        return false;
    }

    public List<Tranca> recuperarTodosTotens() {
        return trancaRepository.findAll();
    }
}
