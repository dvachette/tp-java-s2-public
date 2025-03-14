package fr.donatien;

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

    public static void main(String[] args) {
        DocBibliotheque doc1 = new DocBibliotheque("004. 178 K20PM", "Je suis parfait mais je gère", "D. Vachette",
                2015);
        DocBibliotheque doc2 = new DocBibliotheque("005. 181 A74PM", "Le tresor", "Tintin", 2015);
        DocBibliotheque doc3 = new DocBibliotheque("110. 121 E63NP", "Windows sucks", "Bill Gates", 2000);

        MembreBibliotheque user1 = new MembreBibliotheque("Vachette", "Donatien", "06.77.70.59.31", "IUT INFO LYON 1");
        MembreBibliotheque user2 = new MembreBibliotheque("Fayt", "Ethan", "06.00.00.00.00",
                "je sais pas rue de l'ignorance");
        CatalogueBibliotheque catalogue = new CatalogueBibliotheque();
        catalogue.ajDoc(doc1);
        catalogue.ajDoc(doc2);
        catalogue.ajDoc(doc3);


        ListeMembres listeMembres = new ListeMembres();
        listeMembres.ajMembre(user1);
        listeMembres.ajMembre(user2);


        Scanner scanner = new Scanner(System.in);
        
        int choice = -1;
        DocBibliotheque doc = null;
        MembreBibliotheque membre = null;

        int userIndex = -1;
        int docIndex = -1;
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
            System.out.print("Select a choice (0~4): ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    actOnDoc(listeMembres, catalogue, scanner);
                    break;
                case 2:
                    System.out.println("===========Afficher un document============");
                    docIndex = selectDocBibliothequeIndex(catalogue, scanner);
                    doc = catalogue.accesDoc(docIndex);
                    System.out.println(doc);
                    break;
                case 3:
                    System.out.println("===========Afficher un membre==============");
                    userIndex = selectMembreBibliothequeIndex(listeMembres, scanner);
                    membre = listeMembres.accesMembre(userIndex);
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
    public static void actOnDoc(ListeMembres users, CatalogueBibliotheque docs, Scanner scanner) {
        int choice = -1;
        MembreBibliotheque membre = null;
        DocBibliotheque doc = null;
        int membreIndex = -1;
        int docIndex = -1;
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
                    membreIndex = selectMembreBibliothequeIndex(users, scanner);
                    membre = users.accesMembre(membreIndex);
                    System.out.println("-----------Choisir le document-------------");
                    docIndex = selectDocBibliothequeIndex(docs, scanner);
                    doc = docs.accesDoc(docIndex);
                    if (doc.emprunter(membre)) {
                        succes("Emprunt reussi");
                    } else {
                        fail("Emprunt echoue");
                    }
                    break;
                case 2:
                    System.out.println("===========Rendre un document==============");
                    System.out.println("-----------Choisir le document-------------");
                    docIndex = selectDocBibliothequeIndex(docs, scanner);
                    doc = docs.accesDoc(docIndex);
                    if (doc.retourner()) {
                        succes("Retour reussi");
                    } else {
                        fail("Retour echoue");
                    }
                    break;
                case 3:
                    System.out.println("===========Reserver un document============");
                    System.out.println("-----------Choisir le reservant------------");
                    membreIndex = selectMembreBibliothequeIndex(users, scanner);
                    membre = users.accesMembre(membreIndex);
                    System.out.println("-----------Choisir le document-------------");
                    docIndex = selectDocBibliothequeIndex(docs, scanner);
                    doc = docs.accesDoc(docIndex);
                    if (doc.reserver(membre)) {
                        succes("Reservation reussi");
                    } else {
                        fail("Reservation echoue");
                    }
                    break;
                case 4:
                    System.out.println("===========Annuler une réservation=========");
                    System.out.println("-----------Choisir le reservant------------");
                    membreIndex = selectMembreBibliothequeIndex(users, scanner);
                    membre = users.accesMembre(membreIndex);
                    System.out.println("-----------Choisir le document-------------");
                    docIndex = selectDocBibliothequeIndex(docs, scanner);
                    doc = docs.accesDoc(docIndex);
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

    public static int selectDocBibliothequeIndex(CatalogueBibliotheque docs, Scanner scanner) {
        int selectedDocIndex = -1;
        int size = docs.getNombreDocs();
        
        // Display all docs
        DocBibliotheque currentDoc = null;
        for (int i = 0; i < size; i++) {
            currentDoc = docs.accesDoc(i);
            System.out.println(i + ". " + ANSI_CYAN + "Doc : " + currentDoc.getTitre() + " : " + currentDoc.getAuteur()
                    + " : " + currentDoc.getAnnee() + ANSI_RESET);
        }
        // Select a doc
        do {
            System.out.printf("Select a choice (0~%d): ",size - 1); 
            selectedDocIndex = scanner.nextInt();
        } while (selectedDocIndex < 0 || selectedDocIndex >= size);
        return selectedDocIndex;
    }

    public static int selectMembreBibliothequeIndex(ListeMembres users, Scanner scanner) {
        int selectedUserIndex = -1;
        int size = users.getNombreMembres();
        // Display all users
        MembreBibliotheque currentUser = null;
        for (int i = 0; i < size; i++) {
            currentUser = users.accesMembre(i);
            System.out.println(i + ". " + ANSI_CYAN + "User : " + currentUser.getNom() + " : " + currentUser.getPrenom()
                    + " : " + currentUser.getNumeroAbonne() + ANSI_RESET);
        }
        
        // Select a user
        
        do {
            System.out.printf("Select a choice (0~%d): ", size - 1); 
            selectedUserIndex = scanner.nextInt();
        } while (selectedUserIndex < 0 || selectedUserIndex >= size);
        
        return selectedUserIndex;
    }

    public static void succes(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void fail(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);

    }
}
