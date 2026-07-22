import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("============ Cadastro de conta ============");
        System.out.print("Digite o nome do títular: ");
        String nome;
        do {
            nome = scan.nextLine();
        } while (nome.isEmpty());

        System.out.print("Digite o cpf do títular: ");
        String cpf;
        do {
            cpf = scan.nextLine();
            if (cpf.isEmpty() || !cpf.matches("[0-9]+") || cpf.length() != 11) {
                System.out.println("Digite um cpf válido (11 dígitos numéricos)!!");
            }
        } while (cpf.isEmpty() || !cpf.matches("[0-9]+") || cpf.length() != 11);

        System.out.print("Digite o saldo inicial: ");
        float saldo;
        do {
            saldo = scan.nextFloat();
            scan.nextLine(); // LIMPA O BUFFER
            if (saldo <= 0) {
                System.out.println("Digite um valor válido!!");
            }
        } while (saldo <= 0);

        ContaBancaria conta = new ContaBancaria(nome, cpf, saldo);
        boolean round = true;
        String[] ops = new String[]{"Consultar saldo", "Consultar cheque especial",
                "Depositar", "Sacar", "Pagar boleto", "Sair"};

        do {
            System.out.println("------------------------------");
            System.out.println("\t\tConta");
            System.out.println("------------------------------");
            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + " - " + ops[i]);
            }
            int escol = scan.nextInt();
            scan.nextLine(); // LIMPA O BUFFER

            if (escol < 1 || escol > ops.length) {
                System.out.println("Digite um valor válido!!");
            } else {
                String escolha = ops[escol - 1];
                boolean transacaoInvalida;

                switch (escolha) {
                    case "Sair":
                        round = false;
                        break;
                    case "Consultar saldo":
                        System.out.println("\nSaldo: R$" + conta.getSaldo() + "\n");
                        break;
                    case "Consultar cheque especial":
                        System.out.println("\nCheque especial disponível: R$" + conta.getChequeEspecial() + "\n");
                        break;
                    case "Depositar":
                        System.out.println("\n-----Deposito----\n");
                        do {
                            System.out.print("Digite o valor a ser depositado: ");
                            float valor = scan.nextFloat();
                            scan.nextLine();
                            transacaoInvalida = !conta.depositar(valor);
                        } while (transacaoInvalida);
                        break;
                    case "Sacar":
                        System.out.println("\n-----Saque----\n");
                        do {
                            System.out.print("Digite o valor a ser sacado: ");
                            float valor = scan.nextFloat();
                            scan.nextLine();
                            transacaoInvalida = !conta.sacar(valor);
                        } while (transacaoInvalida);
                        break;
                    case "Pagar boleto":
                        System.out.println("\n-----Boleto fácil----\n");
                        do {
                            System.out.print("Digite o valor do boleto: ");
                            float valor = scan.nextFloat();
                            scan.nextLine();
                            transacaoInvalida = !conta.pagarBoleto(valor);
                        } while (transacaoInvalida);
                        break;
                }
            }
        } while (round);

        scan.close();
    }
}

