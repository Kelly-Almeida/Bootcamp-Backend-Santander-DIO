public class Alimentacao extends Produto{
    private String tipo;

    public Alimentacao(){
        this.tipo = "Alimentação";

    }

    @Override
    public float setImposto() {
        return 0.01F;
    }
}
