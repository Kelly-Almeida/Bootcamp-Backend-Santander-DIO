import java.util.Scanner;
import MainScreen.CheckS;

public abstract class Produto implements  Tributo{
    private String nome;
    private float valorUni;


    public Produto(){
        setNome();
        setValorUni();
    }

    private void setNome(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o nome do produto: ");
        String produtoInput;
        boolean loop;
        do{
            loop = false;

            produtoInput = scan.nextLine();
        }while(loop);
        this.nome = produtoInput;
    }

    private void setValorUni(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o valor unitário do produto: ");
        String valorUniStr;
        float valor = CheckS.setNumberValid();
        this.valorUni = valor;
    }

    public String getNome(){return this.nome;}

    public abstract String getTTipo();

    public float getValorUni(){return this.valorUni;}

    public float getValorCImposto(){return this.valorUni * (setImposto() + 1);}

}
