import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int resp;

        do{
            System.out.println("===================================");
            System.out.println("\tSistema de salário");
            System.out.println("===================================");
            System.out.println("Digite para...");
            System.out.println("1 - Calcular salário");
            System.out.println("2 - Sair");
            System.out.printf("=> ");
            resp = scan.nextInt();

            if(resp != 2 && resp!= 1){
                System.out.println("Difite um valor válido!");
            }else if (resp == 1){
                float salBruto;
                do{
                    System.out.print("\nDigite o salário bruto: ");
                     salBruto = scan.nextFloat();

                    if (salBruto <= 0){
                        System.out.println("Digite um valor válido");
                    }
                }while(salBruto <= 0);

                float imposto;
                if (salBruto <= 1100.00){
                    imposto = 0.05F;
                }else if (salBruto <= 2500){
                    imposto = 0.1F;
                }else{
                    imposto = 0.15F;
                }
                int resp2;
                float bonus = 0.0F;
                do{
                    System.out.println("\nDigite para...");
                    System.out.println("1 - Adiciona benéfio");
                    System.out.println("2 - Calcular salário");
                    resp2 = scan.nextInt();

                    if(resp2 != 2 && resp2!= 1){
                        System.out.println("Difite um valor válido!");
                    }else if (resp2 == 1){
                        System.out.printf("Digite o valor do bónus: ");
                        float mais = scan.nextFloat();
                        bonus += mais;
                    }

                }while(resp2 != 2);

                float salario = (salBruto - (salBruto * imposto)) + bonus;

                System.out.println("Salário: R$" + salario);

            }
        }while(resp != 2);

        System.out.println("Tenha um bom dia");
    }
}