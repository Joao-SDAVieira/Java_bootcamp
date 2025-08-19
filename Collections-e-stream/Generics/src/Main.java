import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        User user = new User("João", 21);

        BoxGenericType<User> userBox = new BoxGenericType<>();
        userBox.set(user);
        System.out.println("Box user: "+ userBox.get().getNome());

    }
}