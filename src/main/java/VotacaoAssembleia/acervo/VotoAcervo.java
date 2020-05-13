package VotacaoAssembleia.acervo;

import VotacaoAssembleia.dominio.Decisao;
import VotacaoAssembleia.dominio.Pauta;
import VotacaoAssembleia.dominio.Voto;
import VotacaoAssembleia.gerenciador.PautaGerenciador;
import java.util.ArrayList;
import java.util.List;

public class VotoAcervo {
    private static int contador = 1;
    public static final List<Voto> votos = new ArrayList<>();
    private PautaGerenciador gerenciadorPautaGerenciador = new PautaGerenciador();

    public Voto salvar(Voto voto) {
        voto.setIdVoto(contador++);
        votos.add(voto);
        System.out.println("Salvou o "+voto);
        return voto;
    }

    public List<Voto> listar() {
        System.out.println("Lista de todos os votos:");
        System.out.println(votos);
        return votos;
    }

    public List<Voto> obter() {
        return votos;
    }

    public Decisao contaVotos(int idPauta) {
        int sim = 0; int nao = 0;
        String votacao = "";
        for (int i = 0; i < votos.size(); i++) {
            if (votos.get(i).getPauta().getIdPauta()==idPauta&&votos.get(i).getEscolha()=='S') {
                sim++;
            }
            if (votos.get(i).getPauta().getIdPauta()==idPauta&&votos.get(i).getEscolha()=='N') {
                nao++;
            }
        }
        System.out.println("Total de Votos: " + (sim+nao));
        System.out.println("Votos Sim: " + sim);
        System.out.println("Votos Não: " + nao);
        if (sim>nao){votacao = "Pauta id="+idPauta+" Aprovada!";}
        if (sim<nao){votacao = "Pauta id="+idPauta+" Não Aprovada!";}
        if (sim==nao){votacao = "Pauta id="+idPauta+" precisa nova votação!";}
        System.out.println("Decisão: " + votacao);
        Pauta pauta = gerenciadorPautaGerenciador.pesquisar(idPauta);
        Decisao decisao = new Decisao(pauta, sim,nao,sim+nao,votacao);
        System.out.println(decisao);
        return decisao;
    }

}