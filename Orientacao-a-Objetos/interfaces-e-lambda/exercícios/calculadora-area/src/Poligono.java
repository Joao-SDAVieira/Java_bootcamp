public abstract class Poligono implements FormaGeometrica{
    private final int base;
    private final int altura;

    public Poligono(int base, int altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void calcularArea() {
        System.out.println(this.base * this.altura);
    }
}
