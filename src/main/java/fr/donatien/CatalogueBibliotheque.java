package fr.donatien;

import java.util.ArrayList;

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
        if (i >= 0 && i < this.docs.size()) {
            return this.docs.get(i);
        }
        return null;
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
}
