public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);
        circulo.calcularArea();

        Poligono quadrado = new Quadrado(20);
        quadrado.calcularArea();

        Poligono retangulo = new Retangulo(20, 20);
        retangulo.calcularArea();

    }
}