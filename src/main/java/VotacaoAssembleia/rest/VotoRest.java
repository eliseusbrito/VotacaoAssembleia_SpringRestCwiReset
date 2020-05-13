package VotacaoAssembleia.rest;

import VotacaoAssembleia.dominio.Voto;
import VotacaoAssembleia.gerenciador.VotoGerenciador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voto")

public class VotoRest {

    private VotoGerenciador gerenciador = new VotoGerenciador();

    @GetMapping
    public List<Voto> listarTodosVotos() {
        return gerenciador.listar();
    }

    @PostMapping("/Pauta/{idPauta}/Associado/{idAssociado}/Escolha/{escolha}")
    public Voto cadastrarVoto(@PathVariable("idPauta") int idPauta, @PathVariable("idAssociado")int idAssociado, @PathVariable("escolha")char escolha)  {
        return gerenciador.salvar(idPauta,idAssociado,escolha);
    }
}



