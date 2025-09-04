package br.com.project.persistence.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class EmployeeEntity {
    private long id;


    private String name;

    private BigDecimal salary;
    private OffsetDateTime birthday;
    private List<ContactEnity> contacts;

    private List<ModuleEntity> modules;

    public void setContacts(List<ContactEnity> contacts) {
        this.contacts = contacts;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", contacts=" + contacts +
                '}';
    }

    public List<ContactEnity> getContacts() {
        return contacts;
    }

    public void setContact(List<ContactEnity> contacts) {
        this.contacts = contacts;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }



    public OffsetDateTime getBirthday() {
        return this.birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    public void setId(long lastInsertID) {
        id = lastInsertID;
    }
}
