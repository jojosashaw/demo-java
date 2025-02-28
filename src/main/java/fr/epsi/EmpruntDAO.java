package fr.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class EmpruntDAO {
    private EntityManagerFactory emf;

    public EmpruntDAO() {
        this.emf = Persistence.createEntityManagerFactory("comptaPU");
    }

    public Emprunt findById(int id) {
        EntityManager em = emf.createEntityManager();
        Emprunt emprunt = em.find(Emprunt.class, id);

        if (emprunt != null) {
            System.out.println("Emprunt ID: " + emprunt.getId());
            System.out.println("Livres empruntés :");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println("- " + livre.getTitre() + " de " + livre.getAuteur());
            }
        } else {
            System.out.println("Aucun emprunt trouvé avec cet ID.");
        }

        em.close();
        return emprunt;
    }
}
