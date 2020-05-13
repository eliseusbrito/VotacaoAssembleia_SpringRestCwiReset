package VotacaoAssembleia.gerenciador;

import VotacaoAssembleia.acervo.AssociadoAcervo;
import VotacaoAssembleia.dominio.Associado;
import java.util.List;

public class AssociadoGerenciador {

    private AssociadoAcervo acervo = new AssociadoAcervo();

    public Associado salvar(Associado associado){
        List<Associado> associados = acervo.listar();
        if (associado.getNome().equals("")||associado.getCpf().equals("")){
            System.out.println("Algum campo não foi prenchido. O associado não foi cadastrado.");
            return null;        }
        for (Associado associadoExistente : associados) {
            if (associado.getCpf().equals(associadoExistente.getCpf())) {
                System.out.println("CPF já existente. O associado não foi cadastrado. ");
                return associadoExistente;
            }}
        return acervo.salvar(associado);
    }

    public List<Associado> listar() {
            return acervo.listar();
        }

    public Associado pesquisar(int id) {
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

    public Associado editar(int id, Associado associadoAtualizado) {
        Associado associadoParaEditar = pesquisar(id);
        if (associadoParaEditar == null) {
            return null;
        } else {
            return acervo.editar(associadoParaEditar, associadoAtualizado);
        }
    }

}





