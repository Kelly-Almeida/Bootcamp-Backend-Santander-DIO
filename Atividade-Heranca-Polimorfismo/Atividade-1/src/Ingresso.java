public class Ingresso {
    private float valor;
    private String filme;
    private boolean dublado;

    public Ingresso(float valor, String filme, boolean dublado){
        this.valor = valor;
        this.filme = filme;
        this.dublado = dublado;
    }

    public float getValor(){return this.valor;}
    public String getFilme(){return this.filme;}
    public  boolean getDublado(){return this.dublado;}

    public void showIngresso(){
        System.out.println("------------ Ingresso Comum ------------");
        System.out.println("Filme: " + this.filme);
        System.out.println(this.dublado ? "Dublado": "Legendado");
        System.out.println("Valor: R$" + this.valor);
    }
}
