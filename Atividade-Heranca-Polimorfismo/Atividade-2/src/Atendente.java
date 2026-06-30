import java.util.List;

public class Atendente extends Colaborador{
    private float caixa;
    private boolean caixaFechado;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
        this.caixa = 0.00F;
        this.caixaFechado = false;
    }

    @Override
    public void consultarVendas(List<Venda> vendas){return;}

    @Override
    public Venda setVenda() {
        return null;
    }


    public void receberPagamento(){
        if (caixaFechado) {
            System.out.println("O caixa foi fechado!!");
        }else{

            float valor;
            do{
                System.out.printf("\nDigite o valor que foi rescebido: R$");
                valor = scan.nextFloat();

                if (valor <= 0){
                    System.out.println("Digite um valor válido!!");
                }
            }while(valor <= 0);

            this.caixa += valor;
        }
    }
    public void fecharCaixa(){
        if (this.caixaFechado){
            System.out.println("O caixa já foi fechado!!");
            System.out.println("Total do dia: R$" + this.caixa);
        }else{
            this.caixaFechado = true;
            System.out.println("Caixa fechado!!");
        }
    }
    public void getCaixa(){
        if(this.caixaFechado){
            System.out.println("Valor do caixa: R$" + this.caixa);
        }else{
            System.out.println("O caixa ainda não foi fechado!!");
        }

    }
}
