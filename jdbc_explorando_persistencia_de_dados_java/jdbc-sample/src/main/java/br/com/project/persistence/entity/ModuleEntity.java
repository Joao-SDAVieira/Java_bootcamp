package br.com.project.persistence.entity;

import java.util.List;

public class ModuleEntity {
    private long id;
    private String name;

    private List<EmployeeEntity> employees;

    @Override
    public String toString() {
        return "ModuleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
