package fr.donatien;

public class MembreBibliotheque {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String adresse;
    private int numeroAbonne;
    private static int dernierNumeroAbonne = 1;

    public MembreBibliotheque(String nom, String prenom, String numeroTelephone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.adresse = adresse;
        this.numeroAbonne = dernierNumeroAbonne;
        dernierNumeroAbonne++;
    }

    public MembreBibliotheque() {
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.numeroTelephone = "Inconnu";
        this.adresse = "Inconnu";
        this.numeroAbonne = dernierNumeroAbonne;
        dernierNumeroAbonne++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (!(nom == null || nom.isEmpty())) {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (!(prenom == null || prenom.isEmpty())) {
            this.prenom = prenom;
        }
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        if (!(numeroTelephone == null || numeroTelephone.isEmpty())) {
            this.numeroTelephone = numeroTelephone;
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        if (!(adresse == null || adresse.isEmpty())) {
            this.adresse = adresse;
        }
    }

    public int getNumeroAbonne() {
        return numeroAbonne;
    }
}
