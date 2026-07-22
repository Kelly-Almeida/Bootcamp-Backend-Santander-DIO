import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String [] ops = new String[] {"Ver níveis da máquina", "Abastecer a máquina",
                "Colocar pet", "Retirar pet", "Dar banho", "Limpar máquina","Deligar máquina"};
        boolean round = true;
        Pet pet;

        MaquinaBanhoPet maquina = new MaquinaBanhoPet();

        do{
            int escol;
            do{
                System.out.println("\n==============================");
                System.out.println("\tClean Pet Machine");
                System.out.println("==============================");
                System.out.println("Digite...");
                for (int i = 1; i <= ops.length; i++){
                    System.out.println(i + " - " + ops[i - 1]);
                }
                System.out.printf("=> ");
                escol = scan.nextInt();

                if (escol < 1 || escol > ops.length){
                    System.out.println("Digite uma opção válida!!");
                }
            }while(escol < 1 || escol > ops.length);

            String resp = ops[escol -1];
            switch (resp){
                case "Ver níveis da máquina":
                    System.out.println("Nível de água: " +maquina.getAgua() + " litros");
                    System.out.println("Nível de shampoo: " + maquina.getShampoo() + " litros");
                    break;
                case "Abastecer a máquina":
                    System.out.println("Escolha o que abastecer: ");
                    System.out.printf("\n1 - Água\n2 - Shampoo\n=>");
                    int escolha;

                    do{
                        escolha = scan.nextInt();
                        if (escolha != 1 && escolha != 2){
                            System.out.println("Digite uma opção válida!!");
                        }
                    }while(escolha != 1 && escolha != 2);

                    boolean continuar;
                    if (escolha == 1){
                        do{
                            System.out.println("Difigite a quantidade de água: ");
                            float agua = scan.nextFloat();
                            continuar = maquina.setAgua(agua);
                        }while(!continuar);
                    }else{
                        do{
                            System.out.println("Difigite a quantidade de shampoo: ");
                            float shampoo = scan.nextFloat();
                            continuar = maquina.setShampoo(shampoo);
                        }while(!continuar);
                    }
                    break;
                case "Colocar pet":
                    String nomePet;
                    if(maquina.getHasPet()){
                        System.out.println("Já tem um pet na máquina");
                    }else{
                        do{
                            scan.nextLine();
                            System.out.printf("Digite o nome do pet: ");
                            nomePet = scan.nextLine();

                            if (nomePet.isEmpty()){
                                System.out.println("Digite o nome do pet!!");
                            }
                        }while(nomePet.isEmpty());

                        pet = new Pet(nomePet);

                        maquina.setHasPet(pet);
                    }
                    break;
                case "Retirar pet":
                    maquina.tirarPet();
                    break;
                case "Dar banho":
                    maquina.darBanho();
                    break;
                case "Limpar máquina":
                    maquina.limparCabine();
                    break;
                case "Deligar máquina":
                    System.out.println("Máquina desligada!!");
                    round = false;
                    break;
            }
        }while (round);
    }
}