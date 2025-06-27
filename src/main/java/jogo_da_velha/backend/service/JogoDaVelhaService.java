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
    private String vencedor;

    public String getVencedor() {
        return vencedor;
    }
    public void setVencedor(String vencedor){
        this.vencedor = vencedor;
    }

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
        for (String posicao : posicoes) {
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
        setVencedor(" ");


        Tabuleiro tabuleiro = tabuleiroRepository.getReferenceById(id);
        String vencedor = " ";
        char jogadorAtual = tabuleiro.getJogadorAtual();


        List<List<Integer>> combinacoes = gerarCombinacoes();
        List<String> posicoes = new ArrayList<>();
        List<Integer> posicoesNumeradas = gerarPosicoesDoTabuleiro();


        String [] posicoesDoTabuleiro = tabuleiro.getJogoPosicoes();

            //Lógica para preencher o tabuleiro conforme as jogadas alternadas
            for (Integer posi : posicoesNumeradas) {

                if (jogada == posi && jogadorAtual == 'O' && posicoesDoTabuleiro[posi] == null && getVencedor() == " ") {
                    posicoesDoTabuleiro[posi] = "O";
                    tabuleiro.setJogadorAtual('X');
                    tabuleiro.setJogoPosicoes(posicoesDoTabuleiro);
                    tabuleiroRepository.save(tabuleiro);

                }
                else if(jogada == posi && jogadorAtual == 'X' && posicoesDoTabuleiro[posi] == null && getVencedor() == " "){
                    posicoesDoTabuleiro[posi] = "X";
                    tabuleiro.setJogadorAtual('O');
                    tabuleiro.setJogoPosicoes(posicoesDoTabuleiro);
                    tabuleiroRepository.save(tabuleiro);
                }



            }

            // verifica o vencedor
            for(List<Integer> combinacao : combinacoes){
                if("X".equals(posicoesDoTabuleiro[combinacao.get(0)]) && "X".equals(posicoesDoTabuleiro[combinacao.get(1)])
                        && "X".equals(posicoesDoTabuleiro[combinacao.get(2)])){
                    setVencedor("X");
                    break;
                }
                else if("O".equals(posicoesDoTabuleiro[combinacao.get(0)]) && "O".equals(posicoesDoTabuleiro[combinacao.get(1)])
                        && "O".equals(posicoesDoTabuleiro[combinacao.get(2)])) {
                    setVencedor("O");
                    break;

                }

            }
    return getVencedor();
    }


    //função para gerar as posições do tabuleiro de 0 a 8
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


    // função para gerar as combinações de vitória
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



    // função que verifica o vencedor
    public boolean naoTemVencedor(Long id, String[] jogo){

        List<List<Integer>> combinacoes = gerarCombinacoes();
        Tabuleiro tabuleiro1 = tabuleiroAtual(id);

        for(List<Integer> combinacao : combinacoes){

            if(jogo[combinacao.get(0)] == "X" && jogo[combinacao.get(1)] == "X" && jogo[combinacao.get(2)] == "X" && getVencedor() == null){
                setVencedor("X");
                return false;
            }
            else {
                if(jogo[combinacao.get(0)] == "O" && jogo[combinacao.get(1)] == "O" && jogo[combinacao.get(2)] == "O" && getVencedor() == null){
                    setVencedor("O");
                    return false;
                }
            }

        }
        return true;
    }

}



