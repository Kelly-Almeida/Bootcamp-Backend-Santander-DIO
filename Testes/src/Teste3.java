import domain.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Teste3 {
    public static void main(String[] args){
        Map<String, Usuario> users = new HashMap<>();
        users.put("joao@joao.com", new Usuario("João", 22));
        users.put("maria@maria.com", new Usuario("Mária", 32));
        users.put("theo@the.com", new Usuario("Theodor", 42));
        users.put("Levy@levy.com", new Usuario("Levy", 28));

        System.out.println(users);

        Map<String, Usuario> users2= new HashMap<>();
        users2.put("karol@karol.com", new Usuario("Karoline", 21));
        users2.put("cezar@cezar.com", new Usuario("Cézar", 32));
        users.putAll(users2);

        System.out.println(users);

        //Procura de itens
        System.out.println(users.containsKey("karol@karol.com"));
        System.out.println(users.containsValue(new User("Levy", 89)));

        //Remoção de itens
        System.out.println(users.remove("joao@joao.com", new Usuario("João", 22)));

        //Modificar valor
        users.forEach((k, v) -> System.out.printf("key: %s | value: %s\n", k, v));
        users.replace("joao@joao.com", new Usuario("João", 54));

        System.out.println("=====================================================");
        users.forEach((k, v) -> System.out.printf("key: %s | value: %s\n", k, v));

        System.out.println(users.containsKey("leo@leo.com"));

        users.merge("", new Usuario("", -1), (user, user2)->{
            System.out.println(users);
            System.out.println(users2);

            return user2;
        });
        System.out.println(users);

        users.putIfAbsent("fghjk,.", new Usuario("", -2));
        System.out.println(users);
    }
}
