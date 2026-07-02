public class Vestuario extends Produto{
    private String tipo;
    public Vestuario(){this.tipo = "Vestuário";}

    @Override
    public float setImposto() {
        return 0.025F;
    }
}
