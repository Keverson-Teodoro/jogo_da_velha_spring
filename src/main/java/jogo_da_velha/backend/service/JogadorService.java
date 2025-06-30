package jogo_da_velha.backend.service;

import jogo_da_velha.backend.model.Jogador;
import jogo_da_velha.backend.repository.JogadorRepository;
import org.springframework.stereotype.Service;


@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void salvarJogador(Jogador jogador){
        jogadorRepository.save(jogador);
    }

    public Jogador buscarJogador(long id){
        return jogadorRepository.getReferenceById(id);
    }
}
