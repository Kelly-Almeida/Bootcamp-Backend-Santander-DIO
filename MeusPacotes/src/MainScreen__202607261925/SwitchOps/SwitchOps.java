package MainScreen__202607261925.SwitchOps;
import MainScreen.CheckS;

import java.util.List;
import java.util.Scanner;

public class SwitchOps {
    private static Scanner scan = new Scanner(System.in);
    private static final SwitchInvalid mesagem = new SwitchInvalid("Digite uma resposta válida!!");
    private static final SwitchInvalid digiteUmNúmero = new SwitchInvalid("Digite um número");
    public SwitchOps(){

    }
    public static int escolhaArray(String [] ops){

        int escolha;
        boolean round;
        do{
            round = false;

            for(int i = 0; i < ops.length; i++){
                System.out.println((i+1) + " - " + ops[i]);
            }
            System.out.printf("=> ");
            escolha = safeScanInt();

            if (escolha < 1 || escolha > ops.length){
                round = true;
                mesagem.showMensage();
            }
        }while(round);

        return --escolha;
    }

    public static int escolhaList(List<String> list){
        boolean round;
        if(list.isEmpty()){
            System.out.println("Não nenhum item");
            return -1;
        }

        int escolha;
        do{
            round = false;

            for(int i = 0; i < list.size(); i++){
                System.out.println((i+1) + " - " + list.get(i));
            }
            System.out.printf("=> ");
            escolha = safeScanInt();

            if (escolha < 1 || escolha > list.size()){
                round = true;
                mesagem.showMensage();
            }
        }while(round);

        return --escolha;
    }

    private static int safeScanInt(){
        boolean round;
        int resp = -1;
        do{
            round = true;

            var escolha = scan.nextLine();

            try{
                resp = Integer.parseInt(escolha);
            }catch (Exception ex){
                System.out.println(digiteUmNúmero.showMensage());
                round = false;
            }

        }while (round);

        return resp;
    }
}
