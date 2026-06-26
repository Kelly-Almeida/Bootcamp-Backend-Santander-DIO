import java.util.Scanner;

public class Main01 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("\tSistema de transação");
        System.out.println("==============================");

        System.out.print("Digite o valor presente na conta: ");
        float valorConta = scan.nextFloat();

        System.out.print("Digite o valor a ser transferido: ");
        float valorTransferencia = scan.nextFloat();

        if (valorConta >= valorTransferencia){
            System.out.println("Transação aprovada");
        }else{
            System.out.println("Saldo insulficiente");
        }
    }
}
