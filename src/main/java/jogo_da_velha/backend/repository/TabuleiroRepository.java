package jogo_da_velha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jogo_da_velha.backend.model.Tabuleiro;

public interface TabuleiroRepository extends JpaRepository<Tabuleiro, Long> {
    
}
