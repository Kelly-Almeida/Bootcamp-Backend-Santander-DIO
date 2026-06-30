import java.util.List;
import java.util.Scanner;

public abstract class Colaborador {
    Scanner scan = new Scanner(System.in);

    private String nome;
    private String email;
    private String senha;
    private boolean adm;
    private boolean login;

    public Colaborador(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.adm = false;

        this.login = false; //Todo usuário inicializa-se deslogado
    }

    /*Métodos de leitura*/
    public String getNome(){return this.nome;}
    public String getEmail(){return this.email;}
    public boolean checkSenha(String senhaInput) {return this.senha.equals(senhaInput);}
    public String getAdm(){return this.adm ? "Administrador": "Usuário comum";}
    public boolean getLogin(){return this.login;}

    /*Métodos de entrada e saida do sistema*/
    public boolean login(){

        System.out.println("--------------------------------");
        System.out.println("\t\tLogin");
        System.out.println("--------------------------------");
        System.out.printf("Email: " + getEmail());
        String senhaInput;
        int tentativa = 0;
        boolean bloquear = !validarAcesso();

        if(bloquear){
            System.out.println("Acesso a essa conta bloqueado!!!");
            return false;
        }else{
            System.out.println("Login bem sucedido!!");
            this.login = true;
            return true;
        }
    }
    public boolean logout(){

        if (getLogin()){
            System.out.printf("Tem certeza que deseja sair? \n1 - Sim \n2 - Não\n => ");
            int resp;
            boolean loop;
            do{
                resp = scan.nextInt();
                if (resp != 1 && resp != 2){
                    System.out.println("Digite um opção válida!!");
                    loop = true;
                }else{
                    loop = false;
                }
            }while (loop);

            if (resp == 1){
                this.login = false;
                System.out.println("Logout finalizado!!");
                return false;
            }
        }else{
            System.out.println("Você não está logado!!");
            return true;
        }
        return false;
    }

    /*Métodos de alteração de dados*/
    public void setNome(){
        if (validarAcesso()){
            System.out.printf("Digite o novo nome: ");
            String newNome;
            do {
                newNome = scan.next();
                if(newNome.isEmpty()){
                    System.out.println("Digite um nome!!");
                }else if(this.nome.equals(newNome)){
                    System.out.println("O novo nome não deve ser igual ao anterior!!");
                }
            }while(nome.isEmpty() || this.nome.equals(newNome));

            this.nome = newNome;
            System.out.println("Nome atualizado!!");
        }else{
            System.out.println("Acesso negado!!");
        }

    }
    public void setEmail(){
        if (validarAcesso()){
            System.out.printf("Digite o novo email: ");
            String newEmail;
            do {
                newEmail = scan.next();
                if(newEmail.isEmpty()){
                    System.out.println("Digite um email!!");
                }else if(this.email.equals(newEmail)){
                    System.out.println("O novo email não deve ser igual ao anterior!!");
                }
            }while(email.isEmpty() || this.email.equals(newEmail));

            this.email = newEmail;
            System.out.println("Email atualizado!!");
        }else{
            System.out.println("Acesso negado!!");
        }

    }

    public void setSenha(){
        if (validarAcesso()){
            scan.nextLine();
            System.out.printf("Digite a senha: ");
            String newSenha;
            do {
                newSenha = scan.next();
                if(newSenha.isEmpty()){
                    System.out.println("Digite um senha!!");
                }else if(this.senha.equals(newSenha)){
                    System.out.println("O novo senha não deve ser igual ao anterior!!");
                }
            }while(senha.isEmpty() || this.senha.equals(newSenha));

            this.senha = newSenha;
            System.out.println("Senha atualizado!!");
        }else{
            System.out.println("Acesso negado!!");
        }
    }

    private boolean validarAcesso(){
        String senhaInput;
        int tentativa = 0;
        while(tentativa != 4){
            System.out.printf("\nSenha de acesso: ");
            senhaInput = scan.nextLine();


            if (!checkSenha(senhaInput)){
                tentativa++;
                System.out.println("Senha incorreta!!!");

                if(tentativa == 3){
                    System.out.println("Limite de tentativas atingido!!");
                }
            }else{
                return true;
            }
        }

        return false;
    }


    public abstract void consultarVendas(List<Venda> vendas);
    public abstract Venda setVenda();

    public abstract void receberPagamento();

    public abstract void fecharCaixa();

    public abstract void getCaixa();
}
