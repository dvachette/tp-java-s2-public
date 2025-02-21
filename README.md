# Module R2.01-1 – Java

## TP Gestion de Bibliothèque Informatisée (2/5)

### Associations - Mise en œuvre de la classe MembreBibliotheque

La bibliothèque universitaire doit également répertorier ses membres. L’information les concernant est : le nom, le prénom, le numéro de téléphone, l'adresse ainsi que le numéro d’abonné du membre.

#### Tâche 1

Créer la classe `MembreBibliotheque`, représentant un membre. A cette étape, implémentez les attributs, un constructeur (de manière à ce que toute l’information à propos du membre, excepté son numéro d'abonné qui est un entier incrémenté automatiquement, soit passée en paramètre) ainsi que les accesseurs appropriés.
Note : ajouter un attribut `dernierNumeroAbonne` incrémenté de 1 à chaque création d'un
membre pour permettre l’affectation automatique du numéro d'abonné ; les numéros d'abonné
débuteront à 1.

#### Tâche 2

Modifier les méthodes implémentées dans le cadre de la tâche 7 de la séance précédente de manière à prendre en compte :

- la possibilité de compter le nombre de documents empruntés, le nombre de documents sur la pile ainsi que le nombre de documents dans la section spéciale "réservations" en ajoutant les attributs correspondants,
- le fait qu’un membre de la bibliothèque puisse emprunter un document ou faire une réservation. Vous ajouterez deux attributs permettant à un objet `DocBibliotheque` de caractériser :
  - i) le membre l’ayant emprunté,
  - ii) le membre ayant fait une réservation sur celui-ci pendant qu’il est emprunté.

#### Tâche 3

Ecrire des accesseurs de manière à pouvoir déterminer quel membre a emprunté ou a réservé un document (pensez au type du résultat retourné). Que dire du cas où le document n’est ni emprunté, ni réservé?

#### Tâche 4

Ajouter la méthode `public String toString()` dans les classes `DocBibliotheque` et `MembreBibliotheque` pour présenter à l'écran, en mode texte, les informations relatives à un document ou un membre.

#### Tâche 5

Modifier la classe `TestBibliotheque` de manière à prendre en compte les changements mis en œuvre dans le cadre de ce TP.



*Enregistrer les classes ainsi mises en œuvre et les sauvegarder dans un dossier.*

