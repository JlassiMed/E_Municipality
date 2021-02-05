package hello;

import javax.persistence.*;
@Entity
public class Certificat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_certif;
    private String type_Certif;
    private String pdf_certif;

    @ManyToOne
    @JoinColumn(name="code_cit")
    private Citoyen citoyen;

    public Certificat() {
    }

    public Certificat(String type_Certif, String pdf_certif, Citoyen citoyen) {
        this.type_Certif = type_Certif;
        this.pdf_certif = pdf_certif;
        this.citoyen = citoyen;
    }

    public Long getId_certif() {
        return id_certif;
    }

    public void setId_certif(Long id_certif) {
        this.id_certif = id_certif;
    }

    public String getType_Certif() {
        return type_Certif;
    }

    public void setType_Certif(String type_Certif) {
        this.type_Certif = type_Certif;
    }

    public String getPdf_certif() {
        return pdf_certif;
    }

    public void setPdf_certif(String pdf_certif) {
        this.pdf_certif = pdf_certif;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }

    @Override
    public String toString() {
        return "Certificat{" +
                "id_certif=" + id_certif +
                ", type_Certif='" + type_Certif + '\'' +
                ", pdf_certif='" + pdf_certif + '\'' +
                ", citoyen=" + citoyen +
                '}';
    }
}
