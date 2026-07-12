import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Teste6 {
    private static Object BigDecimal;

    public static void main(String[] args){
        var value1 = 0.1f;
        var value2 = 0.2f;

        System.out.println("Teste com Double e float");
        System.out.println(value1 + value2);

            System.out.println(new Double(2.00 - 1.1));
            System.out.println(new Double(2.00 - 1.2));
            System.out.println(new Double(2.00 - 1.3));
            System.out.println(new Double(2.00 - 1.4));
            System.out.println(new Double(2.00 - 1.5));
            System.out.println(new Double(2.00 - 1.6));
            System.out.println(new Double(2.00 - 1.7));
            System.out.println(new Double(2.00 - 1.8));
            System.out.println(new Double(2.00 - 1.9));
            System.out.println(new Double(2.00 - 2));

        System.out.println("\tConclusão: não é a melhor escolha para calculos muito precisos\n");
        System.out.println("Teste com BigDecimal");

        var value3 = new BigDecimal("0.1");
        var value4 = new BigDecimal("0.2");

        System.out.println(value3.add(value4)); //Soma

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1"))); //SUbtração
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("2.0")));

        var value5 = new BigDecimal("56.3645");
        var value6 = new BigDecimal("99.345");
        System.out.println(value6.divide(value5, 1,RoundingMode.HALF_UP));//Divisão
        System.out.println(value6.negate());//Negando valores
        System.out.println(value5.sqrt(new MathContext(2)));//Raiz quadrada
        System.out.println(value6.pow(new MathContext(2).getPrecision()));

    }
}
