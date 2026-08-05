package br.com.dio;

import br.com.dio.persistence.*;
import br.com.dio.persistence.entity.ContactEntity;
import br.com.dio.persistence.entity.EmployeeEntity;
import br.com.dio.persistence.entity.ModuleEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

    private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static ContactDAO contacts = new ContactDAO();
    private final static ModuleDAO module = new ModuleDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));

   public static void main(String[] args) throws SQLException {
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




        employee = new EmployeeEntity();
        employee.setName("Karolina");
        employee.setSalary(new BigDecimal("1000"));
        employee.setBirthday(OffsetDateTime.now().minusYears(23));

        employeeDAO.insert(employee);

        employeeDAO.delete(9);



        var update = new EmployeeEntity();
        update.setName("Sarah");
        update.setSalary(new BigDecimal("8800"));
        update.setBirthday(OffsetDateTime.now().minusYears(33));

        employeeDAO.insert(update);

        employeeDAO.delete(update.getId());

         */

        /*
        var update = new EmployeeEntity();

        update.setName("Martha'");
        update.setSalary(new BigDecimal("8800"));
        update.setBirthday(OffsetDateTime.now().minusYears(36));

        employeeDAO.insertWithProcedure(update);


        employeeAuditDAO.findAll().forEach(System.out::println);

         */
        /*
        var entities = Stream.generate(()-> {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));

            int days = 365 * 30;
            Instant generationDate = faker.timeAndDate().past(days,TimeUnit.DAYS);
            employee.setBirthday(generationDate.atOffset(ZoneOffset.UTC));

            return employee;
        }).limit(4000).toList();

        employeeDAO.insertBach(entities);

         */
        /*
        var insert = new EmployeeEntity();
        insert.setName("Samara");
        insert.setSalary(new BigDecimal("5030"));
        insert.setBirthday(OffsetDateTime.now().minusYears(22).minusDays(156));
        System.out.println(insert);
        employeeDAO.insert(insert);

        var contact = new ContactEntity();
        contact.setDescription("karoline@kamail.com");
        contact.setType("e-mail");
        contact.setEmployee(insert);

        contacts.insert(contact);
        */

       //System.out.println(emplemployeeDAOoyeeDAO.findById(52649));
       //employeeDAO.findAll().forEach(System.out::println);


       /*
       ModuleEntity mod = new ModuleEntity();

       mod.setName("Estoque");

       module.insert(mod);

        */
       /*
        var entites = Stream.generate(() ->{EmployeeEntity employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));

            int days = 365 * 30;
            Instant generationDate = faker.timeAndDate().past(days,TimeUnit.DAYS);
            employee.setBirthday(generationDate.atOffset(ZoneOffset.UTC));

            employee.setModules(new ArrayList<>());

            var moduleAmount = faker.number().numberBetween(1, 4);
            for(int i = 0; i < moduleAmount; i++){
                var module = new ModuleEntity();
                module.setId(i + 1);
                employee.getModules().add(module);
            }
            return employee;
        }).limit(3).toList();

        entites.forEach(employeeDAO::insert);

        */

       //module.findAll().forEach(System.out::println);
    }
}