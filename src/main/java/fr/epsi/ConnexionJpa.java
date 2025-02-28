package fr.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comptaPU");

        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Connexion à la base de données réussie !");

            // 🔹 Test : Récupérer un emprunt par son ID et afficher les livres associés
            int empruntId = 1; // Exemple d'ID à tester
            Emprunt emprunt = em.find(Emprunt.class, empruntId);
            if (emprunt != null) {
                System.out.println("Emprunt ID: " + emprunt.getId() + ", Date de début: " + emprunt.getDateDebut());
                System.out.println("Livres associés :");
                emprunt.getLivres().forEach(livre ->
                        System.out.println("- " + livre.getTitre() + " de " + livre.getAuteur())
                );
            } else {
                System.out.println("Aucun emprunt trouvé pour l'ID " + empruntId);
            }

            // 🔹 Test : Récupérer tous les emprunts d'un client donné
            int clientId = 1; // Exemple d'ID à tester
            Client client = em.find(Client.class, clientId);
            if (client != null) {
                System.out.println("\nEmprunts du client " + client.getNom() + " " + client.getPrenom() + " :");
                client.getEmprunts().forEach(emp ->
                        System.out.println("- Emprunt ID: " + emp.getId() + ", Date de début: " + emp.getDateDebut())
                );
            } else {
                System.out.println("Aucun client trouvé pour l'ID " + clientId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}