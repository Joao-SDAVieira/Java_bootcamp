package patterns.java.spring.lab_padroes_projeto.service;

import patterns.java.spring.lab_padroes_projeto.model.Client;

public interface ClienteService {
    Iterable<Client> buscarTodos();

    Client buscarPorId(Long id);

    void inserir(Client cliente);

    void atualizar(Long id, Client client);

    void deletar(Long id);
}
