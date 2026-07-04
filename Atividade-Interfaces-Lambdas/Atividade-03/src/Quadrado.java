import java.util.Scanner;
import MainScreen.CheckS;

public class Quadrado implements Calculo{
    private float lado;

    public Quadrado(){
        setMedida();
    }

    private void setMedida(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o valor de um dos lados: ");

        float valor;
        boolean loop;
        do{
            loop = false;
            valor = CheckS.setNumberValid();

            if(valor <= 0){
                System.out.println("Digite um valor maior que zero!!");
                loop = true;
            }
        }while(valor <= 0);
        this.lado = valor;
    }

    public float getLado(){return this.lado;}

    @Override
    public double calcularArea() {
        return this.lado * this.lado;
    }

    @Override
    public float calcularPerimetro() {
        return this.lado * 4;
    }
}
