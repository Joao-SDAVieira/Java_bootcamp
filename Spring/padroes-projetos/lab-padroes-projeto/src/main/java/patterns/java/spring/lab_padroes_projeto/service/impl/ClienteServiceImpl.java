package patterns.java.spring.lab_padroes_projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patterns.java.spring.lab_padroes_projeto.dtos.ClienteDto;
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
    public String inserir(ClienteDto cliente){
        return salvarClienteComCep(cliente);
    }


    @Override
    public String atualizar(Long id, ClienteDto client){
        Optional<Client> clientedb = clienteRepository.findById(id);
        if(clientedb.isPresent()){
             return salvarClienteComCep(client);
        }
        return "Cliente não encontrado";
    }

    @Override
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

    private String salvarClienteComCep(ClienteDto clienteDto) {
        Optional<Endereco> endereco =  enderecoRepository.findById(clienteDto.enderecoId());

        if (endereco.isEmpty()){
            return "Endereço não encontrado!";
        }

//        String cep = cliente.getEndereco().getCep();

//        Endereco enderecoDb = enderecoRepository.findById(cep).orElseGet(
//                () -> {
//                    Endereco novoEndereco =  viaCepService.consultarCep(cep);
//                    enderecoRepository.save(novoEndereco);
//                    return novoEndereco;
//                }
//        );
//        cliente.setEndereco(enderecoDb);
        Client cliente = new Client();
        cliente.setNome(clienteDto.nome());
        cliente.setEndereco(endereco.get());

        clienteRepository.save(cliente);
        return "Cliente criado com sucesso ao cep " + endereco.get().getCep();
    }
}
