import java.util.List;

public class Gerente extends Colaborador{
    private boolean adm;

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.adm = true;
    }

    public void consultarVendas(List<Venda> vendas){
        if (vendas.size() == 0){
            System.out.println("Não há vendas ainda!!");
        }else{
            System.out.println("--------------------Vendas--------------------");
            System.out.println("Quantidade de vendas: " + vendas.size());
            for (int i = 0; i < vendas.size(); i++){
                System.out.printf("%d - %s, valor R$ %f", (i + 1), vendas.get(i).getProduto(), vendas.get(i).getValor());
            }
        }
    }

    @Override
    public Venda setVenda() {
        return null;
    }

    @Override
    public void receberPagamento() {
        return;
    }

    @Override
    public void fecharCaixa() {

    }

    @Override
    public void getCaixa() {

    }

}
