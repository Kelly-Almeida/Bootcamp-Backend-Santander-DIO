import java.util.Scanner;

public class RedesSociais implements Mensagem{
    private String mensagem;
    private String redeSocial;

    public RedesSociais(){
        setRedeSocial();
        setMensagem();
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    private void setMensagem() {CheckS.setMensagem();}

    private void setRedeSocial() {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Digite o nome do contato: ");
        String redeSocialInput;
        boolean nomeOk;

        do {
            nomeOk = false;
            redeSocialInput = scan.nextLine();

            if(redeSocialInput.isEmpty()){
                System.out.println("Digite um nome!!");
                nomeOk = true;
            }
        }while(nomeOk);

        this.redeSocial = redeSocialInput;
    }

    @Override
    public void enviar() {
        System.out.println("----------------------------");
        System.out.println("\t\t" + this.redeSocial);
        System.out.println("----------------------------");
        System.out.println(this.mensagem);
    }
}
