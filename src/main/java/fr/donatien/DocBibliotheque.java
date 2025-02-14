package fr.donatien;

public class DocBibliotheque {
    private String codeArchivage;
    private String titre;
    private String auteur;
    private int annee;
    private String emplacement;
    private boolean reserve;
    private static int nombreDocEmpruntes = 0;
    private static int nombreDocReserves = 0;
    private static int nombreDocRetour = 0;

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
            nombreDocReserves++;
        }
        return result;
    }

    public boolean emprunter() {
        boolean result = false;
        if (this.getEmplacement().equals("Etagere")) {
            this.emplacement = "Emprunte";
            result = true;
            nombreDocEmpruntes++;
        }
        if (this.getEmplacement().equals("Reserve")) {
            this.emplacement = "Emprunte";
            this.reserve = false;
            result = true;
            nombreDocEmpruntes++;
            nombreDocReserves--;
        }
        return result;

    }

    public boolean retourner() {
        boolean result = false;
        if (this.estEmprunte()) {
            if (this.reserve) {
                this.emplacement = "Reserve";
                nombreDocReserves++;
            } else {
                this.emplacement = "Retour";
                nombreDocRetour++;
            }
            result = true;
            nombreDocEmpruntes--;
        }
        return result;
    }

    public boolean annulerReservation() {
        boolean result = false;
        if (this.reserve) {
            this.reserve = false;
            if (this.getEmplacement().equals("Reserve")) {
                this.emplacement = "Etagere";
                nombreDocReserves--;
            }
            result = true;
        }
        return result;
    }

    public boolean ranger() {
        boolean result = false;
        if (this.getEmplacement().equals("Retour")) {
            this.emplacement = "Etagere";
            nombreDocRetour--;
            result = true;
        }
        return result;
    }

    public static int getNombreDocEmpruntes() {
        return nombreDocEmpruntes;
    }

    public static int getNombreDocReserves() {
        return nombreDocReserves;
    }

    public static int getNombreDocRetour() {
        return nombreDocRetour;
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
