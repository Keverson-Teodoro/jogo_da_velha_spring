package jogo_da_velha.backend.controller;

import jogo_da_velha.backend.model.Tabuleiro;
import jogo_da_velha.backend.repository.TabuleiroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jogo_da_velha.backend.service.JogoDaVelhaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/jogo-da-velha")
public class JogoDaVelhaController {
    private final JogoDaVelhaService jogoDaVelhaService;
    private final TabuleiroRepository tabuleiroRepository;


    public JogoDaVelhaController(JogoDaVelhaService jogoDaVelhaService, TabuleiroRepository tabuleiroRepository, TabuleiroRepository tabuleiroRepository1) {
        this.jogoDaVelhaService = jogoDaVelhaService;

        this.tabuleiroRepository = tabuleiroRepository1;
    }


    @GetMapping("/jogar")
    public long iniciarJogo() {
        return jogoDaVelhaService.iniciarJogo();

    }

//    @PostMapping("/jogar/{jogador1}/{jogador2}")
//    public String salvarJogadores(@PathVariable Joga){
//
//    }

    @GetMapping("jogar/{id}/{jogada}")
    public String jogada(@PathVariable Long id, @PathVariable int jogada) {


        jogoDaVelhaService.jogoDaVelha(id, jogada);
        Tabuleiro tabuleiro = jogoDaVelhaService.tabuleiroAtual(id);


        return Arrays.toString(tabuleiro.getJogoPosicoes())
                + "\n"
                + "Jogador atual: "
                + tabuleiro.getJogadorAtual()
                + "\n"
                + " Vencedor: "
                + jogoDaVelhaService.getVencedor();


    }




}
