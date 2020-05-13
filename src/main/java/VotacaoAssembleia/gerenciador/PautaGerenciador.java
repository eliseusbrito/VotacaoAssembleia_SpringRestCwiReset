package VotacaoAssembleia.gerenciador;

import VotacaoAssembleia.acervo.PautaAcervo;
import VotacaoAssembleia.dominio.Pauta;
import java.util.List;

public class PautaGerenciador {

    private PautaAcervo acervo = new PautaAcervo();

    public Pauta salvar(Pauta pauta){
        return acervo.salvar(pauta);
    }

    public List<Pauta> listar() {
        return acervo.listar();
    }

    public Pauta pesquisar(int id) {
        if (id > 0) {
            return acervo.pesquisar(id);
        }
        return null;
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return acervo.deletar(id);
        }
        return false;
    }

    public Pauta editar(int id, Pauta pautaAtualizado) {

        Pauta pautaParaEditar = pesquisar(id);

        if (pautaParaEditar == null) {
            return null;
        } else {
            return acervo.editar(pautaParaEditar, pautaAtualizado);
        }
    }

}

