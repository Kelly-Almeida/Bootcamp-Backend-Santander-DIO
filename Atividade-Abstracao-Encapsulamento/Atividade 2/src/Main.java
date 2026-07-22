import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean round = true;

        String[] ops = {
                "Ligar", "Desligar", "Acelerar", "Desacelerar",
                "Ver velocidade", "Mudar marcha", "Mover", "Sair"
        };

        String[] movimentos = {
                "Esquerda", "Direita", "Para cima", "Para baixo", "Voltar"
        };

        Carro carrinho = new Carro();
        int[] posiCar = {5, 10};
        Pista pista = new Pista(10, 20, posiCar);

        do {
            System.out.println("\n========================================");
            System.out.println("\t\t\t\tCarrinho");
            System.out.println("========================================");
            pista.showPista();
            System.out.println("Status: " + (carrinho.getLigado() ? "Ligado" : "Desligado") +
                    " | Marcha: " + carrinho.getMarcha() +
                    " | Velocidade: " + carrinho.getVelocidade() + " Km/h");
            System.out.println("----------------------------------------");

            for (int i = 1; i <= ops.length; i++) {
                System.out.println(i + " - " + ops[i - 1]);
            }

            int escol = scan.nextInt();

            if (escol < 1 || escol > ops.length) {
                System.out.println("Digite um valor correto!!");
                continue;
            }

            String resp = ops[escol - 1];

            switch (resp) {
                case "Ligar":
                    carrinho.ligar();
                    break;
                case "Desligar":
                    carrinho.desligar();
                    break;
                case "Acelerar":
                    carrinho.acelerar();
                    break;
                case "Desacelerar":
                    carrinho.desacelerar();
                    break;
                case "Ver velocidade":
                    System.out.println("Velocidade atual: " + carrinho.getVelocidade() + " Km/h");
                    break;
                case "Mudar marcha":
                    System.out.print("Digite a marcha desejada (0 a 6): ");
                    int novaMarcha = scan.nextInt();
                    carrinho.setMarcha(novaMarcha);
                    break;
                case "Mover":
                    if (!carrinho.getLigado() || carrinho.getVelocidade() == 0) {
                        System.out.println("O carro precisa estar ligado e em movimento para andar!");
                        break;
                    }

                    System.out.println("\n--- Escolha a Direção ---");
                    for (int i = 1; i <= movimentos.length; i++) {
                        System.out.println(i + " - " + movimentos[i - 1]);
                    }
                    int movEscol = scan.nextInt();

                    if (movEscol >= 1 && movEscol < movimentos.length) {
                        String direcao = movimentos[movEscol - 1];


                        if (direcao.equals("Esquerda") || direcao.equals("Direita")) {
                            if (carrinho.virar()) {
                                pista.mover(direcao);
                            } else {
                                System.out.println("Muito rápido ou parado! Reduza a velocidade (entre 1 e 40 Km/h) para fazer curvas.");
                            }
                        } else {
                            pista.mover(direcao);
                        }
                    }
                    break;
                case "Sair":
                    round = false;
                    System.out.println("Jogo encerrado. Até logo!");
                    break;
            }
        } while (round);

        scan.close();
    }
}