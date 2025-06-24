package jogo_da_velha.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder;
import jogo_da_velha.backend.model.Tabuleiro;
import jogo_da_velha.backend.repository.TabuleiroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JogoDaVelhaService {

    private final TabuleiroRepository tabuleiroRepository;


    public JogoDaVelhaService(TabuleiroRepository tabuleiroRepository) {
        this.tabuleiroRepository = tabuleiroRepository;
    }

//    List<Tabuleiro> listaDeId = tabuleiroRepository.findAll();

    // public long idDoJogo(){
    // int id = 1;
    // for(Tabuleiro idJogo : listaDeId){
    // id = (int) idJogo.getId_jogada();

    // }

    // return id;
    // }

    public Long iniciarJogo() {



        Tabuleiro tabuleiro = new Tabuleiro();

        List<String> posicoes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            posicoes.add(null);

        }

        tabuleiro.setJogoPosicoes("[n, n, n, n, n, n, n, n, n]");


        tabuleiro.setJogadorAtual('X');

        var tabuleiroSalvo = tabuleiroRepository.save(tabuleiro);
        return tabuleiroSalvo.getIdJogo();
    }



     public Tabuleiro jogar(long id){
         return tabuleiroRepository.getReferenceById(id);
     }

     public String jogoDaVelha(long id, int jogada){

        char vencedor = ' ';


         List<List<Integer>> combinacoes = gerarCombinacoes();
         Tabuleiro tabuleiro = jogar(id);

         char jogadorAtual = tabuleiro.getJogadorAtual();

         List<String> posicoes = new ArrayList<>();

         List<Integer> posicoesNumeradas = gerarPosicoesDoTabuleiro();


         String posicoesSemColchetes = tabuleiro.getJogoPosicoes().replace("[", "")
                 .replace("]", "");
         String[] jogo = posicoesSemColchetes.split(", \\s*");

         String[][] jogoDaVelha = new String[3][3];
//         List<String> posicoes = new ArrayList<>();
         int contador = 0;


         try {
             contador = 9;

             for (int i = 0; i < jogoDaVelha.length; i++) {
                 for (int j = 0; j < jogoDaVelha.length; j++) {
                     jogoDaVelha[i][j] = jogo[j];
                     posicoes.add(jogo[j]);
                 }
             }

             while(contador != 0){

             }



             for(List<Integer> combinacao : combinacoes){
                 for(Integer combinacaoPosicao: combinacao){
                     if(posicoes.get(combinacaoPosicao).equals("X")){
                         vencedor = 'X';
                     }
                 }
             }

             for(List<Integer> combinacao : combinacoes){
                 for(Integer combinacaoPosicao: combinacao){
                     if(posicoes.get(combinacaoPosicao).equals("O")){
                         vencedor = 'O';
                     }
                 }
             }

             for(Integer position : posicoesNumeradas){
                 if(jogada == position && jogadorAtual == 'X' && posicoes.get(jogada).equals("n")){
                     posicoes.set(jogada, "X");
                     //colocar o jogador atual
                 }
                 else if(jogada == position && jogadorAtual == 'O' && posicoes.get(jogada).equals("n")){
                     posicoes.set(jogada, "O");

                 }
             }



             tabuleiro.setJogadorAtual('X');



//             for(String[] j : jogoDaVelha){
//                 for(String linha : j){
//                     if(linha.equals("n") && jogada == 0){
//                         linha = "X";
//
//                     }
//                 }
//
//             }

//             for(String posicao : posicoes){
//                 if(posicao.equals("n") && tabuleiro.getJogadorAtual() == 'X' && jogada == 0){
//
//                 }
//                 else{
//                     return "Posição ja ocupada";
//                 }
//             }

//             if (jogada == 0) {
//
//                 if (jogoDaVelha[0][0].equals("n")) {
//
//                     jogoDaVelha[0][0] = "X";
//                     tabuleiro.setJogoPosicoes("[X, n, n, n, n, n, n, n]");
//                     tabuleiro.setJogadorAtual('O');
//                     tabuleiroRepository.save(tabuleiro);
//                     return tabuleiro.getJogoPosicoes();
//
//                 }
//
//
//             }

//            while(contador != 0){

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


             return "Retorno";
         } catch (Exception e) {
             System.out.println(e.getMessage());

         }
         return "finalizou";
     }







//         char[][] jogoDaVelha = new char[3][3];
//
//         for (int i = 0; i < jogoDaVelha.length; i++) {
//             for (int j = 0; j < jogoDaVelha.length; j++) {
//                 jogoDaVelha[i][j] = ' ';
//             }
//         }

    //     while(naoTemVencedor(jogoDaVelha)){

    //         System.out.print("Vez de X: ");
            
    //         if (posicao == 0) {
    
    //             if(jogoDaVelha[0][0] == ' '){
    //                 jogoDaVelha[0][0] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
                
                
    //         } else if (posicao == 1) {
    
    //             if(jogoDaVelha[0][1] == ' '){
    //                 jogoDaVelha[0][1] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
    //              ;
    //             }
    
                
    //         } else if (posicao == 2) {
    
    //             if(jogoDaVelha[0][2] == ' '){
    //                 jogoDaVelha[0][2] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
                
    //         } else if (posicao == 3) {
    
    //             if(jogoDaVelha[1][0] == ' '){
    //                 jogoDaVelha[1][0] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
                
    //         } else if (posicao == 4) {
    //             if(jogoDaVelha[1][1] == ' '){
    //                 jogoDaVelha[1][1] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
    
    
    //         } else if (posicao == 5) {
    //             if(jogoDaVelha[1][2] == ' '){
    //                 jogoDaVelha[1][2] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
    //         } else if (posicao == 6) {
    //             if(jogoDaVelha[2][0] == ' '){
    //                 jogoDaVelha[2][0] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
    //             }
    
                
    //         } else if (posicao == 7) {
    //             if(jogoDaVelha[2][1] == ' '){
    //                 jogoDaVelha[2][1] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
    //             }
    //         }
                   
    //         else if (posicao == 8) {
    //             if(jogoDaVelha[2][2] == ' '){
    //                 jogoDaVelha[2][2] = 'X';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
    //             }
    //         }
    

    
    
    //         System.out.print("Vez de O: ");
    //         int posicaoBola = posicao;
           
    //         if (posicaoBola == 0) {
    
    //             if(jogoDaVelha[0][0] == ' '){
    //                 jogoDaVelha[0][0] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                  
                    
    //             }
                
    //         } else if (posicaoBola == 1) {
    //             if(jogoDaVelha[0][1] == ' '){
    //                 jogoDaVelha[0][1] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    
                
    //         } else if (posicaoBola == 2) {
    //             if(jogoDaVelha[0][2] == ' '){
    //                 jogoDaVelha[0][2] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                   
                    
    //             }
    //         } else if (posicaoBola == 3) {
    //             if(jogoDaVelha[1][0] == ' '){
    //                 jogoDaVelha[1][0] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         } else if (posicaoBola == 4) {
    //             if(jogoDaVelha[1][1] == ' '){
    //                 jogoDaVelha[1][1] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         } else if (posicaoBola == 5) {
    //             if(jogoDaVelha[1][2] == ' '){
    //                 jogoDaVelha[1][2] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         } else if (posicaoBola == 6) {
    //             if(jogoDaVelha[2][0] == ' '){
    //                 jogoDaVelha[2][0] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         } else if (posicaoBola == 7) {
    //             if(jogoDaVelha[2][1] == ' '){
    //                 jogoDaVelha[2][1] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         } else if (posicaoBola == 8) {
    //             if(jogoDaVelha[2][2] == ' '){
    //                 jogoDaVelha[2][2] = 'O';
    
    //             }
    //             else{
    //                 System.out.println("Posição ja ocupada");
                    
                    
    //             }
    //         }
            
    //     }
    // }

//    public boolean naoTemVencedor(String[][] matriz) {
//        if (matriz[0][0].equals("X") && matriz[0][1].equals("X") && matriz[0][2].equals("X")) {
//            return false;
//        }
//        if (matriz[1][0].equals("X") && matriz[1][1].equals("X") && matriz[1][2].equals("X")) {
//            return false;
//        }
//
//        if (matriz[2][0].equals("X") && matriz[2][1].equals("X") && matriz[2][2].equals("X")) {
//            return false;
//        }
//
//        if (matriz[0][0].contains("X") && matriz[1][1].contains("X") && matriz[2][2].contains("X")) {
//            return false; // diagonal
//        }
//
//        if (matriz[0][2].equals("X") && matriz[1][1].equals("X") && matriz[0][0].contains("X")) {
//            return false; // diagonal
//        }
//
//        if (matriz[0][2].equals("X") && matriz[1][2].contains("X") && matriz[2][2].contains("X")) {
//            return false;
//        }
//
//        if (matriz[0][1].contains("X") && matriz[1][1].contains("X") && matriz[2][1].contains("X")) {
//            return false;
//        }
//
//        if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') {
//            return false;
//        }
//
//        if (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') {
//            return false;
//        }
//        if (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') {
//            return false;
//        }
//
//        if (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') {
//            return false;
//        }
//
//        if (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') {
//            return false; // diagonal
//        }
//
//        if (matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[0][0] == 'O') {
//            return false; // diagonal
//        }
//
//        if (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') {
//            return false;
//        }
//
//        if (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') {
//            return false;
//        }
//
//        if (matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') {
//            return false;
//        }
//
//        return true;
//
//    }


    public List<List<Integer>> gerarCombinacoes(){
        List<List<Integer>> combinacoes = new ArrayList<>();

        List<Integer> combinacaoPrimeiraLinha = new ArrayList<>();
        combinacaoPrimeiraLinha.add(0);
        combinacaoPrimeiraLinha.add(1);
        combinacaoPrimeiraLinha.add(2);
        combinacoes.add(combinacaoPrimeiraLinha);

        List<Integer> combinacaoSegundaLinha = new ArrayList<>();
        combinacaoSegundaLinha.add(3);
        combinacaoSegundaLinha.add(4);
        combinacaoSegundaLinha.add(5);
        combinacoes.add(combinacaoSegundaLinha);

        List<Integer> combinacaoTerceiraLinha = new ArrayList<>();
        combinacaoTerceiraLinha.add(6);
        combinacaoTerceiraLinha.add(7);
        combinacaoTerceiraLinha.add(8);
        combinacoes.add(combinacaoTerceiraLinha);

        List<Integer> combinacaoUltimaColuna = new ArrayList<>();
        combinacaoUltimaColuna.add(2);
        combinacaoUltimaColuna.add(5);
        combinacaoUltimaColuna.add(8);
        combinacoes.add(combinacaoUltimaColuna);

        List<Integer> combinacaoColunaMeio = new ArrayList<>();
        combinacaoColunaMeio.add(1);
        combinacaoColunaMeio.add(4);
        combinacaoColunaMeio.add(7);
        combinacoes.add(combinacaoColunaMeio);

        List<Integer> combinacaoPrimeiraColuna = new ArrayList<>();
        combinacaoPrimeiraColuna.add(0);
        combinacaoPrimeiraColuna.add(3);
        combinacaoPrimeiraColuna.add(6);
        combinacoes.add(combinacaoPrimeiraColuna);

        List<Integer> combinacaoDiagonal1 = new ArrayList<>();
        combinacaoDiagonal1.add(0);
        combinacaoDiagonal1.add(4);
        combinacaoDiagonal1.add(8);
        combinacoes.add(combinacaoDiagonal1);

        List<Integer> combinacaoDiagonal2 = new ArrayList<>();
        combinacaoDiagonal2.add(2);
        combinacaoDiagonal2.add(4);
        combinacaoDiagonal2.add(6);
        combinacoes.add(combinacaoDiagonal2);

        return combinacoes;


    }

    public List<Integer> gerarPosicoesDoTabuleiro(){

        List<Integer> posicoesNumeradas = new ArrayList<>();
        posicoesNumeradas.add(0);
        posicoesNumeradas.add(1);
        posicoesNumeradas.add(2);
        posicoesNumeradas.add(3);
        posicoesNumeradas.add(4);
        posicoesNumeradas.add(5);
        posicoesNumeradas.add(6);
        posicoesNumeradas.add(7);
        posicoesNumeradas.add(8);

        return posicoesNumeradas;
    }



}
