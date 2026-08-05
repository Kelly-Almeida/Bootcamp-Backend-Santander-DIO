package br.com.dio.persistence;

import br.com.dio.persistence.entity.ContactEntity;
import br.com.dio.persistence.entity.EmployeeEntity;
import br.com.dio.persistence.entity.ModuleEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.NonNull;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.time.ZoneOffset.UTC;

public class ModuleDAO {
    public void insert(final @NonNull ModuleEntity module){
        var sql = "INSERT INTO modules (name) VALUES (?)";
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, module.getName());
            statement.executeUpdate();

            if (statement instanceof StatementImpl impl){
                module.setId(impl.getLastInsertID());
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<ModuleEntity> findAll(){
        Map<Long, ModuleEntity> moduleMap = new LinkedHashMap<>();

        var sql = "SELECT m.id module_id, \n" +
                "\t m.name module_name,\n" +
                "\t e.id employee_id,\n" +
                "\t e.name employee_name,\n" +
                "\t e.salary employee_salary,\n" +
                "\t e.birthday employee_birthday\n" +
                "FROM modules m INNER JOIN accesses a \n" +
                "ON a.module_id = m.id \n" +
                "INNER JOIN employees e \n" +
                "ON e.id = a.employee_id\n" +
                "ORDER BY m.id;";

        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(sql);
                var resultSet = statement.executeQuery()
        ){
            boolean hasNext = resultSet.next();

            while(resultSet.next()){
                long moduleId = resultSet.getLong("module_id");

                ModuleEntity module = moduleMap.computeIfAbsent(moduleId, id ->{
                    ModuleEntity m = new ModuleEntity();
                    m.setId(id);

                    try{
                        m.setName(resultSet.getString("module_name"));
                    }catch (SQLException ex){
                        ex.printStackTrace();
                    }

                    m.setEmployees(new ArrayList<>());

                    return m;
                });

                var employee = new EmployeeEntity();
                employee.setId(resultSet.getLong("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setSalary(resultSet.getBigDecimal("employee_salary"));

                var birthdayInstant = resultSet.getTimestamp("employee_birthday").toInstant();
                employee.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));

                module.getEmployees().add(employee);
            }
                /*ModuleEntity module = new ModuleEntity();
                module.setId(resultSet.getLong("module_id"));
                module.setName(resultSet.getString("module_name"));
                module.setEmployees(new ArrayList<>());
                do{
                    var employee = new EmployeeEntity();
                    employee.setId(resultSet.getLong("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setSalary(resultSet.getBigDecimal("employee_salary"));

                    var birthdayInstant = resultSet.getTimestamp("employee_birthday").toInstant();
                    employee.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));

                    module.getEmployees().add(employee);

                }while(hasNext && module.getId() == resultSet.getLong("module_id") );
                modules.add(module);
            }

                 */
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return new ArrayList<>(moduleMap.values());
    }
}
