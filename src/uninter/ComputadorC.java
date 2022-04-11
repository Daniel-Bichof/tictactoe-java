package uninter;

// Jogadas do Computador em sequência ordenada na diagonal
// Tenta jogar na diagonal, se não for possível joga na casa mais proxima da sua diagonal

public class ComputadorC extends Computador {
    
    public void jogar(Tabuleiro tabuleiro) {
        for (int i = 0; i < tabuleiro.getTabPosition().size(); i += 4) {
            if(tabuleiro.getTabPosition().get(i) != 0) {
                if((i + 4) >= tabuleiro.getTabPosition().size()){
                    i = (i + 4) - tabuleiro.getTabPosition().size() - 1;
                    if(i <= 0){
                        i = i + (i * -1) + 3;
                    }
                }
                if(tabuleiro.getTabPosition().get(i) == 0){
                tabuleiro.setPosicaoTab(i, 2);
                    break;
                }
                
            }
            else{
                tabuleiro.setPosicaoTab(i, 2);
                break;
            }
        }
        super.jogar(tabuleiro);
    }
}
