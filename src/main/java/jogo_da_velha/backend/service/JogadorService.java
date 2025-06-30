package jogo_da_velha.backend.service;

import jogo_da_velha.backend.model.Jogador;
import jogo_da_velha.backend.repository.JogadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


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
        return jogadorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "ID INVÀLIDO: " + id
        ));

    }
}
