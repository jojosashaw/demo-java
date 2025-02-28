package fr.epsi;

public class Main {
    public static void main(String[] args) {
        LivreDAO livreDAO = new LivreDAO();

        Livre livre = livreDAO.findById(1);
        if (livre != null) {
            System.out.println("Livre trouvé : ID = " + livre.getId());
        } else {
            System.out.println("Aucun livre trouvé !");
        }
    }
}
