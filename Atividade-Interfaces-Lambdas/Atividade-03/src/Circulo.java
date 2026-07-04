import MainScreen.CheckS;

import java.util.Scanner;


public class Circulo implements Calculo{

    private float raio;

    public Circulo(){
        setRaio();
    }

    private void setRaio(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o valor do raio: ");

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
        this.raio = valor;
    }

    public float getRaio(){return this.raio;}

    @Override
    public double calcularArea() {
        return Math.PI *(this.raio * this.raio);
    }

    @Override
    public float calcularPerimetro() {
        return (float) (2 * Math.PI * this.raio);
    }
}
