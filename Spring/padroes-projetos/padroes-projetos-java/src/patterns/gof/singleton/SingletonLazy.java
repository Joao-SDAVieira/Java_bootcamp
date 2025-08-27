package patterns.gof.singleton;

public class SingletonLazy {
    private static SingletonLazy instancia;
    private SingletonLazy(){
        super();
    }
    public static SingletonLazy getInstance(){
        if (instancia == null){
            System.out.println("Entrou no if");
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
