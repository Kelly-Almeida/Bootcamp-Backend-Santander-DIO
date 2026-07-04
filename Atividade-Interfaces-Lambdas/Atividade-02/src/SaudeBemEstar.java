public class SaudeBemEstar extends Produto{
    public SaudeBemEstar(){}

    @Override
    public String getTTipo() {
        return "Saúde e bem estar";
    }

    @Override
    public float setImposto() {
        return 0.015F;
    }
}
