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
        
        int choice = -1;
        DocBibliotheque doc = null;
        MembreBibliotheque membre = null;

        System.out.println("Gestion de la Bibliotheque");
        System.out.println("Programme créé par Donatien VACHETTE");
        System.out.println("\nCe programme permet de gerer les emprunts et réservations des documents de la bibliothèque");
        System.out.println("TP Java - IUT Info Lyon 1 - M. Belkhatir - 2025");
        while (choice != 0) {
            System.out.println("\n==========Menu Bibliotheque==========");
            System.out.println("1. Agir sur un document");
            System.out.println("2. Afficher un document");
            System.out.println("3. Afficher un membres");
            System.out.println("4. Afficher les informations de la bibliotheque");
            System.out.println("0. Quitter");
            System.out.print("Select a choice (0~5): ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    actOnDoc(users, docs, scanner);
                    break;
                case 2:
                    System.out.println("===========Afficher un document============");
                    doc = selectDocBibliotheque(docs, scanner);
                    System.out.println(doc);
                    break;
                case 3:
                    System.out.println("===========Afficher un membre==============");
                    membre = selectMembreBibliotheque(users, scanner);
                    System.out.println(membre);
                    break;
                case 4:
                    System.out.println("==========Informations sur la bibliotheque=======");
                    System.out.printf("Nombre de documents empruntés :%s %3d %s\n",ANSI_PURPLE, DocBibliotheque.getNombreDocEmpruntes(), ANSI_RESET);
                    System.out.printf("Nombre de documents réservés  :%s %3d %s\n",ANSI_PURPLE, DocBibliotheque.getNombreDocReserve(), ANSI_RESET);
                    System.out.printf("Nombre de documents en retour :%s %3d %s\n",ANSI_PURPLE, DocBibliotheque.getNombreDocRetour(), ANSI_RESET);
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
    public static void actOnDoc(ArrayList<MembreBibliotheque> users, ArrayList<DocBibliotheque> docs, Scanner scanner) {
        int choice = -1;
        MembreBibliotheque membre = null;
        DocBibliotheque doc = null;
        do {
            System.out.println("==========Action document============");
            System.out.println("1. Emprunter un document");
            System.out.println("2. Rendre un document");
            System.out.println("3. Reserver un document");
            System.out.println("4. Annuler une réservation");
            System.out.println("0. Revenir au menu principal");
            System.out.print("Enter your choice (0~4) : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("===========Emprunter un document===========");
                    System.out.println("-----------Choisir l'emprunteur------------");
                    membre = selectMembreBibliotheque(users, scanner);
                    System.out.println("-----------Choisir le document-------------");
                    doc = selectDocBibliotheque(docs, scanner);
                    if (doc.emprunter(membre)) {
                        succes("Emprunt reussi");
                    } else {
                        fail("Emprunt echoue");
                    }
                    break;
                case 2:
                    System.out.println("===========Rendre un document==============");
                    System.out.println("-----------Choisir le document-------------");
                    doc = selectDocBibliotheque(docs, scanner);
                    if (doc.retourner()) {
                        succes("Retour reussi");
                    } else {
                        fail("Retour echoue");
                    }
                    break;
                case 3:
                    System.out.println("===========Reserver un document============");
                    System.out.println("-----------Choisir le reservant------------");
                    membre = selectMembreBibliotheque(users, scanner);
                    System.out.println("-----------Choisir le document-------------");
                    doc = selectDocBibliotheque(docs, scanner);
                    if (doc.reserver(membre)) {
                        succes("Reservation reussi");
                    } else {
                        fail("Reservation echoue");
                    }
                    break;
                case 4:
                    System.out.println("===========Annuler une réservation=========");
                    doc = selectDocBibliotheque(docs, scanner);
                    membre = selectMembreBibliotheque(users, scanner);
                    if (doc.annulerReservation(membre)) {
                        succes("Annulation réussie");
                    } else {
                        fail("Annulation échouée");
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        } while (choice != 0);
    }

    public static MembreBibliotheque selectMembreBibliotheque(ArrayList<MembreBibliotheque> users, Scanner scanner) {
        MembreBibliotheque selectedUser = null;
        int selectedUserIndex = -1;
        // Display all users
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ". " + ANSI_CYAN + "User : " + users.get(i).getNom() + " " + users.get(i).getPrenom()
                    + " : " + users.get(i).getNumeroAbonne() + ANSI_RESET);
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
            System.out.println(i + ". " + ANSI_CYAN + "Doc : " + docs.get(i).getTitre() + " : " + docs.get(i).getAuteur()
                    + " : " + docs.get(i).getAnnee() + ANSI_RESET);
        }
        // Select a doc
        do {
            System.out.println("Select a choice (0~%d): ".formatted(docs.size() - 1)); 
            selectedDocIndex = scanner.nextInt();
        } while (selectedDocIndex < 0 || selectedDocIndex >= docs.size());
        selectedDoc = docs.get(selectedDocIndex);
        return selectedDoc;
    }
    
    public static void succes(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void fail(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);

    }
}
