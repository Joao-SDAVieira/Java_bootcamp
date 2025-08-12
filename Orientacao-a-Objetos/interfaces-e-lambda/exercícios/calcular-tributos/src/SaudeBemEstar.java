public class SaudeBemEstar implements Produto{
    String nome;
    double valorProduto;
    public SaudeBemEstar(String nome, double valorProduto){
        this.nome = nome;
        this.valorProduto = valorProduto;
    }
    public double calCularImposto(){
        return this.valorProduto * 0.015;
    }
}
