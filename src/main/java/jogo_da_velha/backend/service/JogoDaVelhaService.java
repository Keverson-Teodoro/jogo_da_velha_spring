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
import com.google.gson.Gson;

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

        String[] posicoes = new String[9];
        for (String posicao : posicoes){
            posicao = " ";
        }


        tabuleiro.setJogoPosicoes(posicoes);


        tabuleiro.setJogadorAtual('X');

        var tabuleiroSalvo = tabuleiroRepository.save(tabuleiro);
        return tabuleiroSalvo.getIdJogo();
    }


    public Tabuleiro tabuleiroAtual(long id) {
        return tabuleiroRepository.getReferenceById(id);
    }

    public String jogoDaVelha(long id, int jogada) {


        Tabuleiro tabuleiro = tabuleiroRepository.getReferenceById(id);
        String vencedor = " ";
        char jogadorAtual = tabuleiro.getJogadorAtual();


        List<List<Integer>> combinacoes = gerarCombinacoes();
        List<String> posicoes = new ArrayList<>();
        List<Integer> posicoesNumeradas = gerarPosicoesDoTabuleiro();

        Gson transformadorDeListaEmString = new Gson();

        String[][] jogoDaVelha = new String[3][3];
        List<String> teste = new ArrayList<>();

        String [] posicoesDoTabuleiro = tabuleiro.getJogoPosicoes();


//        String posicoesSemColchetes = tabuleiro.getJogoPosicoes().replace("[", "")
//                .replace("]", "").replace("\"", "");
//
//        String[] jogo = posicoesSemColchetes.split(", \\s*");

//        String[] jogoCorrigido = new String[9];
//        for (int i = 0; i < jogo.length; i++) {
//            jogoCorrigido[i] = jogo[i];
//        }
//        for (int i = 0; i < jogo.length; i++) {
//            jogoCorrigido[i] = "";
//            jogo[i] = " ";
//        }




//        String[] jogo = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

        for (Integer posi : posicoesNumeradas) {

            if (jogada == posi && jogadorAtual == 'O' && posicoesDoTabuleiro[posi] == null) {
                posicoesDoTabuleiro[posi] = "O";
                tabuleiro.setJogadorAtual('X');
                tabuleiro.setJogoPosicoes(posicoesDoTabuleiro);
                tabuleiroRepository.save(tabuleiro);

            }
            else if(jogada == posi && jogadorAtual == 'X' && posicoesDoTabuleiro[posi] == null){
                posicoesDoTabuleiro[posi] = "X";
                tabuleiro.setJogadorAtual('O');
                tabuleiro.setJogoPosicoes(posicoesDoTabuleiro);
                tabuleiroRepository.save(tabuleiro);
            }


        }

//        for(List<Integer> combinacao : combinacoes){
//            for(Integer casa : combinacao){
//                for (int i = 0; i < posicoesDoTabuleiro.length; i++) {
//                    if(posicoesDoTabuleiro[casa] == "X"){
//                        vencedor = "X";
//                    }
//                }
//            }
//        }
//
//        for(List<Integer> combinacao : combinacoes){
//            for(Integer casa : combinacao){
//                for (int i = 0; i < posicoesDoTabuleiro.length; i++) {
//                    if(posicoesDoTabuleiro[casa] == "O"){
//                        vencedor = "O";
//                    }
//                }
//            }
//        }

//        for(List<Integer> combinacao : combinacoes){
//            for(Integer combinacaoPosicao: combinacao){
//                if(posicoes.get(combinacaoPosicao).equals("X")){
//                    vencedor = "X";
//                }
//            }
//        }
//
//        for(List<Integer> combinacao : combinacoes){
//            for(Integer combinacaoPosicao: combinacao){
//                if(posicoes.get(combinacaoPosicao).equals("O")){
//                    vencedor = "X";
//                }
//            }
//        }

//        for(List<Integer> combinacao : combinacoes){
//            for(Integer combinacaoPosicao: combinacao){
//                if(posicoes.get(combinacaoPosicao).equals("X")){
//                    vencedor = "X";
//                }
//            }
//        }
//
//        for(List<Integer> combinacao : combinacoes){
//            for(Integer combinacaoPosicao: combinacao){
//                if(posicoes.get(combinacaoPosicao).equals("O")){
//                    vencedor = "X";
//                }
//            }
//        }


//            jogoDaVelha = new String[3][3];
//             for (int i = 0; i < jogoDaVelha.length; i++) {
//                 for (int j = 0; j < jogoDaVelha.length; j++) {
//                     jogoDaVelha[i][j] = jogo[j];
//                     posicoes.add(jogo[j]);
//                 }
//             }

//         for (int i = 0; i < posicoesNumeradas.size(); i++) {
//             posicoes.add(jogo[i]);
//         }

//         if(jogada == 2 && jogo[jogada].isBlank() && jogadorAtual == 'X' ){
//             jogo[jogada] = "X";
//             tabuleiro.setJogadorAtual('O');
//             String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//             tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//             tabuleiroRepository.save(tabuleiro);
//
//         }


//             if(jogada == 1 && jogadorAtual == 'X' && posicoes.get(jogada).equals("null")){
//                 posicoes.add(1, "X");
//                 tabuleiro.setJogadorAtual('O');
//                 String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                 tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//                 tabuleiroRepository.save(tabuleiro);
//                 return "caiu no if do X";
//             }

//             else if(jogada == 0 && jogadorAtual == 'O' && posicoes.get(jogada).equals("null")){
//                 posicoes.add("O");
//                 tabuleiro.setJogadorAtual('X');
//                 String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                 tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//                 tabuleiroRepository.save(tabuleiro);
//             }

//             for (Integer posi : posicoesNumeradas){
//                 if(jogada == 0 && jogadorAtual == 'X' && posicoes.get(jogada).equals("n")){
//                     posicoes.set(jogada, "X");
//                     tabuleiro.setJogadorAtual('O');
//                     String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                     tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//                     tabuleiroRepository.save(tabuleiro);
//                     return "caiu no if do X";
//                 }
//
//                 if(jogada == 0 && jogadorAtual == 'O' && posicoes.get(jogada).equals("n")){
//                     posicoes.set(jogada, "O");
//                     tabuleiro.setJogadorAtual('X');
//                     String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                     tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//                     tabuleiroRepository.save(tabuleiro);
//                     return "caiu no if do bola";
//                 }
//
//
//             }

//
//
//
//             for(Integer position : posicoesNumeradas){
//
//                 if(jogada == position && jogadorAtual == 'X' && "n".equals(posicoes.get(position))){
//                     tabuleiro.setJogadorAtual('O');
//                     posicoes.set(position, "X");
//
//                     String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                     tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//
//                     tabuleiroRepository.save(tabuleiro);
//                     return "Entrou no if do X";
//
//                 }
//
//                 else if(jogada == position && jogadorAtual == 'O' && "n".equals(posicoes.get(position))){
//
//                     posicoes.set(position, "O");
//                     tabuleiro.setJogadorAtual('X');
//                     String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//                     tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//                     tabuleiroRepository.save(tabuleiro);
//                     return "Entro no if do bola";
//
//                 }
//
//             }
//             Gson transformadorDeListaEmString = new Gson();
//             String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//             tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//             tabuleiroRepository.save(tabuleiro);







//             for (int i = 0; i < jogoDaVelha.length; i++) {
//                 for (int j = 0; j < jogoDaVelha.length; j++) {
//                     jogoDaVelha[i][j] = jogo[j];
//                     posicoes.add(jogo[j]);
//                 }
//             }
//
//
//
//
//             for(Integer position : posicoesNumeradas){
//
//                 if(jogada == position && jogadorAtual == 'X' && posicoes.get(jogada).equals("n")){
//                     tabuleiro.setJogadorAtual('O');
//                     posicoes.set(position, "X");
//
//                     tabuleiroRepository.save(tabuleiro);
//
//                 }
//
//                 else if(jogada == position && jogadorAtual == 'O' && posicoes.get(jogada).equals("n")){
//
//                     posicoes.set(position, "O");
//                     tabuleiro.setJogadorAtual('X');
//                     tabuleiroRepository.save(tabuleiro);
//
//                 }
//
//             }
//             Gson transformadorDeListaEmString = new Gson();
//             String posicoesAtualizadas = transformadorDeListaEmString.toJson(posicoes);
//             tabuleiro.setJogoPosicoes(posicoesAtualizadas);
//             tabuleiroRepository.save(tabuleiro);
//
//
//






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





//    public String listaDePosicoes(Long id){
//        Tabuleiro tabuleiro = tabuleiroAtual(id);
//        return tabuleiro.getJogoPosicoes();
//    }

    return vencedor;
    }

    private List<Integer> gerarPosicoesDoTabuleiro () {

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

    public List<List<Integer>> gerarCombinacoes () {
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



}



