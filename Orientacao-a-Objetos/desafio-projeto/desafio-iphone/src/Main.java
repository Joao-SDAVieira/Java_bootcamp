import Aparelhos.Iphone;

public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.atualizarPagina();

        // forçando falha
        iphone.pausarMusica();
        iphone.reproduzirMusica();

        iphone.selecionarMusica("Boulevard of Broken Dreams");
        iphone.reproduzirMusica();
        iphone.pausarMusica();
        iphone.atenderChamada();
        iphone.reproduzirMusica();

    }
}