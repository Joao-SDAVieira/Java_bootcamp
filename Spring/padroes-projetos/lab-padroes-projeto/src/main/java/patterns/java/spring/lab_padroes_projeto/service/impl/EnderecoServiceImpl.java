package patterns.java.spring.lab_padroes_projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patterns.java.spring.lab_padroes_projeto.exception.EnderecoJaExintenteException;
import patterns.java.spring.lab_padroes_projeto.model.Endereco;
import patterns.java.spring.lab_padroes_projeto.model.EnderecoRepository;
import patterns.java.spring.lab_padroes_projeto.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Endereco adicionarEndereco(String cep){
        Optional<Endereco> endereco = enderecoRepository.buscarPorCep(cep);
        if (endereco.isPresent()){
            throw new EnderecoJaExintenteException(cep);
        }
        Endereco novoEndereco = viaCepService.consultarCep(cep);
        return enderecoRepository.save(novoEndereco);
    }

    public Iterable<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }
}
