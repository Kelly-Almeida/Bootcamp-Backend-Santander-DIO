public class Cultura extends Produto{

    public Cultura(){}

    @Override
    public String getTTipo() {
        return "Cultura";
    }

    @Override
    public float setImposto() {
        return 0.04F;
    }
}
