public class Circulo implements FormaGeometrica{
    private final int raio;
    public Circulo(int raio){
        this.raio = raio;
    }

    @Override
    public void calcularArea(){
        System.out.println(3.14159*Math.pow(raio, 2));
    }
}
