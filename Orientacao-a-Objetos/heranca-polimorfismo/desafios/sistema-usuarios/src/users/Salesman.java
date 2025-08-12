package users;

public final class Salesman extends User{
    private int sales = 0;
    private final boolean isAdmin = false;

    public Salesman(String name, String email, String password){
        super(name, email, password);
    }

    public int getSales(){
        System.out.println("Sales quantity: "+ sales);
        return this.sales;
    }

    public void makeSale(){
        System.out.println("Selling...");
        this.sales +=1;
    }
}
