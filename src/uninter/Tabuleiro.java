package uninter;

import java.util.ArrayList;

public class Tabuleiro {  
    // Inicia atributos e cria métodos da Classe Tabuleiro
    private String[][] board = { 
        { "[ ]", " ", "[ ]", " ", "[ ]" },
        { "   ", " ", "   ", " ", "   " },
        { "[ ]", " ", "[ ]", " ", "[ ]" },
        { "   ", " ", "   ", " ", "   " },
        { "[ ]", " ", "[ ]", " ", "[ ]" } 
    };

    private ArrayList<Integer> tabPosition;
    public int status = 0;

    public Tabuleiro() {	
        // Construtor da Classe Tabuleiro
        this.tabPosition = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            this.tabPosition.add(0);
        }
    }
    // Exibe o tabuleiro no terminal
    public void visualizar() {
        System.out.println();
        for (String[] row : this.board) {

            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.println();
    }   

    public ArrayList<Integer> getTabPosition() {
        return tabPosition;
    }
    
    // Define status do tabuleiro
    public void setStatus(int jogador) {  
        this.status = jogador;
    }

    // Obtêm o status atual do jogo
    public int getStatus() {
        return this.status;
    }

    // Preenche movimento no tabuleiro
    public void setMove(String value, int i, int j) {	
        this.board[i][j] = value;
    }

    // Valida a jogada 
    public int checkMove(String move) {  

        while (!move.matches("[1-9]")) {
            System.out.println("\nJogada inválida!");
            Input newInput = new Input();
            move = newInput.inputScan("Digite uma posição valida vazia de (1-9)");
            return this.checkMove(move);
        }

        return Integer.parseInt(move);
    }



    public void setPosicaoTab(int position, int item) {
        this.tabPosition.set(position, item);
        this.updateBoard(position, item);
    }

    // Método define o símbolo de cada jogador no tabuleiro:
    // X : Humano 
    // O : Computador

    private void updateBoard(int position, int item) {
        String marker = "[O]";
        if(item == 1)
        marker = "[X]";	  
        
        switch(position) {
            case 0: this.setMove(marker, 0, 0); break;
            case 1: this.setMove(marker, 0, 2); break;
            case 2: this.setMove(marker, 0, 4); break;
            case 3: this.setMove(marker, 2, 0); break;
            case 4: this.setMove(marker, 2, 2); break;
            case 5: this.setMove(marker, 2, 4); break;
            case 6: this.setMove(marker, 4, 0); break;
            case 7: this.setMove(marker, 4, 2); break;
            case 8: this.setMove(marker, 4, 4); break;
        }
    }

    // Método que verifica se houve empate. Retorna true caso todas as posições sejam preenchidas
    public boolean empatou() {
        int count = 0;

        count = this.getTabPosition()
                                    .stream()
                                    .filter((item) -> (item != 0))
                                    .map((_item) -> 1)
                                    .reduce(count, Integer::sum);

        return (count == 9);
    }
}
