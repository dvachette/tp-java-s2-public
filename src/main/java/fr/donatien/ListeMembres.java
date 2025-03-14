package fr.donatien;

import java.util.ArrayList;

public class ListeMembres {
    private ArrayList<MembreBibliotheque> membres;
    public ListeMembres() {
        this.membres = new ArrayList<MembreBibliotheque>();
    }
    public boolean ajMembre(MembreBibliotheque membreAj) {
        boolean result = false;
        if (membreAj != null && !this.membres.contains(membreAj)) {
            this.membres.add(membreAj);
            result = true;
        }
        return result;
    }
    public MembreBibliotheque accesMembre(int i) {
        if (i >= 0 && i < this.membres.size()) {
            return this.membres.get(i);
        }
        return null;
    }
    public void afficheTousLesMembres() {
        for (int i = 0; i < membres.size(); i++) {
            System.out.println(membres.get(i));
        }
    }
    public int getNombreMembres() {
        return this.membres.size();
    }
    public boolean supMembre(MembreBibliotheque membreSup) {
        boolean result = false;
        if (membreSup != null && this.membres.contains(membreSup)) {
            this.membres.remove(membreSup);
            result = true;
        }
        return result;
    }

    public String toString() {
        String ans = this.getClass().getName() + " {\n" ;
        for (int i = 0; i < membres.size(); i++) {
            ans += membres.get(i).toString() + "\n";
        }
        ans += "}";
        return ans;
    }
}
