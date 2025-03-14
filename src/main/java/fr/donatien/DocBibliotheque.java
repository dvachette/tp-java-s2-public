package fr.donatien;

import java.time.Year;
import java.util.Objects;

public class DocBibliotheque {
    private String codeArchivage;
    private String titre;
    private String auteur;
    private int annee;
    private String emplacement;
    private static int nombreDocEmpruntes = 0;
    private static int nombreDocReserve = 0;
    private static int nombreDocRetour = 0;
    private MembreBibliotheque membreEmprunteur;
    private MembreBibliotheque membreReservant;

    public DocBibliotheque() {
        this.codeArchivage = "";
        this.titre = "";
        this.auteur = "";
        this.annee = 0;
        this.emplacement = "Etagere";
        this.membreEmprunteur = null;
        this.membreReservant = null;
    }

    public DocBibliotheque(String codeArchivage, String titre, String auteur, int annee) {
        this.codeArchivage = codeArchivage;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.emplacement = "Etagere";
        this.membreEmprunteur = null;
        this.membreReservant = null;
    }

    public boolean reserver(MembreBibliotheque membreReservant) {
        boolean result = false;
        if (this.getEmplacement().equals("Emprunte")) {
            result = true;
            this.membreReservant = membreReservant;
        }
        return result;
    }

    public boolean emprunter(MembreBibliotheque membreEmprunteur) {
        boolean result = false;
        if (!Objects.equals(membreEmprunteur, null)) {
            if (this.getEmplacement().equals("Etagere")) {
                this.emplacement = "Emprunte";
                result = true;
                this.membreEmprunteur = membreEmprunteur;
                nombreDocEmpruntes++;
            } else if (this.getEmplacement().equals("Reserve") && Objects.equals(this.membreReservant, membreEmprunteur)) {
                this.emplacement = "Emprunte";
                this.membreEmprunteur = membreEmprunteur;
                this.membreReservant = null;
                result = true;
                nombreDocEmpruntes++;
                nombreDocReserve--;
            }
        }
        return result;
    }

    public boolean retourner() {
        boolean result = false;
        if (this.estEmprunte()) {
            if (!Objects.equals(this.membreReservant, null)) {
                this.emplacement = "Reserve";
                nombreDocReserve++;
            } else {
                this.emplacement = "Retour";
                nombreDocRetour++;
            }
            result = true;
            this.membreEmprunteur = null;
            nombreDocEmpruntes--;
        }
        return result;
    }

    public boolean annulerReservation(MembreBibliotheque membreAnnulant) {
        boolean result = false;
        if (!Objects.equals(this.membreReservant, null) && membreReservant.equals(membreAnnulant)) {
            this.membreReservant = null;
            if (this.getEmplacement().equals("Reserve")) {
                this.emplacement = "Etagere";
                nombreDocReserve--;
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

    public static int getNombreDocReserve() {
        return nombreDocReserve;
    }

    public static int getNombreDocRetour() {
        return nombreDocRetour;
    }

    public boolean estDisponible() {
        return this.getEmplacement().equals("Etagere");
    }

    public boolean estReserve() {
        return !Objects.equals(this.membreReservant, null);
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

    public boolean setCodeArchivage(String codeArchivage) {
        boolean ans = false;
        if (!(codeArchivage == null || codeArchivage.isEmpty())) {
            this.codeArchivage = codeArchivage;
            ans = true;
        }
        return ans;
    }

    public String getTitre() {
        return titre;
    }

    public boolean setTitre(String titre) {
        boolean ans = false;
        if (!(titre == null || titre.isEmpty())) {
            this.titre = titre;
            ans = true;
        }
        return ans;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean setAuteur(String auteur) {
        boolean ans = false;
        if (!(auteur == null || auteur.isEmpty())) {
            this.auteur = auteur;
            ans = true;
        }
        return ans;
    }

    public int getAnnee() {
        return annee;
    }

    public boolean setAnnee(int annee) {
        boolean ans = false;
        if (annee <= Year.now().getValue() && annee != 0) {
            this.annee = annee;
            ans = true;
        }
        return ans;
    }

    public String toString() {
        return String.format(
                "%s {\n\tCode d'archivage : %s\n\tTitre : %s\n\tAuteur : %s\n\tAnnée : %d\n\tEmplacement : %s\n\tMembre emprunteur : %s\n\tMembre reservant : %s\n}",
                this.getClass().getName(),
                this.codeArchivage,
                this.titre,
                this.auteur,
                this.annee,
                this.emplacement,
                this.membreEmprunteur,
                this.membreReservant);
    }

    public MembreBibliotheque getMembreEmprunteur() {
        return this.membreEmprunteur;
    }

    public MembreBibliotheque getMembreReservant() {
        return this.membreReservant;
    }
}
