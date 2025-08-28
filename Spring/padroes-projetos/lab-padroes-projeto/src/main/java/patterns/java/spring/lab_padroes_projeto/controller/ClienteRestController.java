package patterns.java.spring.lab_padroes_projeto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patterns.java.spring.lab_padroes_projeto.dtos.ClienteDto;
import patterns.java.spring.lab_padroes_projeto.model.Client;
import patterns.java.spring.lab_padroes_projeto.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public String inserir(@RequestBody ClienteDto cliente){
        return clienteService.inserir(cliente);
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody ClienteDto cliente){
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
