package jogo_da_velha.backend.controller;

import jogo_da_velha.backend.model.Tabuleiro;
import org.springframework.web.bind.annotation.*;

import jogo_da_velha.backend.service.JogoDaVelhaService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jogo-da-velha")
public class JogoDaVelhaController {
    private final JogoDaVelhaService jogoDaVelhaService;

    public JogoDaVelhaController(JogoDaVelhaService jogoDaVelhaService) {
        this.jogoDaVelhaService = jogoDaVelhaService;
    }


    @GetMapping("/jogar")
    public long iniciarJogo(){
        return jogoDaVelhaService.iniciarJogo();

    }

    @GetMapping("jogar/{id}/{jogada}")
    public String jogada(@PathVariable Long id, @PathVariable int jogada){

        Tabuleiro tabuleiro = jogoDaVelhaService.jogar(id);
        List<String> posicoes = tabuleiro.getJogoPosicoes();
//        String posicoesSemColchetes = tabuleiro.getJogoPosicoes().replace("[", "")
//                .replace("]", "");

//        String[] jogo = posicoesSemColchetes.split(", \\s*");

        String[][] jogoDaVelha = new String[3][3];


//        List<String> posicoes = new ArrayList<>();
        int contador = 0;

        try{
            contador = 9;

            for (int i = 0; i < jogoDaVelha.length; i++) {
                for (int j = 0; j <jogoDaVelha.length; j++) {
                
                }
            }

            tabuleiro.setJogadorAtual('X');
            if(jogada == 1){
                if(posicoes.get(0).equals("n")){
                    posicoes.set(0, "X");

                    tabuleiro.setJogoPosicoes(posicoes);

                }
                else{
                    return "Não encon";
                }
            }

//            while(contador != 0){
//
//                tabuleiro.setJogadorAtual('X');
//                char jogadorAtual = tabuleiro.getJogadorAtual();
//
//
//                if(jogada == 0 && jogadorAtual == 'X'){
//                    if(posicoes.get(0).equals("n")){
//                        posicoes.set(0, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 1 && jogadorAtual == 'X'){
//                    if(posicoes.get(1).equals("n")){
//                        posicoes.set(1, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 2 && jogadorAtual == 'X'){
//                    if(posicoes.get(2).equals("n")){
//                        posicoes.set(2, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 3 && jogadorAtual == 'X'){
//                    if(posicoes.get(3).equals("n")){
//                        posicoes.set(3, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 4 && jogadorAtual == 'X'){
//                    if(posicoes.get(4).equals("n")){
//                        posicoes.set(4, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 5 && jogadorAtual == 'X'){
//                    if(posicoes.get(5).equals("n")){
//                        posicoes.set(5, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 6 && jogadorAtual == 'X'){
//                    if(posicoes.get(6).equals("n")){
//                        posicoes.set(6, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 7 && jogadorAtual == 'X'){
//                    if(posicoes.get(7).equals("n")){
//                        posicoes.set(7, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 8 && jogadorAtual == 'X'){
//                    if(posicoes.get(8).equals("n")){
//                        posicoes.set(8, "X");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                contador -= 1;
//
//                tabuleiro.setJogadorAtual('O');
//                char outroJogador = tabuleiro.getJogadorAtual();
//
//                if(jogada == 0 && outroJogador == 'O'){
//                    if(posicoes.get(0).equals("n")){
//                        posicoes.set(0, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 1 && outroJogador == 'O'){
//                    if(posicoes.get(1).equals("n")){
//                        posicoes.set(1, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 2 && outroJogador == 'O'){
//                    if(posicoes.get(2).equals("n")){
//                        posicoes.set(2, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 3 && outroJogador == 'O'){
//                    if(posicoes.get(3).equals("n")){
//                        posicoes.set(3, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 4 && outroJogador == 'O'){
//                    if(posicoes.get(4).equals("n")){
//                        posicoes.set(4, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 5 && outroJogador == 'O'){
//                    if(posicoes.get(5).equals("n")){
//                        posicoes.set(5, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 6 && outroJogador == 'O'){
//                    if(posicoes.get(6).equals("n")){
//                        posicoes.set(6, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 7 && outroJogador == 'O'){
//                    if(posicoes.get(7).equals("n")){
//                        posicoes.set(7, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }
//
//                if(jogada == 8 && outroJogador == 'O'){
//                    if(posicoes.get(8).equals("n")){
//                        posicoes.set(8, "O");
//                    }
//                    else{
//                        return "Não aceitamos esse valor";
//                    }
//                }








//            }




            return "a";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "a";


    }



}
