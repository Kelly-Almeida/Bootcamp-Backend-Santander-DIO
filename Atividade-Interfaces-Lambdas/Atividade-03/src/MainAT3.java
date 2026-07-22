import MainScreen.Header;
import MainScreen.SwitchOps;

import java.util.ArrayList;
import java.util.List;

public class MainAT3 {
    public static void main(String[] args){
        Header tituloPrincipal = new Header("Calculo de formas", 2);
        Header tituloFormas = new Header("Formas", 3);
        Header historico = new Header("Histórico", 3);

        String [] ops = new String[] {"Calcular medidas", "Histórico de medidas", "Sair"};
        String [] formas = new String[] {"Quadrado", "Retângulo", "Circulo", "Voltar"};
        List <String> historicos = new ArrayList<>();

        boolean loop = true;

        do{
            tituloPrincipal.titulo();
            System.out.println("Digite para...");
            int escolha = SwitchOps.escolhaArray(ops);

            String direcionamento = ops[escolha];

            switch (direcionamento){
                case "Calcular medidas":
                    tituloFormas.titulo();
                    System.out.println("Digite para calcular a forma de um...");
                    escolha = SwitchOps.escolhaArray(formas);

                    direcionamento = formas[escolha];

                    switch (direcionamento){
                        case "Quadrado":
                            Quadrado newQuadrado = new Quadrado();
                            historicos.add("Forma: Quadrado \n\tLado: " + newQuadrado.getLado() + "um \n\tPerimetro: " + newQuadrado.calcularPerimetro() + "um \n\tÁrea: " + newQuadrado.calcularArea() + "um²");
                            System.out.println(historicos.getLast());
                            break;
                        case "Retângulo":
                            Retangulo newRetangulo = new Retangulo();
                            historicos.add("Forma: Retângulo \n\tBase: " + newRetangulo.getBase() +"um\n\tAltura: " + newRetangulo.getAltura() + "um \n\tPerimetro: " + newRetangulo.calcularPerimetro() + "um \n\tÁrea: " + newRetangulo.calcularArea() +"um²");
                            System.out.println(historicos.getLast());
                            break;
                        case "Circulo":
                            Circulo newCirculo = new Circulo();
                            historicos.add(String.format("Forma: %.2f\n\tRaio: %.2fum\n\tPerimetro: %.2fum\n\tÁrea: %.2fum²",
                                    newCirculo.getRaio(),
                                    newCirculo.getRaio(),
                                    newCirculo.calcularPerimetro(),
                                    newCirculo.calcularArea()));
                            System.out.println(historicos.getLast());
                            break;
                    }
                    break;
                case "Histórico de medidas":
                    historico.titulo();

                    if (historicos.size() == 0){
                        System.out.println("Não há nenhuma consulta cadastrada!!");
                    }else{
                        int i = 1;
                        for (String item : historicos){
                            System.out.println(i +" - "+ item);
                            i++;
                        }
                    }
                    break;
                case "Sair":
                    loop = false;
                    break;
            }

        }while(loop);

        System.out.println("Tenha um bom dia!!");
    }

}