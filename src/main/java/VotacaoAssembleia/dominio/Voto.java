package VotacaoAssembleia.dominio;

public class Voto {

    private int idVoto;
    private Pauta pauta;
    private Associado associado;
    private char escolha;

    public Voto(Pauta pauta, Associado associado, char escolha) {
        this.pauta = pauta;
        this.associado = associado;
        this.escolha = escolha;
    }

    public Associado getAssociado() {
        return associado;
    }

    public int getIdVoto() {
        return idVoto;
    }

    public char getEscolha() {
        return escolha;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setIdVoto(int idVoto) {
        this.idVoto = idVoto;
    }


    @Override
    public String toString() {
        return "Voto{" +
                "idVoto=" + idVoto +
                ", pauta=" + pauta +
                ", associado=" + associado +
                ", escolha='" + escolha + '\'' +
                '}';
    }
}
