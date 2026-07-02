import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WhatsApp implements Mensagem, CheckS{
    static Scanner scan = new Scanner(System.in);
    private static String nomeContato;
    private   String numero;
    private String mensagem;

    public WhatsApp(){
        setNumero();
        setNomeContato();
        setMensagem();
    }

    private void setNumero(){
        this.numero = CheckS.setNum();
    }

    public String getMensagem() {return this.mensagem;}

    private void setMensagem() {CheckS.setMensagem();}

    private static void setNomeContato(){
        System.out.printf("Digite o nome do contato: ");
        String nomeContatoInput;
        boolean nomeOk;

        do {
            nomeOk = false;

            nomeContatoInput = scan.nextLine();

            if(nomeContatoInput.isEmpty()){
                System.out.println("Digite um nome!!");
                nomeOk = true;
            }
        }while(nomeOk);

        nomeContato = nomeContatoInput;
    }

    @Override
    public void enviar() {
        System.out.println("----------------------------");
        System.out.println("\t\tWhatsApp");
        System.out.println("----------------------------");
        System.out.println(nomeContato + " - "+ numero);
        System.out.println("----------------");
        System.out.println(this.mensagem);
    }
}
