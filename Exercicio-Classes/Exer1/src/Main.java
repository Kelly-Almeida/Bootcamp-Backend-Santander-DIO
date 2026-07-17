/*
*Escreva um código que cria uma calculadora para as operações de soma e subtração,
* o usuário deve informar todos os números que serão usados
*na conta de uma só vez utilizando virgulas para separa-los.
*/
import MainScreen.Header;
import MainScreen.SwitchOps;
import com.sun.jdi.request.StepRequest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;


public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //Histórico
        List<String> historico = new ArrayList<>();

        //Opções de escolha
        String [] escolhas = new String[] {"Calcular", "Ver histórico", "Desligar"};
        String [] calculo = new String[] {"Soma", "Subtração", "Multiplicação", "Divisão", "Voltar"};
        String [] historicoEscol = new String[] {"Voltar"};

        //Títulos
        Header titleInit = new Header("Calculadora", 3);
        Header titleCalc = new Header("Operações", 3);
        Header titleHistory = new Header("Histórico", 3);

        //Variável de controle
        boolean round = true;

        //Código principal

        do {
            titleInit.Header();
            int escol = SwitchOps.escolhaArray(escolhas);

            String escolhaString = escolhas[escol];

            switch (escolhaString){
                case "Calcular":
                    titleCalc.Header();
                    boolean operacaoRound = true;
                    do{
                        System.out.println("Digite...");
                        escol = SwitchOps.escolhaArray(calculo);

                        escolhaString = calculo[escol];

                        float [] numbers = new float[0];
                        
                        if (escol != calculo.length - 1){
                            System.out.println("Digite o números a serem calculados:\n(Ex: 1, 4, 10)");

                            boolean adicionar = true;
                            String numberString = scan.nextLine();

                            String[] nums = numberString.replace(";", ",")
                                    .split(",");

                            numbers = new float[nums.length];


                            for (int i = 0; i < nums.length; i++) {
                                numbers[i] = Float.parseFloat(nums[i].trim());
                            }
                        }
                        
                        switch (escolhaString){
                            case "Soma":
                                Calculo soma = Calculo.SOMA;
                                System.out.println(soma.registro(numbers));
                                historico.add(soma.registro(numbers));
                                break;
                            case "Subtração":
                                Calculo sub = Calculo.SUB;
                                System.out.println(sub.registro(numbers));
                                historico.add(sub.registro(numbers));
                                break;
                            case "Multiplicação":
                                Calculo mult = Calculo.MULT;
                                System.out.println(mult.registro(numbers));
                                historico.add(mult.registro(numbers));
                                break;
                            case "Divisão":
                                boolean temZeroNoDivisor = false;

                                for (int i = 1; i < numbers.length; i++){
                                    if (numbers[i] == 0){
                                        temZeroNoDivisor = true;
                                        break;
                                    }
                                }
                                if(temZeroNoDivisor){
                                    System.out.println("Não é possível realizar esse calculo!");
                                }else{
                                    Calculo div = Calculo.DIV;
                                    System.out.println(div.registro(numbers));
                                    historico.add(div.registro(numbers));
                                }
                                break;
                            case "Voltar":
                                operacaoRound = false;
                                break;
                        }
                    }while (operacaoRound);
                    break;
                case "Ver histórico":

                    titleHistory.Header();

                    if(historico.isEmpty()){
                        System.out.println("Não há operação cadastradas");
                    }else{
                        int i = 1;
                        for(String s : historico){
                            System.out.println(i+" - "+s);
                        }
                        System.out.println("======================");
                        System.out.println("Digite...");
                        SwitchOps.escolhaArray(historicoEscol);
                    }
                    break;
                case "Desligar":
                    round = false;
            }

        }while (round);


    }
}
