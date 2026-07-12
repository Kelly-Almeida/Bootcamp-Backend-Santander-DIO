import MainScreen.SwitchOps;
import enumeration.OperationEnum;

import java.util.Scanner;

public class Teste7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String [] ops = new String[] {"SOMA", "SUBTRAÇÃO", "MULTIPLICAÇÃO", "DIVISÃO", "Sair"};
        boolean round = true;
        do{
            var option = -1;
            System.out.println("Ecolha uma opção");
            int escolha = SwitchOps.escolhaArray(ops);

            if (escolha == ops.length - 1){
                System.out.println("Tenha um bom dia!!");
                round = false;
            }else{
                var selectedOpition = OperationEnum.values()[escolha];
                System.out.println(selectedOpition);
                System.out.println("Informe o primeiro valor: ");
                var valor1 = scan.nextInt();
                System.out.println("Informe o segundo valor: ");
                var valor2 = scan.nextInt();

                var result = selectedOpition.getCalculate().apply(valor1, valor2);

                if (valor2 != 0 && escolha != 4){
                    System.out.printf("%s %s %s = %s\n", valor1,  selectedOpition.getSymbol(), valor2, result);
                }


            }
        }while(round);

    }
}
