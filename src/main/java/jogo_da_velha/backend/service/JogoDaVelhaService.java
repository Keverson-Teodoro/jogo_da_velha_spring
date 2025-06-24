package jogo_da_velha.backend.service;

import java.util.ArrayList;
import java.util.List;

import jogo_da_velha.backend.model.Tabuleiro;
import jogo_da_velha.backend.repository.TabuleiroRepository;
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

        tabuleiro.setJogoPosicoes(posicoes);


        tabuleiro.setJogadorAtual('X');

        var tabuleiroSalvo = tabuleiroRepository.save(tabuleiro);
        return tabuleiroSalvo.getIdJogo();
    }


     public Tabuleiro jogar(long id){
         return tabuleiroRepository.getReferenceById(id);
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

    public boolean naoTemVencedor(char[][] matriz) {
        if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') {
            return false;
        }
        if (matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') {
            return false;
        }

        if (matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') {
            return false;
        }

        if (matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') {
            return false; // diagonal
        }

        if (matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[0][0] == 'X') {
            return false; // diagonal
        }

        if (matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X') {
            return false;
        }

        if (matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') {
            return false;
        }

        if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') {
            return false;
        }

        if (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') {
            return false;
        }
        if (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') {
            return false;
        }

        if (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') {
            return false;
        }

        if (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') {
            return false; // diagonal
        }

        if (matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[0][0] == 'O') {
            return false; // diagonal
        }

        if (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') {
            return false;
        }

        if (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') {
            return false;
        }

        if (matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') {
            return false;
        }

        return true;

    }

}
