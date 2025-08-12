package users;

public final class Attendant extends  User{
    private final boolean isAdmin = false;
    private double cashValue;

    public Attendant(String name, String email, String password){
        super(name, email, password);
    }
    public double getCashValue(){
        System.out.println("Value: "+this.cashValue);
        return this.cashValue;
    }
    public void setPayment(double payment){
        System.out.println("Receiving Payment");
        this.cashValue += payment;
    }
    public void closeChashRegister(){
        System.out.println("Closin Cash Register");
    }
}
