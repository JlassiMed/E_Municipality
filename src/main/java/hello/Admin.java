package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_admin;

    private String login_admin;

    private String password_admin;
    private String nom_admin;
    private String prenom_admin;
    private String photo;

    @OneToMany(mappedBy = "admin")
    private Collection<Actualite> actualites;
    public Admin ()
    {}
    public Admin(String login_admin, String password_admin, String nom_admin, String prenom_admin, String photo) {
        this.login_admin = login_admin;
        this.password_admin = password_admin;
        this.nom_admin = nom_admin;
        this.prenom_admin = prenom_admin;
        this.photo = photo;
    }

    public void setIdadmin(Long id) {
        this.id_admin = id;
    }

    public Long getIdadmin() {
        return id_admin;
    }


    public String getLogin_admin() {
        return login_admin;
    }

    public void setLogin_admin(String login_admin) {
        this.login_admin = login_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
    }

    public String getPrenom_admin() {
        return prenom_admin;
    }

    public void setPrenom_admin(String prenom_admin) {
        this.prenom_admin = prenom_admin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
