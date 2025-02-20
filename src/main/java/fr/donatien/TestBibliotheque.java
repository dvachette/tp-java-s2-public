package fr.donatien;

import java.util.ArrayList;
import java.util.Scanner;

public class TestBibliotheque {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static int testCount = 0;
    public static int testPassed = 0;

    public static void main(String[] args) {
        DocBibliotheque doc1 = new DocBibliotheque("004. 178 K20PM", "Je suis parfait mais je gère", "D. Vachette",
                2015);
        DocBibliotheque doc2 = new DocBibliotheque("005. 181 A74PM", "Le tresor", "Tintin", 2015);
        DocBibliotheque doc3 = new DocBibliotheque("110. 121 E63NP", "Windows sucks", "Bill Gates", 2000);

        MembreBibliotheque user1 = new MembreBibliotheque("Vachette", "Donatien", "06.77.70.59.31", "IUT INFO LYON 1");
        MembreBibliotheque user2 = new MembreBibliotheque("Fayt", "Ethan", "06.00.00.00.00",
                "je sais pas rue de l'ignorance");
        ArrayList<DocBibliotheque> docs = new ArrayList<DocBibliotheque>();
        docs.add(doc1);
        docs.add(doc2);
        docs.add(doc3);

        ArrayList<MembreBibliotheque> users = new ArrayList<MembreBibliotheque>();
        users.add(user1);
        users.add(user2);

        Scanner scanner = new Scanner(System.in);

        MembreBibliotheque membre = selectMembreBibliotheque(users, scanner);
        System.out.println(membre);

        DocBibliotheque doc = selectDocBibliotheque(docs, scanner);
        System.out.println(doc);

        scanner.close();
    }
    public static MembreBibliotheque selectMembreBibliotheque(ArrayList<MembreBibliotheque> users, Scanner scanner) {
        MembreBibliotheque selectedUser = null;
        int selectedUserIndex = -1;
        // Display all users
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ". " + ANSI_CYAN + "User : " + users.get(i).getNom() + " " + users.get(i).getPrenom()
                    + " " + users.get(i).getNumeroAbonne() + ANSI_RESET);
        }
        
        // Select a user
        do {
            System.out.println("Select a choice (0~%d): ".formatted(users.size() - 1)); 
            selectedUserIndex = scanner.nextInt();
        } while (selectedUserIndex < 0 || selectedUserIndex >= users.size());
        
        selectedUser = users.get(selectedUserIndex);
        return selectedUser;
    }
        
    public static DocBibliotheque selectDocBibliotheque(ArrayList<DocBibliotheque> docs, Scanner scanner) {
        DocBibliotheque selectedDoc = null;
        int selectedDocIndex = -1;

        
        // Display all docs
        for (int i = 0; i < docs.size(); i++) {
            System.out.println(i + ". " + ANSI_CYAN + "Doc : " + docs.get(i).getTitre() + " " + docs.get(i).getAuteur()
                    + " " + docs.get(i).getAnnee() + ANSI_RESET);
        }
        // Select a doc
        do {
            System.out.println("Select a choice (0~%d): ".formatted(docs.size() - 1)); 
            selectedDocIndex = scanner.nextInt();
        } while (selectedDocIndex < 0 || selectedDocIndex >= docs.size());
        selectedDoc = docs.get(selectedDocIndex);
        return selectedDoc;
    }
}
