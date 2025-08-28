package patterns.java.spring.lab_padroes_projeto.service;

import patterns.java.spring.lab_padroes_projeto.dtos.ClienteDto;
import patterns.java.spring.lab_padroes_projeto.model.Client;

public interface ClienteService {
    Iterable<Client> buscarTodos();

    Client buscarPorId(Long id);

    String inserir(ClienteDto cliente);

    String atualizar(Long id, ClienteDto client);

    void deletar(Long id);
}
