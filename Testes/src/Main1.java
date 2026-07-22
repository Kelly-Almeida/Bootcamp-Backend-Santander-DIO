import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Main1 {
    public static void main(String[] args){
        Set<User2> users = new HashSet<>();
        users.add(new User2(1, "Jão"));
        users.add(new User2(2, "Levy"));
        users.add(new User2(3, "Luca"));
        users.add(new User2(4, "Karol"));


        //Sem lambda
        var iterator = users.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Com lambda
        users.forEach(System.out::println);


        //Comparando elementos com Hash
        System.out.println(new User2(1, "Jão").hashCode());

        System.out.println(users.contains(new User2(1, "Jão")));

        //Novo teste: Removendo elementos
        users.removeAll(Arrays.asList(new User2(1, "Jão"), new User2(2, "Samantha")));

        users.removeIf(user -> user.getId() > 3);

        users.removeIf(Predicate.not(user -> user.getId() % 2 != 0));

        users.forEach(System.out::println);
    }
}