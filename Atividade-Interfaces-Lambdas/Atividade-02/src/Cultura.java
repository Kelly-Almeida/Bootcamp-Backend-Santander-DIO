public class Cultura extends Produto{
    private String tipo;

    public Cultura(){this.tipo = "Cultura";}

    @Override
    public float setImposto() {
        return 0.04F;
    }
}
