import MainScreen.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String [] ops = new String[] {"SMS", "E-mail", "Redes sociais", "WhatsApp","Histórico de mensagem", "Sair"};
        Header tituloInit = new Header("Sistema de mensagem", 2);
        Header tituloHistorico = new Header("Histórico de mensagens", 2);
        List <Mensagem> historicoMensagens = new ArrayList<>();
        boolean loop = true;

        do{
            System.out.println(" ");
            tituloInit.Header();
            System.out.println("Digite para enviar mensagem no...");
            int escolha = SwitchOps.escolhaArray(ops);
            String escolhaUser = ops[escolha];

            switch (escolhaUser){
                case "SMS":
                    SMS newSMS = new SMS();
                    newSMS.enviar();
                    historicoMensagens.add(newSMS);
                    break;
                case "E-mail":
                    Email newEmail = new Email();
                    newEmail.enviar();
                    break;
                case "Redes sociais":
                    RedesSociais newRedeSocial = new RedesSociais();
                    newRedeSocial.enviar();
                    historicoMensagens.add(newRedeSocial);
                    break;
                case "WhatsApp":
                    WhatsApp newWhatsApp = new WhatsApp();
                    newWhatsApp.enviar();
                    historicoMensagens.add(newWhatsApp);
                    break;
                case "Histórico de mensagem":
                    tituloHistorico.Header();
                    List <String> mensagens = (historicoMensagens.stream().map(obj -> obj.getClass().getSimpleName())).toList();

                    escolha = SwitchOps.escolhaList(mensagens);

                    if(escolha != -1){
                        historicoMensagens.get(escolha).enviar();
                    }
                    break;
                case "Sair":
                    loop = false;
                    break;
            }
        }while(loop);

        System.out.println("\nTenha um bom dia!!");
    }
}
