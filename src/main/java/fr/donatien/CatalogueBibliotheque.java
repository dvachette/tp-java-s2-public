package fr.donatien;

import java.util.ArrayList;
import java.util.Objects;

public class CatalogueBibliotheque {
    private ArrayList<DocBibliotheque> docs;
    public CatalogueBibliotheque() {
        this.docs = new ArrayList<DocBibliotheque>();
    }
    public boolean ajDoc(DocBibliotheque docAj) {
        boolean result = false;
        if (docAj != null && !this.docs.contains(docAj)) {
            result = this.docs.add(docAj);
        }
        return result;
    }

    public boolean supDoc(DocBibliotheque docSup) {
        boolean result = false;
        if (docSup != null && this.docs.contains(docSup)) {
            result = this.docs.remove(docSup);
        }
        return result;
    }

    public DocBibliotheque accesDoc(int i) {
        DocBibliotheque doc = null;
        if (i >= 0 && i < this.docs.size()) {
            doc = this.docs.get(i);
        }
        return doc;
    }

    public void afficheTousLesDocs() {

        for (int i = 0; i < this.docs.size(); i++) {
            System.out.println(docs.get(i));
        }
    }

    public void afficheDocsEmpruntes() {
        for (int i = 0; i < this.docs.size(); i++) {
            if (docs.get(i).estEmprunte()) {
                System.out.println(docs.get(i));
            }
        }
    }
    public int getNombreDocs() {
        return this.docs.size();
    }

    public String toString() {
        String ans = this.getClass().getName() + " {\n" ;
        for (int i = 0; i < this.docs.size(); i++) {
            ans += docs.get(i).toString() + "\n";
        }
        ans += "}";
        return ans;
    }

    public boolean emprunteDoc(int indiceDoc, MembreBibliotheque m) {
        boolean result = false;
        DocBibliotheque doc = this.accesDoc(indiceDoc);
        if (!Objects.equals(doc, null)) {
            result = doc.emprunter(m);
        }
        return result;
    }
    
    public boolean reserveDoc(int indiceDoc, MembreBibliotheque m) {
        boolean result = false;
        DocBibliotheque doc = this.accesDoc(indiceDoc);
        if (!Objects.equals(doc, null) && !Objects.equals(m, null)) {
            result = doc.reserver(m);
        }
        return result;
    }

    public boolean annulResaDoc(int indiceDoc, MembreBibliotheque m) {
        boolean result = false;
        DocBibliotheque doc = this.accesDoc(indiceDoc);
        if (!Objects.equals(doc, null) && !Objects.equals(m, null)) {
            result = doc.annulerReservation(m);
        }
        return result;
    }

    public boolean rendreDoc(int indiceDoc) {
        boolean result = false;
        DocBibliotheque doc = this.accesDoc(indiceDoc);
        if (!Objects.equals(doc, null)) {
            result = doc.retourner();
        }
        return result;
    }
}
