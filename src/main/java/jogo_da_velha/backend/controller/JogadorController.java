package jogo_da_velha.backend.controller;


import jogo_da_velha.backend.model.Jogador;
import jogo_da_velha.backend.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private final JogadorService jogadorService;


    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public String cadastrarJogador(@RequestBody Jogador jogador){
        jogadorService.salvarJogador(jogador);

        return "Jogador"
                + jogador.getNome()
                + " salvo com sucesso";
    }

}
