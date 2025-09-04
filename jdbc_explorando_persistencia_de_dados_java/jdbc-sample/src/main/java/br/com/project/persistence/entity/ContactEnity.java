package br.com.project.persistence.entity;


import lombok.Data;


public class ContactEnity {
    private long id;
    private String description;
    private String type;

    private EmployeeEntity employee;

    @Override
    public String toString() {
        return "ContactEnity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", employee=" + employee +
                '}';
    }

    public EmployeeEntity getEmployeeEntity() {
        return employee;
    }

    public void setEmployeeEntity(EmployeeEntity employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
