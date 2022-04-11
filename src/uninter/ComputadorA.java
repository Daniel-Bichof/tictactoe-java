package uninter;

// Jogadas do Computador em sequência ordenada crescente.

public class ComputadorA extends Computador {

    public void jogar(Tabuleiro tabuleiro) {
        for (int i = 0; i < tabuleiro.getTabPosition().size(); i++) {
            if(tabuleiro.getTabPosition().get(i) == 0) {
                tabuleiro.setPosicaoTab(i, 2);
                break;
            }
        }
        super.jogar(tabuleiro);
    }
}
