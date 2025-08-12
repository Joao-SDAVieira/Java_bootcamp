public class Main {
    private String novo;
    public static void main(String[] args) {
    Relogio relogioBrasileiro = new RelogioBrasileiro();
    relogioBrasileiro.setSegundos(0);
    relogioBrasileiro.setMinutos(0);
    relogioBrasileiro.setHoras(25);
    this.nov
    System.out.println(relogioBrasileiro.getTime());

    System.out.println(new RelogioAmericano().converter(relogioBrasileiro).getTime());
    }
}