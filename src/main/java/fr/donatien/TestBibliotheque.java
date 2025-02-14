package fr.donatien;

public class TestBibliotheque {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static int testCount = 0;
    public static int testPassed = 0;

    public static void main(String[] args) {
        DocBibliotheque doc1 = new DocBibliotheque("004. 178 K20PM", "Je suis parfait mais je gère", "D. Vachette",
                2015);
        DocBibliotheque doc2 = new DocBibliotheque("005. 181 A74PM", "Le tresor", "Tintin", 2015);
        DocBibliotheque doc3 = new DocBibliotheque("110. 121 E63NP", "Windows sucks", "Bill Gates", 2000);

        System.out.println("Document 1 : " + doc1);

        System.out.println("\nTest des getters : ");

        test("Getter code Archivage de doc1", doc1.getCodeArchivage(), "004. 178 K20PM");
        test("Getter titre de doc1", doc1.getTitre(), "Introduction à Java");
        test("Getter auteur de doc1", doc1.getAuteur(), "J. Leblanc");
        test("Getter année de doc1", doc1.getAnnee(), 2015);

        System.out.println("\nTest des setters : ");

        doc1.setCodeArchivage("123. 456 K78PM");
        doc1.setTitre("Java pour les nuls");
        doc1.setAnnee(2010);

        test("Code Archivage de doc1 mis à jour", doc1.getCodeArchivage(), "123. 456 K78PM");
        test("Titre de doc1 mis à jour", doc1.getTitre(), "Java pour les nuls");
        test("Année de doc1 mis à jour", doc1.getAnnee(), 2010);

        System.out.println("\nTest des méthodes : ");

        test("Emprunt de doc1", doc1.emprunter(), true);
        test("Doc1 est emprunté", doc1.estEmprunte(), true);
        test("Emprunt de doc1 (deja emprunté)", doc1.emprunter(), false);
        test("Retour de doc1", doc1.retourner(), true);
        test("Doc1 est dans la pile de retour", doc1.getEmplacement(), "Retour");
        test("Retour de doc1 (pas emprunté)", doc1.retourner(), false);
        test("Rangement de doc1", doc1.ranger(), true);
        test("Doc1 est rangé", doc1.getEmplacement(), "Etagere");
        test("Réservation de doc1", doc1.reserver(), false);
        test("Doc1 n'est pas réservé", doc1.estReserve(), false);
        doc1.emprunter();
        test("Doc1 est emprunté", doc1.estEmprunte(), true);
        test("Réservation de doc1 (emprunté)", doc1.reserver(), true);
        test("Doc1 est réservé", doc1.estReserve(), true);
        doc1.retourner();
        test("Doc1 n'est dans la pile de retour", doc1.getEmplacement(), "Reserve");
        test("Doc1 est dans la pile de réservation", doc1.getEmplacement(), "Reserve");
        test("Annulation de la réservation de doc1", doc1.annulerReservation(), true);
        test("Doc1 n'est plus réservé", doc1.estReserve(), false);
        test("Doc1 est rangé", doc1.getEmplacement(), "Etagere");

        System.out.println("\nTests des compteurs : ");

        test("Nombre de documents empruntés", DocBibliotheque.getNombreDocEmpruntes(), 0);
        test("Nombre de documents dans la section reservé", DocBibliotheque.getNombreDocReserve(), 0);
        test("Nombre de documents dans la pile de retour", DocBibliotheque.getNombreDocRetour(), 0);
        doc1.emprunter();
        test("Nombre de documents empruntés", DocBibliotheque.getNombreDocEmpruntes(), 1);
        doc2.emprunter();
        test("Nombre de documents empruntés", DocBibliotheque.getNombreDocEmpruntes(), 2);
        doc1.retourner();
        test("Nombre de documents dans la pile de retour", DocBibliotheque.getNombreDocRetour(), 1);
        doc3.emprunter();
        test("Nombre de documents empruntés", DocBibliotheque.getNombreDocEmpruntes(), 2);
        doc2.reserver();
        test("Nombre de documents dans la section reservé", DocBibliotheque.getNombreDocReserve(), 0);
        doc2.retourner();
        test("Nombre de documents dans la pile de retour", DocBibliotheque.getNombreDocRetour(), 1);
        doc1.ranger();
        test("Nombre de documents empruntés", DocBibliotheque.getNombreDocEmpruntes(), 1);
        test("Nombre de documents dans la section reservé", DocBibliotheque.getNombreDocReserve(), 1);
        test("Nombre de documents dans la pile de retour", DocBibliotheque.getNombreDocRetour(), 0);
        System.out.println("\n" + testPassed + " tests réussis sur " + testCount);
    }

    public static void test(String intitule, Object expression, Object expected) {
        testCount++;
        if (expression.equals(expected)) {
            System.out.print(ANSI_GREEN);
            testPassed++;
        } else {
            System.out.print(ANSI_RED);
        }
        System.out.println("\nTest : ");
        System.out.println(intitule);
        System.out.println("Expression : " + expression);
        System.out.println("Attendu : " + expected);
        System.out.println("Obtenu : " + expression);
        System.out.print(ANSI_RESET);
    }
}