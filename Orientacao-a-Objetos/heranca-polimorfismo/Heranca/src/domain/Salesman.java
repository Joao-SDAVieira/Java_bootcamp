package domain;

public class Salesman extends Employee{
    private double percentPerSold;

    private double soldAmount;

    public Salesman(String code, String name, String address, int age, double percentPerSold, double soldAmount) {
        super(code, name, address, age);
        this.percentPerSold = percentPerSold;
        this.soldAmount = soldAmount;
    }
    public Salesman(){}

    public double getFullSalary(){
        return this.salary + (soldAmount * percentPerSold)/100;
    }

    public String getCode(){
        String codeFromSuperClass = this.code;
        return "SL" + codeFromSuperClass;
    }

    public double getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(double soldAmount) {
        this.soldAmount = soldAmount;
    }

    public double getPercentPerSold() {
        return percentPerSold;
    }

    public void setPercentPerSold(double percentPerSold) {
        this.percentPerSold = percentPerSold;
    }
}
