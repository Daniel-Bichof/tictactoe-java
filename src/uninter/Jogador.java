package uninter;

import java.util.ArrayList;

public class Jogador {
    Input input = new Input();
    
    private String[] jogadores = {"HUMANO", "COMPUTADOR"};
    private int[][] sequenciasValidas = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},  // Linhas
    {1, 4, 7}, {2, 5, 8}, {3, 6, 9},  // Colunas
    {1, 5, 9}, {3, 5, 7}};			   // Diagonais
    
    public void jogar(Tabuleiro tabuleiro) {
        String move = input.inputScan("Digite uma posição vazia no tabuleiro (1-9): ").trim();
         
        // valida a posição da jogada
        int pos = tabuleiro.checkMove(move);    
        pos--;

        // verifica se posição está preenchida
        int posicao = (int) tabuleiro.getTabPosition().get(pos); 

        if(posicao == 0)
        // seta a escolha, caso a posição não esteja marcada
        tabuleiro.setPosicaoTab(pos, 1);   
        else {           
            System.out.println("\nJogada inválida!");
            this.jogar(tabuleiro);
        }

        
    }

    // Método que verifica se houve um ganhador e retorna o número de quem ganhou:   
     
    public int validaGanhador(Tabuleiro tabuleiro) {
        ArrayList<Integer> posicoesMarcadas = tabuleiro.getTabPosition();

        for (int[] sequenciaValida : this.sequenciasValidas) {
            int countA = 0, countB = 0;

            for(int posicao : sequenciaValida) {                
                if(posicoesMarcadas.get(posicao-1) == 1)
                	countA++;

                if(posicoesMarcadas.get(posicao-1) == 2)
                	countB++;
            }

            if(countA == 3) {
                System.out.println("Ganhador: " + this.getJogador(1) + "!");
                return 1;
            }

            if(countB == 3) {
                System.out.println("Ganhador: " + this.getJogador(2) + "!");
                return 2;
            }
        }

        if(tabuleiro.empatou())
            return 3;

        return 0;
    }
    
    public String[] getJogadores() {
        return this.jogadores;
    }

    public String getJogador(int jogador) {
        return this.jogadores[jogador-1];
    }
}

