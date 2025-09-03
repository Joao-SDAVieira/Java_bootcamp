package br.com.project;


import br.com.project.persistence.EmployeeAuditDAO;
import br.com.project.persistence.EmployeeDAO;
import br.com.project.persistence.EmployeeParamDAO;
import br.com.project.persistence.entity.EmployeeEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {
    private final static EmployeeParamDAO employeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc-sample", "root", "root")
                .load();
        flyway.migrate();

//        var employeeCreate = new EmployeeEntity();
//        employeeCreate.setName("Adalberto");
//        employeeCreate.setSalary(new BigDecimal("5500"));
//        employeeCreate.setBirthday(OffsetDateTime.now().minusYears(30));
//        System.out.println(employeeCreate);
//        employeDAO.insertWithProcedure(employeeCreate);
////        System.out.println(employeeCreate);
//
////            employeDAO.findAll().forEach(employee -> System.out.println(employee));
////        System.out.println(employeDAO.findById(2L));
//
//
//        var employeeUpdate = new EmployeeEntity();
//        employeeUpdate.setId(4);
//        employeeUpdate.setName("adalberto alterado");
//        employeeUpdate.setSalary(new BigDecimal(7000));
//        employeeUpdate.setBirthday(OffsetDateTime.now().minusYears(30));
//        employeDAO.update(employeeUpdate);
//        employeDAO.delete(3L);

//        employeeAuditDAO.findAll().forEach(employeeAudit -> System.out.println(employeeAudit));

        var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(
                    OffsetDateTime.of(
                            LocalDate.now().minusYears(
                                    faker.number().numberBetween(40, 20)
                            ), LocalTime.MIN, ZoneOffset.UTC
                    )
            );
            return employee;
        }).limit(4000).toList();
        employeDAO.insertBatch(entities);
    }


}
