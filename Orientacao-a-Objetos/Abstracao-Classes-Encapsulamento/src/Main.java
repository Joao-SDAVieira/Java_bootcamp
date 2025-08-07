public class Main {
    public static void main(String[] args) {
        Person male = new Person("João", 21);
        var female = new Person(); //criando dessa vez a mesma classe sem construtor
        female.setName("Laís");
        female.setAge(21);
        male.incAge();
        System.out.println("Male name " + male.getName() + "idade "+ male.getAge());
        male.incAge();
        male.incAge();
        System.out.println("Male name " + male.getName() + "idade "+ male.getAge());
    }
}