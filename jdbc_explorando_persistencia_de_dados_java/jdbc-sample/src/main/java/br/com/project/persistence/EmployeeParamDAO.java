package br.com.project.persistence;

import br.com.project.persistence.entity.ContactEnity;
import br.com.project.persistence.entity.EmployeeEntity;
import br.com.project.persistence.entity.ModuleEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {
    private final ContactDAO contactDAO = new ContactDAO();

    private final AccessDAO accessDAO = new AccessDAO();

    public void insert(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
        var statemant = connection.prepareStatement(
                "INSERT INTO employees (name, salary, birthday) values (?, ?, ?);"
        )
        ){
            statemant.setString(1, entity.getName());
            statemant.setBigDecimal(2, entity.getSalary());
            statemant.setTimestamp(
                    3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statemant.executeUpdate();


            System.out.printf("Foram aafetados %s registros na base de dados", statemant.getUpdateCount());
            if (statemant instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
                entity.getModules().stream().map(ModuleEntity::getId).forEach(
                        module_id -> accessDAO.insert(entity.getId(), module_id)
                );
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public void insertBatch(final List<EmployeeEntity> entities) {
        try (var connection = ConnectionUtil.getConnection()) {
            var sql = "INSERT INTO employees (name, salary, birthday) values (?, ?, ?);";
            try (var statemant = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);
                for(var entity: entities) {
                    statemant.setString(1, entity.getName());
                    statemant.setBigDecimal(2, entity.getSalary());
                    var timestamp = Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime());
                    statemant.setTimestamp(3, timestamp);
                    statemant.addBatch();}
                statemant.executeBatch();
                connection.commit();
            } catch (SQLException exe) {
                connection.rollback();
                exe.printStackTrace();
            }
        }catch (SQLException exe) {
            exe.printStackTrace();
            }

    }

    public void insertWithProcedure(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareCall(
                    "call prc_insert_employee(?, ?, ?, ?);"
            )
        ){
            statemant.registerOutParameter(1, LONG);
            statemant.setString(2, entity.getName());
            statemant.setBigDecimal(3, entity.getSalary());
            statemant.setTimestamp(
                    4, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statemant.execute();
            entity.setId(statemant.getLong(1));
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareStatement(
                    "UPDATE employees set  name = ?, salary = ?, birthday = ?  WHERE id = ?"
            )
        ){
            statemant.setString(1, entity.getName());
            statemant.setBigDecimal(2, entity.getSalary());
            statemant.setTimestamp(
                    3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statemant.setLong(4, entity.getId());
            statemant.executeUpdate();

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
            var statemant = connection.prepareStatement("DELETE FROM employees WHERE ID = ?")
        ){
            statemant.setLong(1, id);
            statemant.executeUpdate();
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
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContact(contactDAO.findByEmployeeId(resultSet.getLong("id")));
                entities.add(entity);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final Long id){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        var sql = """
                SELECT e.id, e.name, e.salary, e.birthday, c.id as contact_id, c.desciption, c.`type`
                FROM employees e LEFT JOIN contacts c ON c.employee_id = e.id
                WHERE e.id = ?;
                """;

        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareStatement(sql)
        ){
            statemant.setLong(1, id);
            statemant.executeQuery();
            var resultSet = statemant.getResultSet();

            if (resultSet.next()){
                System.out.println(
                        "contact_id=" + resultSet.getLong("contact_id") +
                                ", desciption=" + resultSet.getString("desciption") +
                                ", type=" + resultSet.getString("type")
                );

                employeeEntity.setId(resultSet.getLong("id"));
                employeeEntity.setName(resultSet.getString("name"));
                employeeEntity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                employeeEntity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                employeeEntity.setContact(new ArrayList<>());
                do {
                    var contact = new ContactEnity();
                    contact.setType(resultSet.getString("type"));
                    contact.setDescription(resultSet.getString("desciption"));
                    contact.setId(resultSet.getLong("contact_id"));
                    employeeEntity.getContacts().add(contact);
                } while (resultSet.next());
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
