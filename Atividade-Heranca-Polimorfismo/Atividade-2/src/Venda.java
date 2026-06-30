public class Venda {
    private String produto;
    private float valor;

    public Venda(String produto, float valor){
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto(){return this.produto;}
    public float getValor(){return this.valor;}
}
