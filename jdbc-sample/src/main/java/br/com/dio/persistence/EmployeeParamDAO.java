package br.com.dio.persistence;

import br.com.dio.persistence.entity.ContactEntity;
import br.com.dio.persistence.entity.EmployeeEntity;
import br.com.dio.persistence.entity.ModuleEntity;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.NonNull;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {

    private final ContactDAO contactDAO = new ContactDAO();
    private final AccessDAO accessDAO = new AccessDAO();

    public void insert(final @NonNull EmployeeEntity entity){
        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareStatement(
                        "INSERT INTO employees (name,salary,birthday) values (?, ?, ?);"
                );
        ){
            statement.setString(1,entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );

            statement.executeUpdate();

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
            if (entity.getModules() != null){
                entity.getModules().stream()
                        .map(ModuleEntity::getId)
                        .forEach(m -> accessDAO.insert(entity.getId(), m));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertWithProcedure(final @NonNull EmployeeEntity entity){
        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareCall(
                        "call prc_insert_employee(?, ?, ?, ?);"
                );
        ){
            statement.registerOutParameter(1, LONG);
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statement.setString(4, entity.getName());
            statement.execute();
            entity.setId(statement.getLong(1));

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertBach(final List <EmployeeEntity> entities){
        var sql = "INSERT INTO employees (name, salary, birthday) values (?, ?, ?);";

        try(var connection = ConnectionUtil.getConnection()){
            connection.setAutoCommit(false); //Transforma as transações manuais
            int cont = 0;

            try (var statement = connection.prepareStatement(sql)){
                for (var entity : entities){
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());

                    var timestamp = Timestamp.valueOf(
                            entity.getBirthday().toLocalDateTime());

                    statement.setTimestamp(3, timestamp);

                    statement.addBatch();

                    if (++cont % 500 == 0){
                        statement.executeBatch();
                        connection.commit();
                        statement.clearParameters();
                    }
                }

                if(cont % 500 != 0){
                    statement.executeBatch();
                    connection.commit();
                }

            }catch(SQLException ex){
                connection.rollback();
                ex.printStackTrace();
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){
        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareStatement(
                        "UPDATE employees SET name = ?, salary = ?, birthday = ? WHERE id = ?"
                );
        ){

            statement.setString(1,entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );

            statement.setLong(4, entity.getId());

            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros na base de dados \n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void delete (final long id){
        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
        ){
            statement.setLong(1, id);
            statement.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();

        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.createStatement();
        ){
           statement.executeQuery("SELECT * FROM employees ORDER BY birthday DESC");

           var resultSet = statement.getResultSet();

           while(resultSet.next()){
               var entity = new EmployeeEntity();
               entity.setId(resultSet.getLong("id"));
               entity.setName(resultSet.getString("name"));
               entity.setSalary(resultSet.getBigDecimal("salary"));
               var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
               entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
               entity.setContact(contactDAO.findByEmployeeId(resultSet.getLong("id")));
               entities.add(entity);
           }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }

    public EmployeeEntity findById(final long id){
        var entity = new EmployeeEntity();
        var sql = "SELECT e.id AS employee_id, " +
                "e.name, " +
                "e.salary, " +
                "e.birthday, " +
                "c.id AS contact_id, " +
                "c.description, " +
                "c.type " +
                "FROM employees AS e " +
                "LEFT JOIN contacts AS c " +
                "ON c.employee_id = e.id " +
                "WHERE e.id = ?";

        try(
                var connection = ConnectionUtil.getConnection(); //Criando conexão
                var statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, id);

            var resultSet = statement.executeQuery();

            if(resultSet.next()){

                entity.setId(resultSet.getLong("employee_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));

                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));

                entity.setContact(new ArrayList<>());

                do{
                    long contacId = resultSet.getLong("contact_id");

                    if(!resultSet.wasNull() && contacId > 0){
                        var contact = new ContactEntity();

                        contact.setId(resultSet.getLong("contact_id"));
                        contact.setDescription(resultSet.getString("Description"));
                        contact.setType(resultSet.getString("type"));

                        entity.getContact().add(contact);
                    }

                }while (resultSet.next());

            }else {
                System.out.println("Não ninguém com o id " + id);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return entity;

    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        var utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
