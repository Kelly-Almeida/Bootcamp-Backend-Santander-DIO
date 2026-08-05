package br.com.dio.persistence;

import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;

public class AccessDAO {

    public void insert (final long employeeId, final long moduleId){
        var sql = "INSERT INTO accesses (employee_id, module_id) VALUES (?,?);";

        try(
            var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, employeeId);
            statement.setLong(2, moduleId);

            statement.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
