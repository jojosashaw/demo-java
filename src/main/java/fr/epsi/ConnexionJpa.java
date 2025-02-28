package fr.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comptaPU");

        EntityManager em = emf.createEntityManager();

        System.out.println("Connexion à la base de données réussie !");

        em.close();
        emf.close();
    }
}