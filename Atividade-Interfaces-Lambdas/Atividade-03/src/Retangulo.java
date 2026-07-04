import java.util.Scanner;
import MainScreen.CheckS;

public class Retangulo implements Calculo{
    private float base, altura;

    public Retangulo(){
        setAltura();
        setBase();
    }

    private void setBase(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o valor da base: ");

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
        this.base = valor;
    }

    private void setAltura(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o valor da altura: ");

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
        this.altura = valor;
    }

    public float getAltura() {
        return altura;
    }

    public float getBase() {
        return base;
    }

    @Override
    public double calcularArea() {
        return this.base * this.altura;
    }

    @Override
    public float calcularPerimetro() {
        return (this.altura * 2) +  (this.base * 2);
    }
}
