import keyword.Poema;

public class Main {
    public static void main(String[] args) {
        Poema poema = new Poema();
        poema.setNome("Poema1");
        poema.setData("25/05/2005");
        System.out.println(poema.getNome());
        System.out.println(poema.getData());

        System.out.println("==========");
        Poema novoPoema = new Poema();
        novoPoema.setNome("Poema novo");
        System.out.println(novoPoema.getNome());
        System.out.println(novoPoema.getData());
    }
}