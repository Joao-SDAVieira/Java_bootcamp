package domain;

public class Employee2 {
    protected String code;
    private String name;
    private String address;
    private int age;
    protected double salary;
    Employee2(
            String code,
            String name,
            String address,
            int age){
        this.code = code;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    Employee2(){}
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
