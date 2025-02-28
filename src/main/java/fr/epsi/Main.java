package fr.epsi;

public class Main {
    public static void main(String[] args) {
        LivreDAO livreDAO = new LivreDAO();
        EmpruntDAO empruntDAO = new EmpruntDAO();
        ClientDAO clientDAO = new ClientDAO();

        // Trouver un livre par son ID
        Livre livre = livreDAO.findById(1);
        if (livre != null) {
            System.out.println("Livre trouvé : " + livre.getTitre() + " de " + livre.getAuteur());
        } else {
            System.out.println("Aucun livre trouvé !");
        }

        // Trouver un emprunt par son ID et afficher les livres associés
        int empruntId = 1; // ID à tester
        Emprunt emprunt = empruntDAO.findById(empruntId);
        if (emprunt != null) {
            System.out.println("\nEmprunt ID: " + emprunt.getId() + ", Date de début: " + emprunt.getDateDebut());
            System.out.println("Livres associés :");
            emprunt.getLivres().forEach(l -> System.out.println("- " + l.getTitre() + " de " + l.getAuteur()));
        } else {
            System.out.println("Aucun emprunt trouvé pour l'ID " + empruntId);
        }

        // Trouver tous les emprunts d’un client donné avec gestion du Lazy Loading
        int clientId = 1; // ID à tester
        Client client = clientDAO.findByIdWithEmprunts(clientId); // Utilisation de la version avec FETCH
        if (client != null) {
            System.out.println("\nEmprunts du client " + client.getNom() + " " + client.getPrenom() + " :");
            client.getEmprunts().forEach(emp ->
                    System.out.println("- Emprunt ID: " + emp.getId() + ", Date de début: " + emp.getDateDebut())
            );
        } else {
            System.out.println("Aucun client trouvé pour l'ID " + clientId);
        }
    }
}
