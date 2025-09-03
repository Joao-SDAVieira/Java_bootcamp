package br.com.project.persistence;

import br.com.project.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void insert(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
        var statemant = connection.createStatement()
        ){
            var sql = "INSERT INTO employees (name, salary, birthday) values ('" +
                    entity.getName() + "'," +
                    entity.getSalary().toString() +
                    ",'" + formatOffSetDateTime(entity.getBirthday()) + " ')";
            statemant.executeUpdate(sql);

            System.out.printf("Foram aafetados %s registros na base de dados", statemant.getUpdateCount());
            if (statemant instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.createStatement()
        ){
            var sql = "UPDATE employees set " +
                    "name = '" + entity.getName() + "', " +
                    "salary = " + entity.getSalary() + "," +
                    "birthday = '" + formatOffSetDateTime(entity.getBirthday()) + " '" +
                    "WHERE id = " + entity.getId();
            statemant.executeUpdate(sql);

            System.out.printf("Foram aafetados %s registros na base de dados", statemant.getUpdateCount());
            if (statemant instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public void delete(final Long id){
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.createStatement()
        ){
            var sql = "DELETE FROM employees WHERE ID = " + id;
            statemant.executeUpdate(sql);
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();

        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.createStatement()
        ){
            statemant.executeQuery("SELECT * FROM employees");
            var resultSet = statemant.getResultSet();
            while (resultSet.next()){
                var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));
                entities.add(entity);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final Long id){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.createStatement()
        ){
            statemant.executeQuery("SELECT * FROM employees WHERE id = "+ id);
            var resultSet = statemant.getResultSet();
            if (resultSet.next()){
                employeeEntity.setId(resultSet.getLong("id"));
                employeeEntity.setName(resultSet.getString("name"));
                employeeEntity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                employeeEntity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
        return employeeEntity;
    }

    private String formatOffSetDateTime(final OffsetDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
    }

}
