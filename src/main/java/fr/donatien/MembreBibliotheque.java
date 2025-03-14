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

    public boolean setNom(String nom) {
        boolean ans = false;
        if (!(nom == null || nom.isEmpty())) {
            this.nom = nom;
            ans = true;
        }
        return ans;
    }

    public String getPrenom() {
        return prenom;
    }

    public boolean setPrenom(String prenom) {
        boolean ans = false;
        if (!(prenom == null || prenom.isEmpty())) {
            this.prenom = prenom;
            ans = true;
        }
        return ans;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public boolean setNumeroTelephone(String numeroTelephone) {
        boolean ans = false;
        if (!(numeroTelephone == null || numeroTelephone.isEmpty())) {
            this.numeroTelephone = numeroTelephone;
            ans = true;
        }
        return ans;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean setAdresse(String adresse) {
        boolean ans = false;
        if (!(adresse == null || adresse.isEmpty())) {
            this.adresse = adresse;
            ans = true;
        }
        return ans;
    }

    public int getNumeroAbonne() {
        return numeroAbonne;
    }

    public String toString() {
        return String.format(
                "%s {\n\tNom : %s\n\tPrenom : %s\n\tAdresse : %s\n\tN° de téléphone : %s\n\tN° abonné : %d\n}",
                this.getClass().getSimpleName(),
                this.nom,
                this.prenom,
                this.adresse,
                this.numeroTelephone,
                this.numeroAbonne);
    }

}
