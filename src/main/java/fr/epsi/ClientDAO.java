package fr.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClientDAO {
    private EntityManagerFactory emf;

    public ClientDAO() {
        this.emf = Persistence.createEntityManagerFactory("comptaPU");
    }

    public Client findByIdWithEmprunts(int id) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Client> query = em.createQuery(
                "SELECT c FROM Client c LEFT JOIN FETCH c.emprunts WHERE c.id = :id", Client.class
        );
        query.setParameter("id", id);

        Client client = null;
        try {
            client = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Aucun client trouvé avec l'ID " + id);
        }

        em.close();
        return client;
    }

}
