import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String [] ops = new String[] {"Ver filmes disponíveis", "Comprar ingresso", "Sair"};
        String [] ingressos = new String[] {"Comum", "Meia entrada", "Ingresso família", "Voltar"};
        boolean round = true;
        Filme [] filmes = new Filme[]{
                new Filme("Toy Story 5", 38.00F, true, 102),
                new Filme("Toy Story 5", 38.00F, false, 102),
                new Filme("Supergirl", 40.00F, true, 110),
                new Filme("Dia D", 40.00F, true, 145),
                new Filme("Dia D", 40.00F, false, 145),
                new Filme ("Todo Mundo em Pânico 6", 36.00F, true, 96),
                new Filme ("Mestres do Universo", 38.00F, true, 132)
        };


        do{
            System.out.println("====================Cine show====================\n");
            int escolha;
            do{
                mostrarOpcoes(ops);
                escolha = scan.nextInt();

                if (escolha < 1 || escolha > ops.length){
                    System.out.println("Digite uma opção válida!!");
                }
            }while(escolha < 1 || escolha > ops.length);

            String resp = ops[escolha - 1];
            switch (resp){
                case "Ver filmes disponíveis":
                    System.out.println("============Filmes em cartaz============");
                    for(int i = 0; i < filmes.length; i++){
                        System.out.println((i + 1) + " - " + filmes[i].showFilme());
                    }
                    break;
                case "Comprar ingresso":
                    System.out.println("============Filmes em cartaz============");
                    for(int i = 0; i < filmes.length; i++){
                        System.out.println((i + 1) + " - " + filmes[i].showFilme());
                    }
                    System.out.printf("\nEscolha um filme:\n=>");
                    int filmeEscol;
                    do{
                        filmeEscol = scan.nextInt();

                        if (filmeEscol < 1 || filmeEscol > filmes.length){
                            System.out.println("Digite uma opção válida!!");
                        }
                    }while(filmeEscol < 1 || filmeEscol > filmes.length);

                    mostrarOpcoes(ingressos);

                    System.out.printf("Digite o tipo de ingressso:\n=> ");
                    int escolInngressso;
                    do{
                        escolInngressso = scan.nextInt();

                        if (escolInngressso < 1 || escolInngressso > ingressos.length){
                            System.out.println("Digite um valor válido!!!");
                        }
                    }while(escolInngressso < 1 || escolInngressso > ingressos.length);

                    String ingressoEscolhido = ingressos[escolInngressso -1];
                    Ingresso newIngresso;
                    filmeEscol--;
                    switch (ingressoEscolhido) {
                        case "Comum":
                            newIngresso = new Ingresso(filmes[filmeEscol].getValorIngressoComum(), filmes[filmeEscol].getNome(), filmes[filmeEscol].getDublado());
                            System.out.println("Ingresso adiquirido!!");
                            newIngresso.showIngresso();
                            break;
                        case "Meia entrada":
                            System.out.printf("Digite o número da carteirinha de estudante ou beneficio de meia entrada: ");
                            int numBeneficio;
                            do {
                                numBeneficio = scan.nextInt();

                                if (numBeneficio < 0) {
                                    System.out.println("Digite o número da carteirinha!!");
                                }
                            } while (numBeneficio < 0);

                            newIngresso = new IngressoMeia(filmes[filmeEscol].getValorIngressoComum(), filmes[filmeEscol].getNome(), filmes[filmeEscol].getDublado(), numBeneficio);
                            System.out.println("Ingresso adiquirido!!");
                            newIngresso.showIngresso();
                            break;
                        case "Ingresso família":
                            System.out.printf("Digite a quantidaade de pessoas: ");
                            int numPessoas;
                            do {
                                numPessoas = scan.nextInt();

                                if (numPessoas < 2) {
                                    System.out.println("Digite uma quantidade maior que 2 pessoas!!");
                                }
                            } while (numPessoas < 2);

                            newIngresso = new IngressoFamilia(filmes[filmeEscol].getValorIngressoComum(), filmes[filmeEscol].getNome(), filmes[filmeEscol].getDublado(), numPessoas);
                            System.out.println("Ingresso adiquirido!!");
                            newIngresso.showIngresso();
                            break;
                        case "Voltar":
                            break;
                    }
                    break;
                case "Sair":
                    round = false;
                    break;
            }



        }while(round);
        System.out.println("Tenha uma boa noite!!");

    }

    public static void mostrarOpcoes(String[] ops){
        for(int i = 0; i < ops.length; i++){
            System.out.println((i+ 1) + " - " + ops[i]);
        }
    }


}
