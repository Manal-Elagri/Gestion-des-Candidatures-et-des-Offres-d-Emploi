package com.example.demo.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidaturePK implements Serializable {

    private Long candidat;

    private  Long offre_emploi;

    private String dateinscription;

    public CandidaturePK() {}

    public CandidaturePK(Long candidat,Long offre_emploi,String dateinscription) {
        this.offre_emploi = offre_emploi;
        this.candidat = candidat;
        this.dateinscription = dateinscription;

    }

    public CandidaturePK(Long candidat, Long offre_emploi) {
        this.candidat = candidat;
        this.offre_emploi = offre_emploi;
    }

    public Long getCandidat() {
        return candidat;
    }

    public void setCandidat(Long candidat) {
        this.candidat = candidat;
    }

    public Long getOffre_emploi() {
        return offre_emploi;
    }

    public void setOffre_emploi(Long offre_emploi) {
        this.offre_emploi = offre_emploi;
    }

    public String getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(String dateinscription) {
        this.dateinscription = dateinscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidaturePK)) return false;
        CandidaturePK that = (CandidaturePK) o;
        return Objects.equals(candidat, that.candidat) &&
                Objects.equals(offre_emploi, that.offre_emploi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidat, offre_emploi);
    }



}
