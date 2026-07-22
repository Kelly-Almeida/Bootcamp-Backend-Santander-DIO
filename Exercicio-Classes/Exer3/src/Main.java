/*
* Escreva um código que receba 3 valores separados por um caracter de sua escolha n vezes ( n é o número de vezes que o usuário desejar informar)
* ex.: nome;Lucas;Texto. Quando o usuário parar de informar valores o código deve retornar todos esses campos compondo
* um json, um xml e um yaml (Json: https://pt.wikipedia.org/wiki/JSON, XML: https://pt.wikipedia.org/wiki/XML,
* yaml: https://www.treinaweb.com.br/blog/o-que-e-yaml) as entradas devem seguir o seguinte padrão:

    NOME_CAMPO;VALOR;TIPO;
    Os tipos que devem ser aceitos são: texto, datas, data e hora, números inteiros, números com pontos flutuantes, boleanos,
    * array dos tipos anteriores ( opcional, possibilitar definir arrays de objetos e objetos internos).
*/

import MainScreen.SwitchOps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String [] formatos = new String[] {"Json", "XML", "yml", "Canselar"};
        List <String> info = new LinkedList<>();
        boolean loop = true;

        do{
            //Entrada de caracter de interrupção
            System.out.printf("Digite um caracter de interrupção (ex: ; - , | ...): ");
            String charInterrupcao = String.valueOf(scan.next().charAt(0));

            scan.nextLine();

            //Entrada de informações
            boolean entradaLoop = true;
            System.out.println("Digite as informações:");
                //Loop de entra de dados
            do{
                String input = scan.nextLine();

                if (input.contains(charInterrupcao)){
                    info.add(input.replace(charInterrupcao, ""));
                    System.out.println(info);
                }
                else entradaLoop = false;

            }while(entradaLoop);

            //Escolha de formato de tratamento

            int escol = SwitchOps.escolhaArray(formatos);
            String format = formatos[escol];

            switch (format){
                case "Json":
                    //Tratamento

                    //Saída de informação
                    break;
                case "XML":
                    //Tratamento

                    //Saída de informação
                    break;
                case "yml":
                    //Tratamento

                    //Saída de informação
                    break;
                case "Canselar":
                    break;
            }

        }while(loop);


    }

}
