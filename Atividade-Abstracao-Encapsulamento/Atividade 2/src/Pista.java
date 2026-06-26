public class Pista {
    private boolean[][] pista;
    private int[] carro = new int[2];
    private int largura;
    private int altura;

    public Pista(int largura, int altura, int[] carroInicial) {
        this.largura = largura;
        this.altura = altura;
        this.pista = new boolean[largura][altura];
        posicionarCarro(carroInicial[0], carroInicial[1]);
    }

    public void showPista() {
        for (int i = 0; i < this.largura; i++) {
            for (int j = 0; j < this.altura; j++) {
                if (this.pista[i][j]) {
                    System.out.print("# ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean mover(String direcao) {
        int novaLinha = carro[0];
        int novaColuna = carro[1];

        switch (direcao.toLowerCase()) {
            case "esquerda":  novaColuna--; break;
            case "direita":   novaColuna++; break;
            case "para cima":  novaLinha--;  break;
            case "para baixo": novaLinha++;  break;
            default: return false;
        }

        if (novaLinha >= 0 && novaLinha < largura && novaColuna >= 0 && novaColuna < altura) {
            posicionarCarro(novaLinha, novaColuna);
            return true;
        } else {
            System.out.println("Movimento inválido! Você bateu na borda da pista.");
            return false;
        }
    }

    private void posicionarCarro(int novaLinha, int novaColuna) {
        // Limpa a pista antiga
        for (int l = 0; l < this.largura; l++) {
            for (int a = 0; a < this.altura; a++) {
                this.pista[l][a] = false;
            }
        }
        this.carro[0] = novaLinha;
        this.carro[1] = novaColuna;
        this.pista[this.carro[0]][this.carro[1]] = true;
    }
}