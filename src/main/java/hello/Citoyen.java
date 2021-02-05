package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Citoyen")
public class Citoyen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code_cit;
    @Column(unique = true)
    private String login_cit;

    private String password_cit;
    private String nom_cit;
    private String prenom_cit;
    private String photo_cit;
    private String date_naiss;
    private String fonction_cit;
    private String adresse_cit;
    @JsonIgnore
    @OneToMany(mappedBy = "citoyen")
    private List<Reclamation> reclamations;
    @JsonIgnore
    @OneToMany(mappedBy = "citoyen")
    private List<Certificat> certificats;

    public List<Certificat> getCertificats() {
        return certificats;
    }

    public void setCertificats(List<Certificat> certificats) {
        this.certificats = certificats;
    }

    public Citoyen() {
    }

    public Citoyen(String login_cit, String password_cit, String nom_cit, String prenom_cit, String photo_cit, String date_naiss, String fonction_cit, String adresse_cit) {
        this.login_cit = login_cit;
        this.password_cit = password_cit;
        this.nom_cit = nom_cit;
        this.prenom_cit = prenom_cit;
        this.photo_cit = photo_cit;
        this.date_naiss = date_naiss;
        this.fonction_cit = fonction_cit;
        this.adresse_cit = adresse_cit;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public Long getCode_cit() {
        return code_cit;
    }

    public void setCode_cit(Long code_cit) {
        this.code_cit = code_cit;
    }

    public String getLogin_cit() {
        return login_cit;
    }

    public void setLogin_cit(String login_cit) {
        this.login_cit = login_cit;
    }

    public String getPassword_cit() {
        return password_cit;
    }

    public void setPassword_cit(String password_cit) {
        this.password_cit = password_cit;
    }

    public String getNom_cit() {
        return nom_cit;
    }

    public void setNom_cit(String nom_cit) {
        this.nom_cit = nom_cit;
    }

    public String getPrenom_cit() {
        return prenom_cit;
    }

    public void setPrenom_cit(String prenom_cit) {
        this.prenom_cit = prenom_cit;
    }

    public String getPhoto_cit() {
        return photo_cit;
    }

    public void setPhoto_cit(String photo_cit) {
        this.photo_cit = photo_cit;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getFonction_cit() {
        return fonction_cit;
    }

    public void setFonction_cit(String fonction_cit) {
        this.fonction_cit = fonction_cit;
    }

    public String getAdresse_cit() {
        return adresse_cit;
    }

    public void setAdresse_cit(String adresse_cit) {
        this.adresse_cit = adresse_cit;
    }
}