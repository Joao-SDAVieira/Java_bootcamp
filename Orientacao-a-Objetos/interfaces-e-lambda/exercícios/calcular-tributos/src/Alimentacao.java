public class Alimentacao implements Produto{
    String nome;
    float valorProduto;
    public Alimentacao(String nome, float valorProduto){
        this.nome = nome;
        this.valorProduto = valorProduto;
    }
    public double calCularImposto(){
        return this.valorProduto * 0.01;
    }
}
