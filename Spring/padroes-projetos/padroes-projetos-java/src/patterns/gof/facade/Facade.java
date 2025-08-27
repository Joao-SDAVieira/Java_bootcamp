package patterns.gof.facade;

import patterns.gof.facade.cep.CepApi;
import patterns.gof.facade.crm.CrmService;

public class Facade {
    public void migrarCliente(String nome,String cep){
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, estado, cidade);
    }
}
