package VotacaoAssembleia.acervo;

import VotacaoAssembleia.dominio.*;

import java.util.ArrayList;
import java.util.List;

public class AssociadoAcervo {
    private static int contador = 1;
    public static final List<Associado> associados = new ArrayList<>();

    public Associado salvar(Associado associado) {
        associado.setId(contador++);
        associados.add(associado);
        System.out.println("Cadastrou o "+associado);
        return associado;
    }

    public List<Associado> listar() {
       System.out.println("Listou todos os associados.");
       return associados;
    }

    public Associado pesquisar(int id) {
        for (Associado associado : associados) {
            if (associado.getId() == id) {
                return associado;
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Associado associadoParaDeletar = pesquisar(id);
        if (associadoParaDeletar != null) {
            System.out.println("Excluiu associado");
            return associados.remove(associadoParaDeletar);
        }
        return false;
    }

    public Associado editar(final Associado associadoParaEditar, final Associado associadoAtualizado) {
        associadoParaEditar.setNome(associadoAtualizado.getNome());
        System.out.println("Editou associado.");
        return associadoParaEditar;
    }

}

