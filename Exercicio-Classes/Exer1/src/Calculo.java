import java.util.ArrayList;
import java.util.List;

public enum Calculo implements MathOperation{
    SOMA('+'){
        @Override
        public float calcular(float ... numbers) {
            float result = 0;
            for (float n: numbers) result += n;
            return result;
        }
    },
    SUB('-'){
        @Override
        public float calcular(float... numbers) {
            float result = numbers[0];
            for(int i = 1; i < numbers.length; i++)result -= numbers[i];
            return result;
        }
    },
    MULT('x'){
        @Override
        public float calcular(float... numbers) {
            float result = 1;
            for (float n : numbers)result *= n;
            return result;
        }
    },
    DIV('/'){
        @Override
        public float calcular(float... numbers) {
            float result = numbers[0];
            for(int i = 1; i < numbers.length; i++) result /= numbers[i];
            return result;
        }
    };

    private final char symbol;

    Calculo(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){return this.symbol;}


    @Override
    public String registro(float ... numbers) {
        if (numbers == null || numbers.length == 0) return "";
        else{
            StringBuilder operacao = new StringBuilder();

            for (int i = 0; i < numbers.length; i++){
                operacao.append(numbers[i]);
                if(i < numbers.length - 1){
                    operacao.append(" ").append(this.symbol).append(" ");
                }
            }

            return "%s = %.2f".formatted(operacao.toString(), calcular(numbers));
        }
    }
}
