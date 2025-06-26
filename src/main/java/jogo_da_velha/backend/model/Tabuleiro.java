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


}
