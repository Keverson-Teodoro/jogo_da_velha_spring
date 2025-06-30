package jogo_da_velha.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tabuleirodois")
public class Tabuleiro {

    @Id
    @Column(name="id_tabuleirodois")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogo;

    @Column(name = "jogadas")
    private String[] jogoPosicoes;

    @Column(name = "jogador_atual")
    private char jogadorAtual;

    @Column(name = "vencedor")
    private String vencedor;

    @Column(name = "escolha_vencedor")
    private String escolhaVencedor;


    @Column(name = "id_jogador_1")
    private long jogador1;


    @Column(name = "id_jogador_2")
    private long jogador2;

    

    public Tabuleiro (){
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public String[] getJogoPosicoes() {
        return jogoPosicoes;
    }

    public void setJogoPosicoes(String[] jogoPosicoes) {
        this.jogoPosicoes = jogoPosicoes;
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(char jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getEscolhaVencedor() {
        return escolhaVencedor;
    }

    public void setEscolhaVencedor(String escolhaVencedor) {
        this.escolhaVencedor = escolhaVencedor;
    }


    public long getJogador1() {
        return jogador1;
    }

    public void setJogador1(long jogador1) {
        this.jogador1 = jogador1;
    }

    public long getJogador2() {
        return jogador2;
    }

    public void setJogador2(long jogador2) {
        this.jogador2 = jogador2;
    }
}
