package VotacaoAssembleia.gerenciador;

import VotacaoAssembleia.acervo.AssociadoAcervo;
import VotacaoAssembleia.acervo.PautaAcervo;
import VotacaoAssembleia.acervo.VotoAcervo;
import VotacaoAssembleia.dominio.Associado;
import VotacaoAssembleia.dominio.Pauta;
import VotacaoAssembleia.dominio.Voto;
import java.util.List;
import static VotacaoAssembleia.DesafioTecnicoVotacaoAssembleia.abertaVotacao;
import static VotacaoAssembleia.DesafioTecnicoVotacaoAssembleia.idPautaAberta;

public class VotoGerenciador {

    private VotoAcervo acervoVoto = new VotoAcervo();
    private PautaAcervo acervoPauta = new PautaAcervo();
    private AssociadoAcervo acervoAssociado = new AssociadoAcervo();

    public Voto salvar(int idPauta, int idAssociado, char escolha){
        if (abertaVotacao== false ) {
            System.out.println("Votação id="+idPauta+" não esta aberta, não sendo possível salvar votos.");
            return null;        }
        if (idPauta!=idPautaAberta) {
            System.out.println("Votação id="+idPauta+" não esta aberta, não sendo possível salvar votos.");
            return null;        }
        if (escolha=='S' || escolha=='N') {
            List<Voto> votos = acervoVoto.obter();
            Pauta pauta = acervoPauta.pesquisar(idPauta);
            Associado associado = acervoAssociado.pesquisar(idAssociado);
            for (Voto votoExistente : votos) {
                for (int i = 0; i < votos.size(); i++) {
                    if (votos.get(i).getPauta().getIdPauta()==idPauta&&votos.get(i).getAssociado().getId()==idAssociado) {
                        System.out.println("Voto já realizado nesta pauta "+idPauta+" pelo usuário "+ votos.get(i).getAssociado()+" . Este voto não foi considerado. ");
                        return votoExistente;
                    }
                }
            }
            Voto votoSemId = new Voto(pauta, associado, escolha);
            return acervoVoto.salvar(votoSemId);
        }
        else{
            System.out.println("Você deve votar [S] para sim ou [N] para não. Este voto não foi considerado.");
            return null;}
    }

    public List<Voto> listar() {
        if (abertaVotacao== true) {
            System.out.println("Votação em Andamento. Não é possível listar os votos");
            return null;
        }
        return acervoVoto.listar();
    }

}

