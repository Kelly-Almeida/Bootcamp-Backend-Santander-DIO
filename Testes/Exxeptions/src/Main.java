
import br.com.dio.dao.UserDao;
import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.MenuOption;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import static br.com.dio.validator.UserValidator.verifyModel;

public class Main {

    private final static UserDao dao = new UserDao();
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ValidatorException {

        while (true){
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Procurar pelo id");
            System.out.println("5 - Listar usuários");
            System.out.println("6 - Sair");

            //ADICIONAR ENTRATRA DE STRING E TRATA-LA
            int inputOption = scan.nextInt();

            var selectedOption = MenuOption.values()[inputOption - 1];
            switch (selectedOption){
                case SAVE -> {
                    try{
                        UserModel user = dao.save(toSave());
                        System.out.printf("Usuário cadastrado %s\n", user);
                    }catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                    }

                }
                case UPDATE -> {
                    try{
                        UserModel user = dao.update(toUpdate());
                        System.out.printf("Usuário atualizado %s\n", user);
                    }catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }finally {
                        System.out.println("=====================");
                    }

                }
                case DELETE -> {
                    try{
                        dao.delete(resquestId());
                        System.out.println("Usuário deletado");
                    }catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        System.out.println("=====================");
                    }

                }
                case FIND_BY_ID -> {
                    try{
                        var id = resquestId();
                        UserModel user = dao.findById(id);
                        System.out.printf("Usuários cadastrado com id %d: %s", id,user);
                    }catch (UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }

                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados: ");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);

            }
        }

    }

    private static UserModel toSave() throws ValidatorException {
        System.out.println("Informe o nome do usuário: ");
        String name = scan.next();
        System.out.println("Informe o email do usuário: ");
        String email = scan.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        String birthdayString = scan.next();

        //Tratamento de string para data
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);


        return validateInputs(0, name, email, birthday);


    }

    public static UserModel validateInputs(final long id, final String name,
                               final String email, final LocalDate birthday) throws ValidatorException {
        UserModel user = new UserModel(0, name, email, birthday);
        verifyModel(user);
        return user;

    }

    private static UserModel toUpdate() throws ValidatorException {
        long id = resquestId();
        System.out.println("Informe o nome do usuário: ");
        String name = scan.next();
        System.out.println("Informe o email do usuário: ");
        String email = scan.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        String birthdayString = scan.next();

        //Tratamento de string para data
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return validateInputs(0, name, email, birthday);

    }

    private static long resquestId(){
        System.out.println("Informe o id: ");
        return scan.nextLong();
    }
}