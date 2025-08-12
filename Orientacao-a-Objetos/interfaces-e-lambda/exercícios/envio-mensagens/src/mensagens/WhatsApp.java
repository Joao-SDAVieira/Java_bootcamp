package mensagens;

public class WhatsApp implements Mensagem{

    public void envioMensagm(String mensagem){
        System.out.println("Enviando mensagem: \n"+mensagem);
    }
}
