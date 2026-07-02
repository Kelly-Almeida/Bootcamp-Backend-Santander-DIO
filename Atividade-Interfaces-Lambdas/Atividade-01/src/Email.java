import java.util.Scanner;

public class Email implements Mensagem, CheckS{
    private String destinatario, assunto, mensagem;

    public Email(){
        setDestinatario();
        setAssunto();
        setMensagem();
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario() {this.destinatario = CheckS.setEmail();}

    public String getAssunto() {
        return assunto;
    }

    private void setAssunto() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite o assunto do email: ");
        String assuntoInupt;
        boolean nomeOk;

        do {
            nomeOk = false;

            assuntoInupt = scan.nextLine();

            if(assuntoInupt.isEmpty()){
                System.out.println("Digite um assunto!!");
                nomeOk = true;

            }
        }while(nomeOk);

        this.assunto = assuntoInupt;
    }

    public String getMensagem(){return this.mensagem;}

    private void setMensagem(){this.mensagem = CheckS.setMensagem();}

    @Override
    public void enviar() {
        System.out.println("----------------------------");
        System.out.println("\t\tEmail");
        System.out.println("----------------------------");
        System.out.println("Para: " + this.destinatario);
        System.out.println("Assunto: " + this.assunto);
        System.out.println(this.mensagem);
    }
}
