import MainScreen.Header;
import MainScreen.SwitchOps;
import MainScreen__202607261925.headers.HeaderType;
import MainScreen__202607261925.headers.Headers;

public class Main {
    static void main(String[] args) {
        Headers t1 = new Headers("FODA-SE", HeaderType.CROSS_SOLID);
        String [] ops = new String[] {"Tapa", "Surra", "Murro", "Morte"};

        t1.show();

        System.out.println("Digite o indigena merece..");
        SwitchOps.escolhaArray(ops);
    }
}
