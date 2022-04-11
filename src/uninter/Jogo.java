package uninter;

//versao java 17

public class Jogo {
    // CriaÃ§Ã£o da classe principal main, que inicializa o programa

    public static void main(String[] args) {	
        // Instanciação de objetos
        Tabuleiro board = new Tabuleiro(); 
        Jogador jogador = new Jogador();
        Computador computador = new Computador();
        Input input = new Input(); 

        String level = "0";	
        // Variavel que recebe a opÃ§Ã£o de dificuldade do jogo

        do {
        	
            System.out.println("JOGO DA VELHA");
            System.out.println("================ \n");
             
            level = input.inputScan("Nível de dificuldade do jogo | A | B | C |: ")
            .trim()
            .toUpperCase();
            
            switch(level) {	
                // Seleciona qual Computador sera chamado 
            	case "A": computador = new ComputadorA(); 
                break;
                
                case "B": computador = new ComputadorB(); 
                break;

                case "C": computador = new ComputadorC(); 
                break;
                
                default:
                    level = "0";    
                    System.out.println("Opção invalida\n");
                }
  
        } while (level == "0");

        System.out.println("==========================================");
        board.visualizar();

        // variavel 1 = X
        // variavel 2 = O
        // Inicia jogo com o Jogador X: Humano
        int vez = 1;  

        while(board.getStatus() == 0) {

            //Jogador Humano
            if(vez == 1) {
                jogador.jogar(board);
                // Passa a vez para o Computador
                vez = 2; 	
            }
            else if(vez == 2) {
                computador.jogar(board);
                vez = 1;
            }

            board.visualizar();
            board.setStatus(jogador.validaGanhador(board));
            System.out.println("*-*-*-*-*-*-*-*-*\n");
        }

        if(board.getStatus() == 3)
            System.out.println("EMPATE!");
    }
}
