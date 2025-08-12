package Aparelhos;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
    private boolean musicaTocando = false;
    private String musicaSelecionada = "";
    private String paginaExibida;

    @Override
    public void reproduzirMusica(){
        if (this.musicaSelecionada.isEmpty()){
            System.out.println("Selecione uma música");
            return;
        }
        System.out.println("Reproduzindo musica: " + this.musicaSelecionada);
        this.musicaTocando = true;
    }
    @Override
    public void pausarMusica(){
        if (!this.musicaTocando) {
            System.out.println("Nenhuma musica tocando");
            return;
        }
        System.out.println("Pausando musica: " + this.musicaSelecionada);
        this.musicaTocando = false;
    }
    @Override
    public void selecionarMusica(String musica){
        this.musicaSelecionada = musica;
        System.out.println("Musica selecionada");
    }
    @Override
    public void realizarChamada(String numero){
        System.out.println("Ligando para o número: " + numero);
    }
    @Override
    public void atenderChamada(){
        System.out.println("Atendendo chamada");
    }
    @Override
    public void iniciarCorreioVoz(){
        System.out.println("Iniciando correio de voz");
    }
    @Override
    public void exibirPagina(String url){
        System.out.println("Exibindo página: "+ this.paginaExibida);
    }
    @Override
    public void adicionarNovaAba(){
        System.out.println("Adicionando nova aba");
    }

    @Override
    public void atualizarPagina(){
        System.out.println("Atualizando página");
    }
}
