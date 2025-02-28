package fr.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LivreDAO {
    private EntityManagerFactory emf;

    public LivreDAO() {
        this.emf = Persistence.createEntityManagerFactory("comptaPU");
    }

    public Livre findById(int id) {
        EntityManager em = emf.createEntityManager();
        Livre livre = em.find(Livre.class, id);
        em.close();

        if (livre != null) {
            System.out.println("Livre trouvé : ID = " + livre.getId() +
                    ", Titre = " + livre.getTitre() +
                    ", Auteur = " + livre.getAuteur());
        }

        return livre;
    }
}
