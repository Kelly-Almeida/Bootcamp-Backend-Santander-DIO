import java.util.Optional;

public class Teste8 {
    public static void main(String[] args){
        Optional<User3> optional =  Optional.ofNullable(new User3("Karoline", 20, SexEnum.Feminino));//Para que aceite um null tem que apresentar um ofNullable
        //System.out.println(optional.get());


        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(
                user -> System.out.printf("Usuário: %s", user),
                () -> System.out.println("Não foi informado um usuário")
                );


        System.out.println(optional.orElse(new User3("Levyatha", 21, SexEnum.Masculino))); // dafault

        System.out.println(optional.orElseThrow(() -> new RuntimeException("")));

        System.out.println("-------Acionando valor default-------");
        System.out.println(optional.orElse(defaultUser())); //Trabalha sem lambda
        System.out.println(optional.orElseGet(Teste8::defaultUser));

        System.out.println("Map");
        var users = optional.map(user -> new User3(user.name(), user.age(), user.sex()));

        System.out.println(users.orElseThrow());
    }

    public static User3 defaultUser(){
        return new User3("Theodor", 23, SexEnum.NaoDeclarar);
    }
}
