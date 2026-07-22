//Listas com valores únicos
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Teste2 {
    public static void main(String[] args){
        Set<User2> users = new TreeSet<>(/*(User2 u1,User2 u2) -> {
            var compareResult = 0;
            if(u1.getId() < u2.getId()) compareResult--;
            if(u1.getId() > u2.getId()) compareResult++;
            return compareResult;
        }*/ Comparator.comparingInt(User2::getId).reversed());
        users.add(new User2(1, "Jão"));
        users.add(new User2(2, "Levy"));
        users.add(new User2(3, "Luca"));
        users.add(new User2(4, "Karol"));

        System.out.println(users);
    }
}
