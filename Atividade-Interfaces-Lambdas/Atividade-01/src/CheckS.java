import javax.swing.plaf.PanelUI;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CheckS {

    //Verifica se é um número válido
    public static boolean checkNumber(String numero) {
        numero = numero.replaceAll("\\D", "");

        String regex = "\\d{10,11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);

        if (numero.isEmpty() || !matcher.matches()){
            return false;
        }else {
            return true;
        }
    }

    //Verifica se é um email válido
    public static boolean checkEmail(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    //Envia um número
    public static String setNum(){
        Scanner scan = new Scanner(System.in);

        System.out.printf("Digite o número do destinatário: ");
        String numero;
        boolean loop;

        do{
            loop = false;
            numero = scan.nextLine();

            if (!CheckS.checkNumber(numero)){
                System.out.println("Digite um número válido!!");
                loop = true;
            }
        }while(loop);

        return numero;
    }

    //Envia uma mensagem
    public static String setMensagem(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um mensagem: ");
        String mensagemInput;
        boolean loop;

        do{
            loop = false;
            mensagemInput = scan.nextLine();

            if(mensagemInput.isEmpty()){
                loop = true;
                System.out.println("Digite uma mensagem!!");
            }
        }while(loop);

        return mensagemInput;
    }

    public static String setEmail(){
        Scanner scan = new Scanner(System.in);

        System.out.printf("Digite o email do destinatário: ");
        String email;
        boolean loop;

        do{
            loop = false;
            email = scan.nextLine();

            if (!CheckS.checkEmail(email)){
                System.out.println("Digite um email válido!!");
                loop = true;
            }
        }while(loop);

        return email;
    }
}