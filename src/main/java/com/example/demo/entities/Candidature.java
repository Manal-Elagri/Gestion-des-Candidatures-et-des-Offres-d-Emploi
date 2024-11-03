package com.example.demo.entities;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Candidature implements Serializable {

    @EmbeddedId
    private CandidaturePK id ;
    private String description ;
    @ManyToOne
    @MapsId("candidat")
    @JoinColumn( name ="candidat_id" ,referencedColumnName = "id",insertable =false , updatable =false)
    private Candidat  candidat;

    @ManyToOne
    @MapsId("offre_emploi")
    @JoinColumn( name ="offre_id" ,referencedColumnName = "id" ,insertable =false , updatable =false)
    private OffreEmploi offre;


    public Candidature() {
    }

    public Candidature(CandidaturePK id) {

        this.id = id;
    }

    public Candidature(CandidaturePK id, String description) {
        this.id = id;
        this.description = description;

    }

    public CandidaturePK getId() {
        return id;
    }

    public void setId(CandidaturePK id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Candidat getCandidat() {

        return candidat;
    }

    public void setCandidat(Candidat candidat) {

        this.candidat = candidat;
    }

    public OffreEmploi getOffre() {

        return offre;
    }

    public void setOffre(OffreEmploi offre) {

        this.offre = offre;
    }
}
