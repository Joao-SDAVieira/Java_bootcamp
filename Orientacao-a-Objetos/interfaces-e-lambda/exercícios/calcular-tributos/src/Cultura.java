public class Cultura implements Produto{
    String nome;
    double valorProduto;
    public Cultura(String nome, double valorProduto){
        this.nome = nome;
        this.valorProduto = valorProduto;
    }
    public double calCularImposto(){
        return this.valorProduto * 0.04;
    }
}
