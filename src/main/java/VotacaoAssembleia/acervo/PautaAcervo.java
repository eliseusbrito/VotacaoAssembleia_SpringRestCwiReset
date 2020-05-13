package VotacaoAssembleia.acervo;

import VotacaoAssembleia.dominio.Pauta;

import java.util.ArrayList;
import java.util.List;

public class PautaAcervo {
    private static int contador = 1;
    public static final List<Pauta> pautas = new ArrayList<>();

    public Pauta salvar(Pauta pauta) {
        pauta.setIdPauta(contador++);
        pautas.add(pauta);
        System.out.println("Cadastrou a "+pauta);
        return pauta;
    }

    public List<Pauta> listar() {
        System.out.println("Listou todas as pautas.");
        return pautas;
    }

    public Pauta pesquisar(int id) {
        for (Pauta pauta : pautas) {
            if (pauta.getIdPauta() == id) {
                return pauta;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Pauta pautaParaDeletar = pesquisar(id);
        if (pautaParaDeletar != null) {
            System.out.println("Excluiu pauta.");
            return pautas.remove(pautaParaDeletar);
        }
        return false;
    }

    public Pauta editar(final Pauta pautaParaEditar, final Pauta pautaAtualizado) {
        pautaParaEditar.setDescricao(pautaAtualizado.getDescricao());
        System.out.println("Editou pauta.");
        return pautaParaEditar;
    }

}

