package VotacaoAssembleia.rest;

import VotacaoAssembleia.acervo.VotoAcervo;
import VotacaoAssembleia.dominio.Decisao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static VotacaoAssembleia.DesafioTecnicoVotacaoAssembleia.abertaVotacao;
import static VotacaoAssembleia.DesafioTecnicoVotacaoAssembleia.idPautaAberta;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/votacao")
public class AbrirSessaoVotacao {

    VotoAcervo votoAcervo = new VotoAcervo();

    @GetMapping("{id}")
    public Decisao tempoDefalt(@PathVariable("id") int id)throws InterruptedException{
        abertaVotacao = true;
        idPautaAberta = id;
        System.out.println("A sessão de votação pauta id="+idPautaAberta+" ficará aberta por 1 minuto.");
        TimeUnit.MINUTES.sleep(1);
        System.out.println("Encerrado a votação id="+idPautaAberta);
        abertaVotacao = false;
        return votoAcervo.contaVotos(id);
    }

    @GetMapping("{id}/tempo/{t}")
    public Decisao tempoVariavel(@PathVariable("id") int id,@PathVariable("t") int t) throws InterruptedException {
        abertaVotacao = true;
        idPautaAberta = id;
        System.out.println("A sessão de votação pauta id="+idPautaAberta+" ficará aberta por "+t+" minutos.");
        TimeUnit.MINUTES.sleep(t);
        System.out.println("Encerrado a votação id="+idPautaAberta+":");
        abertaVotacao = false;
        return votoAcervo.contaVotos(id);
    }

}
