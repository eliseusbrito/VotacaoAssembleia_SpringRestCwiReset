package VotacaoAssembleia.rest;

import VotacaoAssembleia.dominio.Associado;
import VotacaoAssembleia.gerenciador.AssociadoGerenciador;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/associado")

public class AssociadoRest {

    private AssociadoGerenciador gerenciador = new AssociadoGerenciador();

    @GetMapping
    public List<Associado> listarTodosAssociados() {
        return gerenciador.listar();
    }

    @GetMapping("{id}")
    public Associado buscarPorId(@PathVariable("id") int id) {
        return gerenciador.pesquisar(id);
    }

    @PostMapping
    public Associado cadastrar(@RequestBody Associado associado) {
        return gerenciador.salvar(associado);
    }

    @PutMapping("{id}")
    public Associado editar(@PathVariable("id") int id, @RequestBody Associado body) {
        return gerenciador.editar(id, body);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable("id") int id) {
        return gerenciador.deletar(id);
    }

}
