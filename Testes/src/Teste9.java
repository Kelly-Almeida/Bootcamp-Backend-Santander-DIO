import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Teste9 {
    public static void main(String[] args){
        var value1 = Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .toList();
                //.toArray(Integer[]::new); // Igual a var test = new Interger[];

        for (var v: value1){
            System.out.println(v);
        }

        System.out.println("===========================");
        var value2 = IntStream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray();

        for(var v: value2){
            System.out.println(v);
        }

        List<String> debugValues = new ArrayList<>();

        var value3 = Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                //.peek(System.out::println) //Para debugar
                .peek(debugValues::add)
                .filter(name -> name.endsWith("a"))
                .toList();

        System.out.println(value3);
        System.out.println(debugValues);

        System.out.println("===========");
        var value4 = Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                .filter(n -> n.endsWith("o"))
                //.allMatch(n -> n.contains("a" ))
                .findFirst();
                //.anyMatch(n -> n.contains("a")); //Verifica se há pelomenos um elemento com esse elemento


        System.out.println(value4);

        System.out.println("========================");
        var value = Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                .reduce("", (a, b) -> a + b + ";");

        var value01 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 7)
                .average();

        var value02 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 7)
                .reduce(Integer::sum);

        var value03 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 7)
                .distinct().toList();

        System.out.println(value);
        System.out.println("===================");

        var value04 = Stream.of(1,2,3,4,5,6,7,8,7,8,7,8)
                .map(Object::toString)
                .toList();

        System.out.println(value04);

        var value05 = Stream.of(1,2,3,4,5,6,7,8,7,8,7,8)
                .map(n -> n % 2 == 0)
                .toList();

        List<Integer> values1 = List.of(3, 6, 9, 12);
        List<Integer> values2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        var newValues = values1.stream().filter(values1::contains).map(n -> values1.stream().reduce(n, (n1, n2) -> n1 - n2));

        System.out.println(values1);
        System.out.println(newValues);
     }
}
