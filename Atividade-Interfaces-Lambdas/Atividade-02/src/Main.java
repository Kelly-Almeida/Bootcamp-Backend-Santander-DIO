import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import MainScreen.Header;
import MainScreen.SwitchOps;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Títulos
        Header tituloPrincipal = new Header("Sistema Tarifário", 2);
        Header tituloVerificacao = new Header("Verificar tarifas", 2);
        Header tituloHistorico = new Header("Histórico", 3);

        //Variáveis compostas
        String [] ops = new String[] {"Verificar tarifa de um produto", "Histórico de pesquisas", "Sair"};
        String [] opsProdutos = new String[] {"Alimentação", "Saude e bem estar", "Vestuário", "Cultura", "Voltar"};
        List<Produto> historico = new ArrayList<>();

        boolean loop = true;

        do{
            //Tela inicial
            tituloPrincipal.Header();
            System.out.println("Digite para...");
            int escol  = SwitchOps.escolhaArray(ops);
            String UserSwitch = ops[escol];

            //Direcinamento de escolha
            switch (UserSwitch){
                case "Verificar tarifa de um produto":
                    tituloPrincipal.Header();
                    escol = SwitchOps.escolhaArray(opsProdutos);
                    UserSwitch = opsProdutos[escol];
                    switch (UserSwitch){
                        case "Alimentação":
                            Alimentacao newAlimentacao = new Alimentacao();
                            historico.add(newAlimentacao);
                            break;
                        case "Saude e bem estar":
                            SaudeBemEstar newSBE = new SaudeBemEstar();
                            historico.add(newSBE);
                            break;
                        case "Vestuário":
                            Vestuario newVestuario = new Vestuario();
                            historico.add(newVestuario);
                            break;
                        case "Cultura":
                            Cultura newCultura = new Cultura();
                            historico.add(newCultura);
                            break;
                        case "Voltar":
                            break;
                    }
                    break;
                case "Histórico de pesquisas":
                    tituloHistorico.Header();
                    if (historico.size() == 0){
                        System.out.println("Não há ainda nenhuma consulta regitrada\n\n");
                    }else{
                        int i = 1;
                        for(Produto prod : historico){
                            System.out.println("\t"+i + " -  Produto: " + prod.getNome() + " \n\tTipo: "+prod.getTTipo()+"\n\tValor unitário: R$" + prod.getValorUni() + "\n\tValor com impostos: R$" + prod.getValorCImposto() + "\n");
                            i++;
                        }
                    }
                    break;
                case "Sair":
                    break;
            }
        }while(loop);
        System.out.println("Tenha uma boa noite!!!");
    }
}