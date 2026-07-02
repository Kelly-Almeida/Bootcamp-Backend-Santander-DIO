public class SaudeBemEstar extends Produto{
    private String tipo;
    public SaudeBemEstar(){this.tipo = "Saude e bem estar";}

    @Override
    public float setImposto() {
        return 0.015F;
    }
}
