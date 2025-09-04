package br.com.project.persistence;

import br.com.project.persistence.entity.ContactEnity;
import br.com.project.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class ContactDAO {
    public void insert(final ContactEnity entity){
        try(var connection = ConnectionUtil.getConnection();
        var statemant = connection.prepareStatement(
                "INSERT INTO contacts (desciption, type, employee_id) values (?, ?, ?);"
        )
        ){
            statemant.setString(1, entity.getDescription());
            statemant.setString(2, entity.getType());
            statemant.setLong(3, entity.getEmployeeEntity().getId());
            statemant.executeUpdate();
            System.out.printf("Foram aafetados %s registros na base de dados", statemant.getUpdateCount());
            if (statemant instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }

    public List<ContactEnity> findByEmployeeId(final Long employeeId){
        List<ContactEnity>  contacts = new ArrayList<>();
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareStatement("SELECT * FROM contacts WHERE employee_id = ?")
        ){
            statemant.setLong(1, employeeId);
            statemant.executeQuery();
            var resultSet = statemant.getResultSet();

            while (resultSet.next()){
                var entity = new ContactEnity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("desciption"));
                entity.setType(resultSet.getString("type"));
                entity.setEmployeeEntity((new EmployeeEntity()));
                entity.getEmployeeEntity().setId(resultSet.getLong("employee_id"));
                contacts.add(entity);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
        return contacts;
    }

}
