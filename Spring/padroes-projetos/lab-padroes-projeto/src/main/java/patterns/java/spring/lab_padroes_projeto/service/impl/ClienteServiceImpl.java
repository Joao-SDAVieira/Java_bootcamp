package patterns.java.spring.lab_padroes_projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patterns.java.spring.lab_padroes_projeto.model.Client;
import patterns.java.spring.lab_padroes_projeto.model.ClienteRepository;
import patterns.java.spring.lab_padroes_projeto.model.Endereco;
import patterns.java.spring.lab_padroes_projeto.model.EnderecoRepository;
import patterns.java.spring.lab_padroes_projeto.service.ClienteService;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Client> buscarTodos(){
        return clienteRepository.findAll();
    }

    @Override
    public Client buscarPorId(Long id){
        Optional<Client> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Client cliente){
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Client client){
        Optional<Client> clientedb = clienteRepository.findById(id);
        if(clientedb.isPresent()){
            salvarClienteComCep(client);
        }
    }

    @Override
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Client cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco enderecoDb = enderecoRepository.findById(cep).orElseGet(
                () -> {
                    Endereco novoEndereco =  viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                }
        );
        cliente.setEndereco(enderecoDb);

        clienteRepository.save(cliente);
    }
}
