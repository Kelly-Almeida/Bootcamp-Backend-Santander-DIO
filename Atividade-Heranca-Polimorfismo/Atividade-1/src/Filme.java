public class Filme {
    private String nome;
    private float valorIngressoComum;
    private boolean dublado;
    private int tempoDuracao;

    public Filme(String nome, float valorIngressoComum, boolean dublado, int tempoDuracao){
        this.nome = nome;
        this.valorIngressoComum = valorIngressoComum;
        this.dublado = dublado;
        this.tempoDuracao = tempoDuracao;
    }

    public String showFilme(){return "\t\t" +this.nome + "\n\tTempo: " + this.tempoDuracao + " minutos | " + (this.dublado ? "Dublado": "Legendado") + "\n\tValor do ingresso comum: R$" + this.valorIngressoComum;}

    public String getNome(){return this.nome;}
    public float getValorIngressoComum(){return this.valorIngressoComum;}
    public boolean getDublado(){return this.dublado;}

}
