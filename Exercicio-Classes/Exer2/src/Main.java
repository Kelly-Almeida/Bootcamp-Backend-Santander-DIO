import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map map = PhoneChecks.isPhoneNumber("12n34y56892");

        System.out.println(map.toString());
    }
}
