package br.com.dio.persistence;


import br.com.dio.persistence.entity.EmployeeeAuditEntity;
import br.com.dio.persistence.entity.OperationEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.isNull;

public class EmployeeAuditDAO {

    public List<EmployeeeAuditEntity> findAll(){
        List<EmployeeeAuditEntity> entities = new ArrayList<>();

        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.createStatement();
        ){
            statement.executeQuery("SELECT * FROM view_employee_audit");

            var resultSet = statement.getResultSet();

            while(resultSet.next()){


                var old_birthday = isNull(resultSet.getTimestamp("old_birthday")) ? null :
                        OffsetDateTime.ofInstant(
                                resultSet.getTimestamp("old_birthday").toInstant(),
                                UTC
                        );

                entities.add(new EmployeeeAuditEntity(
                        resultSet.getLong("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("old_name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getBigDecimal("old_salary"),
                        getDateTimeOrNull(resultSet, "birthday"),
                        getDateTimeOrNull(resultSet, "old_birthday"),
                        OperationEnum.getByDbOperation(resultSet.getString("operation"))
                ));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }

    public OffsetDateTime getDateTimeOrNull(final ResultSet resultSet, final String field) throws SQLException {
        return isNull(resultSet.getTimestamp(field)) ? null :
                OffsetDateTime.ofInstant(
                        resultSet.getTimestamp(field).toInstant(),
                        UTC
                );
    }
}
