import java.util.HashMap;
import java.util.Map;

public class Teste4 {
    public static void main(String[] args){
        var value = "java;java;java;java";

        //Substituição
        value = value.replace("j", "J");

        System.out.println(value);

        //Subistitui algo e quebra a linha
        var values = value.split(";", 4);

        for(var v : values){
            System.out.println(v);
        }


        System.out.println(value.toLowerCase());
        System.out.println(value.toUpperCase());

        //Verificando se há em um elemento
        System.out.println(value.contains(";"));
        System.out.println(value.contains("P"));

        //Retornando a posição de um elemento
        System.out.println(value.indexOf("j", 1, 10));

        System.out.println(value.startsWith("ja"));
        System.out.println(value.endsWith("ja"));

        //Verificação de vazios
        var vazio = "";
        var vazioEspaco = "  ";
        var comEspacos = "  o   ";

        System.out.println(vazio.isEmpty());
        System.out.println(vazioEspaco.isBlank());

        System.out.println(comEspacos.trim());

        var valor = "/******java******/";
        System.out.println(valor.substring(7, 11));

        var valorJSON = """
                {"name": "Karoline","age": 18}
                """;
        Map<String, String> map = new HashMap<>();
        valorJSON = valorJSON.replace("{", "").replace("}", "").replace("\"", "");
        var valueArr = valorJSON.split(",");
        for(var v: valueArr){
            var keyValue = v.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map);


        var valueRepeat = "a";
        System.out.println(valueRepeat.repeat(5));


    }
}
