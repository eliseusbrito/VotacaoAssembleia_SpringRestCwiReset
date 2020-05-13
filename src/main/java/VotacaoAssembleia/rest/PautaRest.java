package VotacaoAssembleia.rest;

import VotacaoAssembleia.dominio.Pauta;
import VotacaoAssembleia.gerenciador.PautaGerenciador;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pauta")

public class PautaRest {

    private PautaGerenciador gerenciador = new PautaGerenciador();

    @GetMapping
    public List<Pauta> listarTodasPautas() {
        return gerenciador.listar();
    }

    @GetMapping("{id}")
    public Pauta buscarPorId(@PathVariable("id") int id) {
        return gerenciador.pesquisar(id);
    }

    @PostMapping
    public Pauta cadastrar(@RequestBody Pauta pauta) {
        return gerenciador.salvar(pauta);
    }

    @PutMapping("{id}")
    public Pauta editar(@PathVariable("id") int id, @RequestBody Pauta body) {
        return gerenciador.editar(id, body);
    }

    @DeleteMapping("{id}")
    public boolean excluir(@PathVariable("id") int id) {
        return gerenciador.deletar(id);
    }

}
