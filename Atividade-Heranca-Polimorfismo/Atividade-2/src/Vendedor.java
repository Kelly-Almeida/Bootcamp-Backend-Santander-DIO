import java.util.List;
import java.util.Scanner;

public class Vendedor extends Colaborador{
    Scanner scan = new Scanner(System.in);

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);

    }

    @Override
    public void consultarVendas(List<Venda> vendas) {return;}

    public Venda setVenda(){
        System.out.println("=================Cadastro de vendas=================");
        System.out.printf("Digite o nome do produto: ");
        String produto;
        do{
            produto = scan.nextLine();

            if(produto.isEmpty()){
                System.out.println("Digite um produto!!");
            }

        }while(produto.isEmpty());

        System.out.printf("Digite o valor da venda: ");
        float valor;
        do{
            valor = scan.nextFloat();

            if (valor <= 0){
                System.out.println("Digite um valor válido!!");
            }
        }while(valor <= 0);

        return new Venda (produto, valor);
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
