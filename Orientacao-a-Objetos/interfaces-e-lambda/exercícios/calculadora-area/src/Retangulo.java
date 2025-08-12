public class Retangulo extends Poligono{
    public Retangulo(int base, int altura){
        super(validar(base, altura), altura);
    }

    private static int validar(int base, int altura){
        if (base == altura){
            throw new IllegalArgumentException("Base e altura iguais não formam um retângulo");
        }
        return base;
    }
}
