package fr.donatien;

public class DocBibliotheque {
    private String codeArchivage;
    private String titre;
    private String auteur;
    private int annee;
    private String emplacement;
    private boolean reserve;

    public DocBibliotheque() {
        this.codeArchivage = "";
        this.titre = "";
        this.auteur = "";
        this.annee = 0;
        this.emplacement = "Etagere";
        this.reserve = false;
    }

    public DocBibliotheque(String codeArchivage, String titre, String auteur, int annee) {
        this.codeArchivage = codeArchivage;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.emplacement = "Etagere";
        this.reserve = false;
    }

    public boolean reserver() {
        boolean result = false;
        if (this.getEmplacement().equals("Emprunte")) {
            this.reserve = true;
            result = true;
        }
        return result;
    }

    public boolean emprunter() {
        boolean result = false;
        if (this.getEmplacement().equals("Etagere")) {
            this.emplacement = "Emprunte";
            result = true;
        }
        if (this.getEmplacement().equals("Reserve")) {
            this.emplacement = "Emprunte";
            this.reserve = false;
            result = true;
        }
        return result;

    }

    public boolean retourner() {
        boolean result = false;
        if (this.estEmprunte()) {
            this.emplacement = "Retour";
            result = true;
        }
        return result;
    }

    public boolean annulerReservation() {
        boolean result = false;
        if (this.reserve) {
            this.reserve = false;
            if (this.getEmplacement().equals("Reserve")) {
                this.emplacement = "Etagere";
            }
            result = true;
        }
        return result;
    }

    public boolean ranger() {
        boolean result = false;
        if (this.getEmplacement().equals("Retour")) {
            if (this.reserve) {
                this.emplacement = "Reserve";
            } else {
                this.emplacement = "Etagere";
            }
            result = true;
        }
        return result;
    }

    public boolean estDisponible() {
        return this.getEmplacement().equals("Etagere");
    }

    public boolean estReserve() {
        return this.reserve;
    }

    public boolean estEmprunte() {
        return this.getEmplacement().equals("Emprunte");
    }

    public String getEmplacement() {
        return emplacement;
    }

    public String getCodeArchivage() {
        return codeArchivage;
    }

    public void setCodeArchivage(String codeArchivage) {
        this.codeArchivage = codeArchivage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String toString() {
        return "Code d'archivage: " + codeArchivage + "\nTitre: " + titre + "\nAuteur: " + auteur + "\nAnnée: " + annee
                + "\nEmplacement: " + emplacement + "\nReservé: " + reserve;
    }
}
