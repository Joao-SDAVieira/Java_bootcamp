package users;

public final class Manager extends User{
    private final boolean isAdm = true;

    public Manager(String name, String email, String password){
        super(name, email, password);
    }
    public final void generateFinancialReport(){
        System.out.println("Your financial report:\n...\n...\n...\nend");
    }
    public void consultarVendas(){
        System.out.println("Sales ...\n...\n...");
    }

}
