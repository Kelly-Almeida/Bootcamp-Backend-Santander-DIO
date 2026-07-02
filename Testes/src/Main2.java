import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.jar.Manifest;

public class Main2{
    interface OperacaoMatematica{
        int calcular(int a, int b);
    }

    interface ManipuladorString{
        String manipular (String string);
    }
    public static void main(String[] args){
        //Com números
        OperacaoMatematica soma = (a, b) -> a + b;

        System.out.println(soma.calcular(2, 6));

        OperacaoMatematica multiplicacao = (a, b) -> a * b;

        System.out.println(multiplicacao.calcular(10, 5));

        //Com string
        ManipuladorString maiuscula = (string) -> string.toUpperCase(Locale.ROOT);
        System.out.println(maiuscula.manipular("Karol"));

        //Usando filter
            //Sem lambda
        List<String> palavras = Arrays.asList("java", "Karol", "Levy");

        List<String> palavrasFiltradas = new ArrayList<>();
        for (String palavra : palavras){
            if (palavra.length() >= 5){palavrasFiltradas.add(palavra);}
        }
        System.out.println(palavrasFiltradas);
            //Com lambda
        List<String> palavrasFiltradas2 = palavras.stream().filter(s -> s.length() >= 5).toList();
        System.out.println(palavrasFiltradas2);

        //Filtros com objetos
        List<User> pessoas = Arrays.asList(
            new User("Levy", 23),
            new User("Karol", 20),
            new User("Theodor", 32)
        );

        List<String> nomes = pessoas.stream().map(pessoa -> pessoa.getName()).toList();
        List<Integer> idades = pessoas.stream().map(User::getAge).toList();

        System.out.println(nomes);
        System.out.println(idades);



        printStringValue(User::getName, pessoas);


    }

    private static void printStringValue(Function<User, String> callback, List<User>users){
        users.forEach(u -> System.out.println(callback.apply(u)));
    }
}
