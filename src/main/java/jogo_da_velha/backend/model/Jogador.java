package jogo_da_velha.backend.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;



@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @Column(name = "id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero_de_vitorias")
    private int numeroDeVitorias;

    @Column(name = "numero_de_partidas")
    private int numeroDePartidasJogadas;

    public Jogador(){

    }

    public Jogador(String nome, int numeroDeVitorias, int numeroDePartidasJogadas) {
        this.nome = nome;
        this.numeroDeVitorias = numeroDeVitorias;
        this.numeroDePartidasJogadas = numeroDePartidasJogadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeVitorias() {
        return numeroDeVitorias;
    }

    public void setNumeroDeVitorias(int numeroDeVitorias) {
        this.numeroDeVitorias = numeroDeVitorias;
    }

    public int getNumeroDePartidasJogadas() {
        return numeroDePartidasJogadas;
    }

    public void setNumeroDePartidasJogadas(int numeroDePartidasJogadas) {
        this.numeroDePartidasJogadas = numeroDePartidasJogadas;
    }


}
