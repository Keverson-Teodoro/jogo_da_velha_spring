package jogo_da_velha.backend.controller;

import jogo_da_velha.backend.model.Tabuleiro;
import jogo_da_velha.backend.repository.TabuleiroRepository;
import jogo_da_velha.backend.service.JogoDaVelhaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("/jogo-da-velha")
public class JogoDaVelhaController {
    private final JogoDaVelhaService jogoDaVelhaService;
    private final TabuleiroRepository tabuleiroRepository;


    public JogoDaVelhaController(JogoDaVelhaService jogoDaVelhaService, TabuleiroRepository tabuleiroRepository, TabuleiroRepository tabuleiroRepository1) {
        this.jogoDaVelhaService = jogoDaVelhaService;

        this.tabuleiroRepository = tabuleiroRepository1;
    }


    @GetMapping("/iniciar/{idJogador1}/{idJogador2}")
    public long iniciarJogo(@PathVariable("idJogador1") long idJogador1, @PathVariable("idJogador2") long idJogador2) {
        return jogoDaVelhaService.iniciarJogo(idJogador1, idJogador2);
    }



    @GetMapping("jogar/{id}/{jogada}")
    public String jogada(@PathVariable("id") Long id, @PathVariable("jogada") int jogada) {


        jogoDaVelhaService.jogoDaVelha(id, jogada);
        Tabuleiro tabuleiro = jogoDaVelhaService.tabuleiroAtual(id);



        return Arrays.toString(tabuleiro.getJogoPosicoes())
                + "\n"
                + "Jogador atual: "
                + tabuleiro.getJogadorAtual()
                + "\n"
                + " Vencedor: "
                + tabuleiro.getVencedor();


    }




}
