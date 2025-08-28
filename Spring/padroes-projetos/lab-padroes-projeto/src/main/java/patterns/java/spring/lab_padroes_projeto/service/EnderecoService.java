package patterns.java.spring.lab_padroes_projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import patterns.java.spring.lab_padroes_projeto.model.Endereco;
import patterns.java.spring.lab_padroes_projeto.model.EnderecoRepository;

public interface EnderecoService {
    Endereco adicionarEndereco(String cep);

    public Iterable<Endereco> listarEnderecos();
}
