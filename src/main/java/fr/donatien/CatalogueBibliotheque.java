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
            this.docs.add(docAj);
            result = true;
        }
        return result;
    }

    public boolean supDoc(DocBibliotheque docSup) {
        boolean result = false;
        if (docSup != null && this.docs.contains(docSup)) {
            this.docs.remove(docSup);
            result = true;
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
        for (DocBibliotheque doc : this.docs) {
            System.out.println(doc);
        }
    }

    public void afficheDocsEmpruntes() {
        for (DocBibliotheque doc : this.docs) {
            if (doc.estEmprunte()) {
                System.out.println(doc);
            }
        }
    }
    public int getNombreDocs() {
        return this.docs.size();
    }

    public String toString() {
        String ans = this.getClass().getName() + " {\n" ;
        for (DocBibliotheque doc : this.docs) {
            ans += doc.toString() + "\n";
        }
        ans += "}";
        return ans;
    }

    public boolean emprunteDoc(int indiceDoc, MembreBibliotheque m) {
        boolean result = false;
        DocBibliotheque doc = this.accesDoc(indiceDoc);
        if (!Objects.equals(doc, null) && !Objects.equals(m, null)) {
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
