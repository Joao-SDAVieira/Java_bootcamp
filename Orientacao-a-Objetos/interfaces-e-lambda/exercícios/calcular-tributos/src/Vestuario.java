public class Vestuario implements Produto{
    String nome;
    double valorProduto;
    public Vestuario(String nome, double valorProduto){
        this.nome = nome;
        this.valorProduto = valorProduto;
    }
    public double calCularImposto(){
        return this.valorProduto * 0.025;
    }
}
