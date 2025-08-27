package patterns.gof.facade.crm;

public class CrmService {
    private CrmService(){
        super();
    }
    public static void gravarCliente(String nome, String cep, String estado, String cidade){
        System.out.println("Cliente salvo no sistema de CRM.");
        String prefix = "Cliente dado: ";
        System.out.println(prefix+ nome);
        System.out.println(prefix+ cep);
        System.out.println(prefix+ estado);
        System.out.println(prefix+ cidade);
    }
}
