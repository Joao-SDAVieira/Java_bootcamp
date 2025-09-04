package br.com.project.persistence;

import br.com.project.persistence.entity.ContactEnity;
import br.com.project.persistence.entity.EmployeeEntity;
import br.com.project.persistence.entity.ModuleEntity;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ModuleDAO {

    public List<ModuleEntity> findAll(){
        List<ModuleEntity> modules = new ArrayList<>();
        var sql = """
                    SELECT m.id module_id,
                    	m.name module_name,
                    	e.id employee_id,
                    	e.name employee_name,
                    	e.salary employee_salary,
                    	e.birthday employee_birthday
                    	FROM modules m
                    	INNER JOIN accesses a
                    	ON a.module_id = m.id
                    	INNER JOIN employees e
                    	ON e.id = a.employee_id
                    	ORDER BY m.id;
                    """;

        try(var connection = ConnectionUtil.getConnection();
            var statemant = connection.prepareStatement(sql)
        ){
            statemant.executeQuery();
            var resultSet = statemant.getResultSet();
            Boolean hasNext = resultSet.next();

            while (hasNext){
                ModuleEntity module = new ModuleEntity();
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
                hasNext = resultSet.next();
            } while ((hasNext) && (module.getId() == resultSet.getLong("module_id")));
                modules.add(module);
            }
        }catch (SQLException exe){
            exe.printStackTrace();
        }
        return modules;
    }
}
