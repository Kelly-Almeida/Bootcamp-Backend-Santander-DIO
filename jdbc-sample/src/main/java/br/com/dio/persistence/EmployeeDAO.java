package br.com.dio.persistence;

import com.mysql.cj.jdbc.StatementImpl;

import javax.sql.rowset.spi.SyncResolver;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity){
        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.createStatement();
                ){
                var sql = "INSERT INTO employees (name, salary, birthday) values ('" +
                        entity.getName() + "', " +
                        entity.getSalary().toString() + ", '" +
                        formatOffsetDateTime(entity.getBirthday())+ "' )";
                statement.executeUpdate(sql);

            System.out.printf("Foram afetados %s registros na base de dados \n", statement.getUpdateCount());
                if (statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){

    }

    public void delete (final long id){

    }

    public List<EmployeeEntity> findAll(){
        return null;
    }

    public EmployeeEntity findById(final long id){
        return null;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        var utcDateTime = dateTime.withOffsetSameInstant(ZoneOffset.UTC);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
