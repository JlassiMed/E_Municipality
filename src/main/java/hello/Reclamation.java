package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.websocket.Decoder;
import java.util.List;

@Entity
@Table(name = "Reclamation")
public class Reclamation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long code_rec;
    private String details;
    private String titre;
    private String typeFichier;
    private byte[] piece_jointe;
    @JsonIgnore
    @OneToMany(mappedBy = "reclamation")
    private List<PieceJointe> pieceJointes;


    @ManyToOne
    @JoinColumn(name="code_cit")
    private Citoyen citoyen;

    public byte[] getPiece_jointe() {
        return piece_jointe;
    }

    public void setPiece_jointe(byte[] piece_jointe) {
        this.piece_jointe = piece_jointe;
    }

    public String getTypeFichier() {
        return typeFichier;
    }

    public void setTypeFichier(String typeFichier) {
        this.typeFichier = typeFichier;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getCode_rec() {
        return code_rec;
    }

    public void setCode_rec(Long code_rec) {
        this.code_rec = code_rec;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }
}
