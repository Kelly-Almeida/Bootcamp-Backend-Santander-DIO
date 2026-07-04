public class Vestuario extends Produto{

    public Vestuario(){}

    @Override
    public String getTTipo() {
        return "Vestuário";
    }

    @Override
    public float setImposto() {
        return 0.025F;
    }
}
