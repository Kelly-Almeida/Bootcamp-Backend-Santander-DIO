import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

        boolean round = true;
        String [] telaInicial = new String[] {"Cadastrar usuário", "Ver lista de colaboradores","Entrar", "Sair"};
        String [] tiposUsuarios = new String[] {"Gerente", "Vendedor", "Atendente", "Voltar"};
        String [] opGerente = new String[] {"Consultar vendas","Alterar dados","Logout"};
        String [] opVendedor = new String[] {"Cadastrar venda", "Alterar dados", "Logout"};
        String [] opAtendente = new String[] {"Receber pagamento", "Fechar caixa", "Ver valor do caixa","Alterar dados", "Logout"};
        String [] opSetDados = new String[] {"Nome", "Email", "Senha"};
        List <Colaborador> colaboradores = new ArrayList<>();
        List <Venda> vendas = new ArrayList<>();

        int escolhaUser;
        boolean loop;

        do{
            //TELA INICIAL
            telaInicial();
            System.out.println("Digite ...");

            mostrarOpccoes(telaInicial);
            System.out.printf("=> ");
            do{
                loop = false;
                escolhaUser = scan.nextInt();

                if (escolhaUser < 1 || escolhaUser > telaInicial.length){
                    loop = true;
                    System.out.println("Digite um valor válido!!");
                }
            }while(loop);

            escolhaUser--;
            String resp = telaInicial[escolhaUser];

            switch (resp){
                //CADASTRO
                case "Cadastrar usuário":
                    System.out.println("====================================");
                    System.out.println("\tCadastro de usuário");
                    System.out.println("====================================");
                    System.out.println("Digite para cadrastar um...");
                    mostrarOpccoes(tiposUsuarios);

                    System.out.printf("=> ");
                    do{
                        loop = true;
                        escolhaUser = scan.nextInt();


                        if (escolhaUser < 1 || escolhaUser > tiposUsuarios.length){
                            System.out.println("Digite uma opção válida!!");
                        }else{
                            loop = false;
                        }
                    }while(loop);

                    escolhaUser--;
                    resp = tiposUsuarios[escolhaUser];

                    String [] infoColaborador;
                    switch (resp){
                        case "Gerente":
                            infoColaborador = setInfoColadorador();
                            Gerente newGerente = new Gerente(infoColaborador[0], infoColaborador[1], infoColaborador[2]);
                            System.out.println("Gerente adicioando com sucesso!!");
                            colaboradores.add(newGerente);
                            break;
                        case "Vendedor":
                            infoColaborador = setInfoColadorador();
                            Vendedor newVendedor = new Vendedor(infoColaborador[0], infoColaborador[1], infoColaborador[2]);
                            System.out.println("Vendedor adicionado com sucesso!!");
                            colaboradores.add(newVendedor);
                            break;
                        case "Atendente":
                            infoColaborador = setInfoColadorador();
                            Atendente newAtendente = new Atendente(infoColaborador[0], infoColaborador[1], infoColaborador[2]);
                            System.out.println("Atendende adicionado com sucesso!!");
                            colaboradores.add(newAtendente);
                            break;
                        case "Voltar":
                            break;
                    }
                    break;
                //LISTA DE COLABORADORES
                case "Ver lista de colaboradores":
                    if (colaboradores.size() == 0){
                        System.out.println("Nenhum colaborador cadastrado!!");
                    }else{
                        int i = 1;
                        for (Colaborador colaborador : colaboradores){
                            System.out.println(i + " - " + colaborador.getNome() +" " + colaborador.getClass().getSimpleName());
                            i++;
                        }
                    }
                    break;
                //LOGIN
                case "Entrar":
                    System.out.println("================================");
                    System.out.println("\t\tLogin");
                    System.out.println("================================");


                    boolean contTentando = true;
                    boolean menuInicial = false;
                    int emailLogin = 0;

                    scan.nextLine();

                    //LOGIN COM EMAIL E SENHA
                    do{
                        System.out.printf("Digite o email: ");
                        String emailInput;
                        emailInput = scan.nextLine();
                        boolean teste = true;

                        for (int i = 0; i < colaboradores.size(); i++){
                            if(colaboradores.get(i).getEmail().equals(emailInput)){
                                contTentando = false;
                                emailLogin = i;
                                teste = false;
                                break;
                            }
                        }

                        if (teste){
                            System.out.printf("\nEmail não encontrado!\nDeseja voltar ao menu inicial? \n1 - Sim \n2 - Não\n=> ");

                            int op = scan.nextInt();

                            if (op == 1){
                                contTentando = false;
                                menuInicial = true;
                            }else if (op == 2){
                                scan.nextLine();
                            }

                        }
                    }while(contTentando);

                    //VOLTA PARA TELA INICIAL
                    boolean logado = false;
                    if (!menuInicial){
                        logado = colaboradores.get(emailLogin).login();
                    }

                    //TELA DO USUÁRIO
                    while(logado){
                        switch (colaboradores.get(emailLogin).getClass().getSimpleName()){
                            //AÇÕES DO GERENTE: {"Consultar vendas","Alterar dados","Logout"}
                            case "Gerente":
                                telaInicial();
                                System.out.println("Digite para...");
                                mostrarOpccoes(opGerente);
                                System.out.printf("=> ");

                                do{
                                   escolhaUser = scan.nextInt();
                                   if (escolhaUser < 1 || escolhaUser > opGerente.length){
                                       System.out.println("Digite uma opção válida!!");
                                       loop = true;
                                   }else{
                                       loop = false;
                                   }
                                }while(loop);

                                escolhaUser--;
                                resp = opGerente[escolhaUser];

                                switch (resp){
                                    case "Consultar vendas":
                                        colaboradores.get(emailLogin).consultarVendas(vendas);
                                        break;
                                    case "Alterar dados":
                                        scan.nextLine();
                                        alterarDados(opSetDados, colaboradores, emailLogin);
                                        break;
                                    case "Logout":
                                        logado = colaboradores.get(emailLogin).logout();
                                        break;
                                }
                                break;
                            //AÇÕE DO VENDEDOR: {"Cadastrar venda", "Alterar dados", "Logout"}
                            case "Vendedor":
                                telaInicial();
                                System.out.println("Digite para...");
                                mostrarOpccoes(opVendedor);
                                System.out.printf("=> ");

                                do{
                                    loop = false;
                                    escolhaUser = scan.nextInt();

                                    if (escolhaUser < 1 || escolhaUser > opVendedor.length){
                                        loop = true;
                                        System.out.println("Digite uma opção válida!!");
                                    }
                                }while(loop);

                                escolhaUser--;
                                resp = opVendedor[escolhaUser];
                                switch (resp){
                                    case "Cadastrar venda":
                                        Venda newVenda = colaboradores.get(emailLogin).setVenda();
                                        vendas.add(newVenda);
                                        break;
                                    case "Alterar dados":
                                        scan.nextLine();
                                        alterarDados(opSetDados, colaboradores, emailLogin);
                                        break;
                                    case "Logout":
                                        logado = colaboradores.get(emailLogin).logout();
                                        break;
                                }
                                break;
                            //AÇÕES DO ATENDENTE: {"Receber pagamento", "Fechar caixa", "Ver valor do caixa","Alterar dados", "Logout"}
                            case "Atendente":
                                telaInicial();
                                System.out.println("Digite para...");
                                mostrarOpccoes(opAtendente);
                                System.out.printf("=> ");

                                do{
                                    loop = false;
                                    escolhaUser = scan.nextInt();

                                    if (escolhaUser < 1 || escolhaUser > opAtendente.length){
                                        loop = true;
                                        System.out.println("Digite uma opção válida!!");
                                    }
                                }while(loop);

                                escolhaUser--;
                                resp = opAtendente[escolhaUser];
                                switch (resp){
                                    case "Receber pagamento":
                                        colaboradores.get(emailLogin).receberPagamento();
                                        break;
                                    case "Fechar caixa":
                                        colaboradores.get(emailLogin).fecharCaixa();
                                        break;
                                    case "Ver valor do caixa":
                                        colaboradores.get(emailLogin).getCaixa();
                                        break;
                                    case "Alterar dados":
                                        scan.nextLine();
                                        alterarDados(opSetDados, colaboradores, emailLogin);
                                        break;
                                    case "Logout":
                                        logado = colaboradores.get(emailLogin).logout();
                                        break;
                                }
                                break;
                        }
                    }

                    break;

                case "Sair":
                    round = false;
                    break;
            }
        }while(round);
        System.out.println("Tenha uma boa noite!!");
    }

    public static void mostrarOpccoes(String [] ops){
        for (int i = 0; i < ops.length; i++){
            System.out.println((i + 1) + " - " + ops[i]);
        }
    }

    public static String[] setInfoColadorador(){
        scan.nextLine();

        System.out.printf("Digite o nome do coladorador: ");
        String [] info = new String[3];
        boolean loop = false;
        do{
            info[0] = scan.nextLine();

            if (info[0].isEmpty()){
                System.out.println("Digite um nome!!");

                loop = true;
            }
        }while(loop);

        loop = false;
        System.out.printf("Digite o email: ");
        do{
            info[1] = scan.nextLine();
            if (info[1].isEmpty()){
                System.out.println("Digite um email!!");
                loop = true;
            }
        }while(loop);

        loop = false;
        System.out.printf("Digite sua senha: ");
        do{
            info[2] = scan.nextLine();
            if (info[2].isEmpty()){
                System.out.println("Digite uma senha!!");
                loop = true;
            }
        }while(loop);

        return info;
    }

    public static void telaInicial(){
        System.out.println("===================================");
        System.out.println("\t\t torratudo");
        System.out.println("===================================");
    }

    public static void alterarDados(String [] opSetDados, List <Colaborador> colaboradores, int emailLogin){
        boolean loop;
        int escolhaUser;
        String resp;

        System.out.println("=================================");
        System.out.println("\tAlterar dados");
        System.out.println("=================================");
        System.out.println("Digite para...");
        mostrarOpccoes(opSetDados);
        System.out.printf("=> ");
        do{
            loop = false;
            escolhaUser = scan.nextInt();
            if (escolhaUser < 1 || escolhaUser > opSetDados.length){
                System.out.println("Digite uma opção válida!!");
                loop = true;
            }
        }while(loop);

        escolhaUser--;
        resp = opSetDados[escolhaUser];
        switch (resp){
            case "Nome":
                colaboradores.get(emailLogin).setNome();
                break;
            case "Email":
                colaboradores.get(emailLogin).setEmail();
                break;
            case "Senha":
                colaboradores.get(emailLogin).setSenha();
                break;
        }
    }
}