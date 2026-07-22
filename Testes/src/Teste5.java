import java.time.Duration;
import java.time.OffsetDateTime;

public class Teste5 {
    public static void main(String[] args) {
        var builder = new StringBuilder("1234567890");
        System.out.println(builder.delete(0, 2));
        System.out.println(builder.deleteCharAt(1));
        System.out.println(builder.reverse());
        System.out.println(builder.lastIndexOf("7"));
        System.out.println(builder.insert(3, "a"));
        System.out.println(builder.append("o"));

    }
}
