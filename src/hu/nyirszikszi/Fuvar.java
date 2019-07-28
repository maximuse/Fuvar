package hu.nyirszikszi;

class Fuvar {
    private int taxiId;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesModja;

    Fuvar(int taxiId, String indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetesModja) {
        this.taxiId = taxiId;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    int getTaxiId() {
        return taxiId;
    }

    String getIndulas() {
        return indulas;
    }

    int getIdotartam() {
        return idotartam;
    }

    double getTavolsag() {
        return tavolsag;
    }

    double getViteldij() {
        return viteldij;
    }

    double getBorravalo() {
        return borravalo;
    }

    String getFizetesModja() {
        return fizetesModja;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "taxiId=" + taxiId +
                ", indulas='" + indulas + "'" +
                ", idotartam=" + idotartam +
                ", tavolsag=" + tavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetesModja='" + fizetesModja + "'" +
                "}\n";
    }
}