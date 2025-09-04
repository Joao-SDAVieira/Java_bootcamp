package br.com.project.persistence;

import br.com.project.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Timestamp;

import static java.time.ZoneOffset.UTC;

public class AccessDAO {
    public void insert(final Long employeeId, final long moduleId){
        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareStatement(
                    "INSERT INTO accesses (module_id, employee_id) values (?, ?);"
            )
        ){
            statemant.setLong(1, moduleId);
            statemant.setLong(2, employeeId);
            statemant.executeUpdate();

        }catch (SQLException exe){
            exe.printStackTrace();
        }
    }
}
