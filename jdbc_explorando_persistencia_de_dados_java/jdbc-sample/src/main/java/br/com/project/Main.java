package br.com.project;


import br.com.project.persistence.*;
import br.com.project.persistence.entity.ContactEnity;
import br.com.project.persistence.entity.EmployeeEntity;
import br.com.project.persistence.entity.ModuleEntity;
import com.fasterxml.jackson.databind.Module;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {
    private final static EmployeeParamDAO employeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static ContactDAO contactDao = new ContactDAO();
    private  final static ModuleDAO moduleDAO = new ModuleDAO();

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

//        var entities = Stream.generate(() -> {
//            var employee = new EmployeeEntity();
//            employee.setName(faker.name().fullName());
//            employee.setSalary(new BigDecimal(faker.number().digits(4)));
//            employee.setBirthday(
//                    OffsetDateTime.of(
//                            LocalDate.now().minusYears(
//                                    faker.number().numberBetween(40, 20)
//                            ), LocalTime.MIN, ZoneOffset.UTC
//                    )
//            );
//            return employee;
//        }).limit(4000).toList();
//        employeDAO.insertBatch(entities);




//        var employeeCreate = new EmployeeEntity();
//        employeeCreate.setName("BatataFrita");
//        employeeCreate.setSalary(new BigDecimal("2"));
//        employeeCreate.setBirthday(OffsetDateTime.now().minusYears(12));
//        System.out.println(employeeCreate);
//        employeDAO.insertWithProcedure(employeeCreate);
//
//        var contact1 = new ContactEnity();
//        contact1.setDescription("batatinha@joao.com");
//        contact1.setType("e-mail");
//        contact1.setEmployeeEntity(employeeCreate);
//
//        var contact2 = new ContactEnity();
//        contact2.setDescription("batatinha2@joao.com");
//        contact2.setType("e-mail");
//        contact2.setEmployeeEntity(employeeCreate);
//
//        contactDao.insert(contact1);
//        contactDao.insert(contact2);


//        System.out.println(employeDAO.findById(8013L));

//        employeDAO.findAll().forEach(employee -> System.out.println(employee));
//        var entities = Stream.generate(() -> {
//            var employee = new EmployeeEntity();
//            employee.setName(faker.name().fullName());
//            employee.setSalary(new BigDecimal(faker.number().digits(4)));
//            employee.setBirthday(
//                    OffsetDateTime.of(
//                            LocalDate.now().minusYears(
//                                    faker.number().numberBetween(40, 20)
//                            ), LocalTime.MIN, ZoneOffset.UTC
//                    )
//            );
//            employee.setModules(new ArrayList<>());
//            var moduleAmount = faker.number().numberBetween(1,4);
//            for (int i = 0; i< moduleAmount; i++){
//                var module = new ModuleEntity();
//                module.setId(i+1);
//                employee.getModules().add(module);
//            }
//            return employee;
//        }).limit(3).toList();
//        entities.forEach(employeDAO::insert);

        moduleDAO.findAll().forEach(System.out::println);

    }


}
