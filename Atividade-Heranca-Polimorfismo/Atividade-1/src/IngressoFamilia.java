public class IngressoFamilia extends Ingresso{
    private float valor;
    private int numPessoas;

    public IngressoFamilia(float valor, String filme, boolean dublado, int numPessoas){
        super(valor, filme, dublado);
        this.numPessoas = numPessoas;

        this.valor = valor * this.numPessoas;

        if (this.numPessoas > 3){
            this.valor *= 0.95F;
        }
    }

    public int getNumPessoas(){return this.numPessoas;}

    @Override
    public void showIngresso(){
        System.out.println("------------ Ingresso Família ------------");
        System.out.println("Filme: " + getFilme());
        System.out.println(getDublado() ? "Dublado": "Legendado");
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Número de pessoas:"+this.numPessoas);
    }
}
