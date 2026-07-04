package MainScreen;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SwitchOps {
    static Scanner scan = new Scanner(System.in);
    public SwitchOps(){

    }
    public static int escolhaArray(String [] ops){

        int escolha;
        do{
            int i = 0;
            for(String op : ops){
                System.out.println((i + 1) +" - "+ op);
                i++;
            }
            System.out.printf("=> ");
            escolha = scan.nextInt();

            if (escolha < 1 || escolha > ops.length){
                System.out.println("Digite uma resposta válida!!");
            }
        }while(escolha < 1 || escolha > ops.length);

        return --escolha;
    }

    public static int escolhaList(List<String> list){
        if(list.size() == 0){
            System.out.println("Não nenhum item");
            return -1;
        }

        int escolha;
        do{
            for(int i = 0; i < list.size(); i++){
                System.out.println((i+1) + " - " + list.get(i));
            }
            System.out.printf("=> ");
            escolha = (int) CheckS.setNumberValid();

            if (escolha < 1 || escolha > list.size()){
                System.out.println("Digite uma resposta válida!!");
            }
        }while(escolha < 1 || escolha > list.size());

        return --escolha;
    }


}
