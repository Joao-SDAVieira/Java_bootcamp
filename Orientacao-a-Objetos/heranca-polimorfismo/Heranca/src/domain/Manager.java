package domain;

public class Manager extends Employee{
    private String login;
    private String password;

    public Manager(
            String code,
            String name,
            String address,
            int age,
            String login,
            String password){
        super(code, name, address, age);
        this.login = login;
        this.password = password;
    }

    public Manager(){
    }

    public String getCode(){
        String codeFromSuperClass = super.getCode();
        return "MG" + codeFromSuperClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    private double comission;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getFullSalary(){
        return this.salary + this.comission;
    }

    public double getFullSalary(double extra){
        return this.getFullSalary() + extra;
    }

}
