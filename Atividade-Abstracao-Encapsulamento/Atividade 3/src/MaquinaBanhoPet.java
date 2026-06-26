import java.util.Scanner;

public class MaquinaBanhoPet {
    private boolean hasPet;
    private float shampoo;
    private float agua;
    private boolean limpar;
    private Pet petNaCabine = null;
    private boolean banhoFinalizado;

    public MaquinaBanhoPet(){
        this.hasPet = false;
        this.shampoo = 0;
        this.agua = 0;
        this.limpar = false;
        this.banhoFinalizado = false;
    }

    public boolean darBanho(){
        if (this.limpar){
            System.out.println("Máquina necessita de limpeza!!");
            return true;
        }else {
            if(this.shampoo < 2 || this.agua < 10){
                System.out.printf("Máquina ");
                if(this.shampoo < 2 && this.agua < 10){
                    System.out.printf("não tem shampoo e água suficiênte!!");
                }else if (this.shampoo < 2){
                    System.out.printf("não há shampoo suficiênte!!");
                }else{
                    System.out.printf("não há água suficiênte!!");
                }
                return false;
            }else if (this.hasPet){

                System.out.printf("%s está tomando banho!!", this.petNaCabine.getNome());

                this.agua -= 10;
                this.shampoo -= 2;

                this.banhoFinalizado = true;
                System.out.printf("Banho da %s finalizado!", this.petNaCabine.getNome());

            }else{
                System.out.println("Não há um pet na cabine!!");
            }
            return true;
        }

    }
    public void tirarPet(){
        Scanner scan = new Scanner(System.in);
        int escol;
        if(!this.hasPet){
            System.out.println("Não há nenhum pet na cabine!");

        }else if (!this.banhoFinalizado){
            System.out.println("Banho ainda não finalizado!!");
            do{
                System.out.printf("\nDeseja retirar mesmo assim? \n1 - Sim\n2 - Não\n=>");
                escol = scan.nextInt();

                if(escol != 1 && escol != 2){
                    System.out.println("Digite uma opção válida!!");
                }
            }while(escol != 1 && escol != 2);

            if(escol == 1){
                System.out.println("Pet retirado!!\nMáquina necessita de limpeza!!");
                this.limpar = true;
            }
        }else{
            System.out.println(this.petNaCabine.getNome() + " finalizou seu banho!!");
            this.hasPet = false;

            this.petNaCabine = null;
        }
    }
    public void limparCabine(){
        //Em caso de falta de água ou shampoo
        if (this.agua < 3 || this.shampoo < 1){
            System.out.printf("Não é possível realizar a limpeza por falta de ");
            if(this.agua < 3 && this.shampoo < 1){
                System.out.printf(" água e shampoo!!");
            }else if (this.shampoo < 1){
                System.out.printf(" shampoo!");
            }else{
                System.out.printf(" água!");
            }
        }else{
            System.out.println("Limpeza realizada com sucesso!!");
            this.agua -= 3;
            this.shampoo--;
        }
    }

    public boolean setAgua(float aguaADD){
        if (aguaADD < 0){
            System.out.println("Quantidade de água inválida!!");
            return false;
        }else if (this.agua + aguaADD > 30){
            System.out.println("Quantidade grande demais de água!!");
            return false;
        }else{
            this.agua += aguaADD;
            System.out.printf("Adicionado " + aguaADD);
            if(this.agua == 1){
                System.out.printf(" litros");
            }else {
                System.out.printf(" litro ");
            }
            System.out.printf(" de água");
            return true;
        }
    }
    public boolean setShampoo(float shampooADD){
        if (shampooADD < 0){
            System.out.println("Quantidade de shampoo inválida!!");
            return false;
        }else if (this.shampoo + shampooADD > 10){
            System.out.println("Quantidade grande demais de shampoo!!");
            return false;
        }else{
            this.shampoo += shampooADD;
            System.out.printf("Adicionado " + shampooADD);
            if(this.shampoo == 1){
                System.out.printf(" litros");
            }else {
                System.out.printf(" litro ");
            }
            System.out.printf(" de shampoo");
            return true;
        }
    }
    public void setHasPet(Pet pet){
        if (this.limpar){
            System.out.println("Máquina necessita de limpeza!!");
            return;
        }

        if (this.hasPet){
            System.out.println("Já há um pet na máquina!!");
        }else{
            this.hasPet = true;
            this.petNaCabine = pet;
            this.banhoFinalizado = false;

            System.out.println(this.petNaCabine.getNome() + " está na cabine");
        }

    }

    public float getAgua(){return this.agua;}
    public float getShampoo(){return this.shampoo;}
    public boolean getHasPet(){return  this.hasPet;}

}
