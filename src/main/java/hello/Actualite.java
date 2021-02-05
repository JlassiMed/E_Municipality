package hello;

import javax.persistence.*;

@Entity
@Table(name ="Actualite" )
public class Actualite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String titre;
    private String contenu;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    public Actualite() {
    }

    public Actualite(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
