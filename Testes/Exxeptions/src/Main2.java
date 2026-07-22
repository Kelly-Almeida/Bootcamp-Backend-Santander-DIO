import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Leitura dos valores de entrada
            String saldoInput = scanner.nextLine();
            String saqueInput = scanner.nextLine();

            int saldo = Integer.parseInt(saldoInput.trim());
            int valorSaque = Integer.parseInt(saqueInput.trim());

            // TODO: Verifique se o valor do saque é menor ou igual a zero e imprima "Valor invalido" se for o caso
            if(saldo >= 0){

                // Dica: Use uma estrutura condicional para validar o valor do saque antes de prosseguir
                if (valorSaque <= 0){
                    System.out.println("Valor invalido");
                }else{
                    // Verifica se há saldo suficiente para o saque
                    if (valorSaque > saldo) {
                        System.out.println("Saldo insuficiente");

                    }else{
                        // Saque realizado com sucesso
                        System.out.println(saldo - valorSaque);
                    }
                }





            }else{
                System.out.println("Valor invalido");
            }


        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida");
        }
    }
}