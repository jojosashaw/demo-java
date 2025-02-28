package fr.epsi;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_DEBUT", nullable = false)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_FIN")
    private Date dateFin;

    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV")
    )
    private List<Livre> livres;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public int getDelai() { return delai; }
    public void setDelai(int delai) { this.delai = delai; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Livre> getLivres() { return livres; }
    public void setLivres(List<Livre> livres) { this.livres = livres; }
}
