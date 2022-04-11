package uninter;

import java.util.Random;

// Jogadas do Computador em sequência aleatória
 
public class ComputadorB extends Computador {

    public void jogar(Tabuleiro tabuleiro) {
        // Usa a classe Random que sorteia um número aleatório até 9
        Random random = new Random();	
        int pos = random.nextInt(9);	

        int position = (int) tabuleiro.getTabPosition().get(pos);

        if(position == 0)
            // Marca a posição sorteada, caso não esteja marcada
            tabuleiro.setPosicaoTab(pos, 2); 
        else
            // Se inválida, tenta outra jogada sorteando um novo número
            this.jogar(tabuleiro);  

        super.jogar(tabuleiro);
    }
}
