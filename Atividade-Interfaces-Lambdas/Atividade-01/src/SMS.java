import java.util.Scanner;

public class SMS implements Mensagem, CheckS {
    private String numDestinatario, mensagem;

    public SMS(){
        setNumDestinatario();
        setMensagem();
    }

    public String getNumDestinatario() {return numDestinatario;}

    public String getMensagem() {return mensagem;}

    private void setMensagem() {this.mensagem = CheckS.setMensagem();}

    private void setNumDestinatario() {this.numDestinatario = CheckS.setNum();}


    @Override
    public void enviar() {
        System.out.println("----------------------------");
        System.out.println("\t\t\tSMS");
        System.out.println("----------------------------");
        System.out.println("Destinatário: " + this.numDestinatario);
        System.out.println(this.mensagem);

    }
}
