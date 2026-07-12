package domain2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static domain2.ContactType.*;
import static  domain2.Sex.*;

public class Teste10 {
    public static void main(String[] args){
        List<User> users = new ArrayList<>(genereteUsers());

        //users.sort(Comparator.comparing(User::name, Comparator.reverseOrder()));
        //var usersFiltered = users.stream().filter(u -> u.contacts().size() >= 2).toList();
        /*var usersFiltered = users.stream()
                .filter(u -> u.contacts() == null && u.contacts().isEmpty())
                        .toList();*/
        /*var usersFiltered = users.stream()
                        .filter(u -> u.contacts().stream().anyMatch(c -> c.type() == EMAIL))
                                .toList();*/
        /*var usersFiltered = users.stream()
                .flatMap(u -> u.contacts().stream())
                .filter(c -> c.type() == EMAIL)
                .sorted((c1, c2) -> c1.description().compareTo(c2.description()))
                .map(c -> String.format("{\n    'description': '%s', \n     'type': '%s'\n}", c.description(), c.type()))
                .toList();*/

        /*var usersFiltered = users.stream()
                .flatMap(u -> u.contacts().stream())
                .filter(c -> c.description().contains("gmail"))
                .toList();*/

        /*var usersFiltered = users.stream()
                        .flatMap(u -> u.contacts().stream())
                        .filter(c -> c.type() == PHONE)
                        .map(c -> c.description().replace("(", "")
                                .replace(")", "")
                                .replace("-", ""))
                        .mapToLong(Long::parseLong)
                                .min();*/

        var usersFiltered = users.stream()
                .filter(u -> u.sex() == FAMALE)
                        .collect(Collectors.toMap(User::name, user -> user));

        //usersFiltered.forEach(System.out::println);

        System.out.println(usersFiltered);

    }

    private static List<User> genereteUsers(){
        var contacts1 = List.of(
                new Contact("8864258133", PHONE),
                new Contact("joao@gmail@gmail.com", EMAIL)
        );

        var contacts2 = List.of(
                new Contact("maria@marias.com", EMAIL)
        );

        var contacts3 = List.of(
                new Contact("234567890321", PHONE),
                new Contact("karol@git.com", EMAIL)
        );

        var contacts4 = List.of(
                new Contact("12345678921", PHONE)
        );

        var contacts5 = List.of(
                new Contact("098765432123", PHONE),
                new Contact("theo@gamil.com", EMAIL)
        );

        var user1 = new User("João", 26, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Maria", 31, FAMALE, new ArrayList<>(contacts2));
        var user3 = new User("Karoline", 23, FAMALE, new ArrayList<>(contacts3));
        var user4 = new User("Levy", 29, MALE, new ArrayList<>(contacts4));
        var user5 = new User("Theodor", 19, MALE, new ArrayList<>(contacts5));

        return List.of(user1, user2, user3, user4, user5);
    }
}
