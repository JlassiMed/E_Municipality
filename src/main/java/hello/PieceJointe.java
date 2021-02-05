package hello;

import javax.persistence.*;
import java.util.Arrays;
@Entity
public class PieceJointe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_pj;
    private String type_pj;
    private byte[] fichier_pj;


    @ManyToOne
    @JoinColumn(name="code_rec")
    private Reclamation reclamation;

    public PieceJointe() {
    }

    public PieceJointe(String type_pj, byte[] fichier_pj, Reclamation reclamation) {
        this.type_pj = type_pj;
        this.fichier_pj = fichier_pj;
        this.reclamation = reclamation;
    }

    @Override
    public String toString() {
        return "PieceJointe{" +
                "id_pj=" + id_pj +
                ", type_pj='" + type_pj + '\'' +
                ", fichier_pj=" + Arrays.toString(fichier_pj) +
                ", reclamation=" + reclamation +
                '}';
    }

    public Long getId_pj() {
        return id_pj;
    }

    public void setId_pj(Long id_pj) {
        this.id_pj = id_pj;
    }

    public String getType_pj() {
        return type_pj;
    }

    public void setType_pj(String type_pj) {
        this.type_pj = type_pj;
    }

    public byte[] getFichier_pj() {
        return fichier_pj;
    }

    public void setFichier_pj(byte[] fichier_pj) {
        this.fichier_pj = fichier_pj;
    }

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }
}
