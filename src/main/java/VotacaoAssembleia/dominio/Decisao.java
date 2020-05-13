package VotacaoAssembleia.dominio;

public class Decisao {
    Pauta pauta;
    int sim;
    int nao;
    int total;
    String decisao;

    public Decisao(Pauta pauta, int sim, int nao, int total, String decisao) {
        this.pauta = pauta;
        this.sim = sim;
        this.nao = nao;
        this.total = total;
        this.decisao = decisao;
    }

      @Override
    public String toString() {
        return "Decisao{" +
                "pauta=" + pauta +
                ", sim=" + sim +
                ", nao=" + nao +
                ", total=" + total +
                ", decisao='" + decisao + '\'' +
                '}';
    }

    public Pauta getPauta() {
        return pauta;
    }

    public int getSim() {
        return sim;
    }

    public int getNao() {
        return nao;
    }

    public int getTotal() {
        return total;
    }

    public String getDecisao() {
        return decisao;
    }
}
