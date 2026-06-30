public class IngressoMeia extends Ingresso{
    private float valor;
    private int numCarteirinha;

    public IngressoMeia(float valor, String filme, boolean dublado, int numCarteirinha){
        super(valor, filme, dublado);

        this.numCarteirinha = numCarteirinha;

        this.valor = valor/2;

    }

    public int getNumCarteirinha(){return this.numCarteirinha;}

    @Override
    public void showIngresso(){
        System.out.println("------------ Ingresso Meia ------------");
        System.out.println("Filme: " + getFilme());
        System.out.println(getDublado() ? "Dublado": "Legendado");
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Número de confirmação do benéficio:\n"+this.numCarteirinha);
    }
}
