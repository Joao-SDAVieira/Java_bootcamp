package users;

public abstract class User {
    private final String name;
    private final String email;
    private String password;
    private boolean isAdm;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public void login(){
        System.out.println("Logging in");
    }
    public void logOut(){
        System.out.println("Logging out");
    }
    public void updatePassword(String newPassword){
        System.out.println("Password Updated");
        this.password = newPassword;
    }
    public void updateData(){
        System.out.println("Updating data Manager");
    }
}
