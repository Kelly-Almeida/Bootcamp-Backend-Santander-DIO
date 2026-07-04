public class Alimentacao extends Produto{
    private String tipo;

    public Alimentacao(){
    }

    @Override
    public String getTTipo() {
        return "Alimentação";
    }


    @Override
    public float setImposto() {
        return 0.01F;
    }
}
