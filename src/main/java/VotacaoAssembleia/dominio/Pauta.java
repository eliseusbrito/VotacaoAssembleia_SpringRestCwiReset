package VotacaoAssembleia.dominio;

public class Pauta {

    private int idPauta;
    private String descricao;

    public void setIdPauta(int idPauta) {
        this.idPauta = idPauta;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdPauta() {
        return idPauta;
    }

    @Override
    public String toString() {
        return "Pauta{" +
                "idPauta=" + idPauta +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
