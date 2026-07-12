import domain2.Contact;

import java.util.List;

public record UserV2(String name, int age, SexEnum sex, List<Contact> contacts) {

}
