import java.util.List;
import keyword.*;

public class Main {
    public static void main(String[] args){
        List<User> users = List.of(new User("Karoline", 23), new User("Levy", 29), new User("Samanta", 23));
        users.forEach(user -> System.out.println(user.getName()));

        Client cliente = new Client();
        cliente.setName("Karol");
        cliente.setAge(20);

        System.out.println("Cliente: " + cliente.getName() + ", Idade: " + cliente.getAge() + " anos");
    }
}