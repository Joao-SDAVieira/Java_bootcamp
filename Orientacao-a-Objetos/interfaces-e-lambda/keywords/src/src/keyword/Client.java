package keyword;

import java.net.spi.InetAddressResolver;

public class Client {
    private String name;
    private int age;
    private Address address = new Address();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        System.out.println(address.description);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
