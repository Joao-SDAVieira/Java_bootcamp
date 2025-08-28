package patterns.java.spring.lab_padroes_projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patterns.java.spring.lab_padroes_projeto.model.Endereco;
import patterns.java.spring.lab_padroes_projeto.service.EnderecoService;

@RestController
@RequestMapping("enderecos")
public class EnderecoRestController {
    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    public Endereco adicionarEnderecoPorCep(String cep){
        return enderecoService.adicionarEndereco(cep);
    }

    @GetMapping
    public Iterable<Endereco> listarEnderecos(){
        return enderecoService.listarEnderecos();
    }
}
