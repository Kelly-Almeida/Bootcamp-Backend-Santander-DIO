package br.com.dio;

import br.com.dio.persistence.ConnectionUtil;
import br.com.dio.persistence.EmployeeAuditDAO;
import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();

    static void main(String[] args) throws SQLException {
        /*try(var connection = ConnectionUtil.getConnection()){
            System.out.println("Conectou!!");

        }catch(SQLException ex){
            ex.printStackTrace();
        }*/



        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/BootcampJava", "root", "25164036Ka!")
                .load();

        flyway.repair(); //Repara problemas da bibliotecas e ambiente

        flyway.migrate();

        /*
        //Inserindo dados
        var employee = new EmployeeEntity();
        employee.setName("Laura");
        employee.setSalary(new BigDecimal("2400"));
        employee.setBirthday(OffsetDateTime.now().minusYears(18). minusMonths(11).minusDays(23));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);



        //SELECT * FROM
        employeeDAO.findAll().forEach(System.out::println);

        //Select
        System.out.println(employeeDAO.findById(20));

        //Update
        employee = new EmployeeEntity();
        employee.setId(3);
        employee.setName("Theodor");
        employee.setBirthday(OffsetDateTime.now().minusYears(23).minusDays(134));
        employee.setSalary(new BigDecimal("4000"));

        employeeDAO.update(employee);

        employeeDAO.delete(4);

         */

        /*
        var employee = new EmployeeEntity();
        employee.setName("Karolina");
        employee.setSalary(new BigDecimal("1000"));
        employee.setBirthday(OffsetDateTime.now().minusYears(23));

        employeeDAO.insert(employee);

        employeeDAO.delete(9);

         */

        var update = new EmployeeEntity();
        update.setName("Sarah");
        update.setSalary(new BigDecimal("8800"));
        update.setBirthday(OffsetDateTime.now().minusYears(33));

        employeeDAO.insert(update);

        employeeDAO.delete(update.getId());
    }
}