package br.com.dio;

import br.com.dio.persistence.ConnectionUtil;
import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    static void main(String[] args) throws SQLException {
        /*try(var connection = ConnectionUtil.getConnection()){
            System.out.println("Conectou!!");

        }catch(SQLException ex){
            ex.printStackTrace();
        }*/


        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/test", "root", "25164036")
                .load();

        flyway.repair(); //Repara problemas da bibliotecas e ambiente

        flyway.migrate();

        /*
        //Inserindo dados
        var employee = new EmployeeEntity();
        employee.setName("Amanda");
        employee.setSalary(new BigDecimal("2400"));
        employee.setBirthday(OffsetDateTime.now().minusYears(18). minusMonths(11).minusDays(23));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);

         */

        /*
        //SELECT * FROM
        employeeDAO.findAll().forEach(System.out::println);

         */

        /*
        //Select
        System.out.println(employeeDAO.findById(20));
         */

        /*
        //Update
        var employee = new EmployeeEntity();
        employee.setId(1);
        employee.setName("Theodor");
        employee.setBirthday(OffsetDateTime.now().minusYears(23).minusDays(134));
        employee.setSalary(new BigDecimal("4500"));

        employeeDAO.update(employee);

         */

        employeeDAO.delete(4);
    }
}