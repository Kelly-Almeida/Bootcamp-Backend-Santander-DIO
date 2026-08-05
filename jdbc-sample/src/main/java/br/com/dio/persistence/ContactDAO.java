package br.com.dio.persistence;

import br.com.dio.persistence.entity.ContactEntity;

import br.com.dio.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.NonNull;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {

    public void insert(final @NonNull ContactEntity contact){
        var sql = "INSERT INTO contacts (description, type, employee_id) values (?,?,?)";

        try(
            var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, contact.getDescription());
            statement.setString(2, contact.getType());
            statement.setLong(3, contact.getEmployee().getId());

            statement.executeUpdate();
            if (statement instanceof StatementImpl impl){
                contact.setId(impl.getLastInsertID());
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<ContactEntity> findByEmployeeId(final long employeeId){
        List<ContactEntity> entities = new ArrayList<>();
        var sql = "SELECT * FROM contacts WHERE employee_id = ?";

        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, employeeId);
            var resultSet = statement.executeQuery();

            while(resultSet.next()){
                var entity = new ContactEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setType(resultSet.getString("type"));

                var emp = new EmployeeEntity();
                emp.setId(resultSet.getLong("employee_id"));
                entity.setEmployee(emp);

                entities.add(entity);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }
}

