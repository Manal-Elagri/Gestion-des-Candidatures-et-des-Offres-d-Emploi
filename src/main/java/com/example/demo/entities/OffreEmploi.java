package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
@Entity
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Titre is mandatory")
    private String titre;

    @NotBlank(message = "Description is mandatory")
    private String description;
    private LocalDate dateLimite;
    @Transient
    public boolean isAvailable() {
        return LocalDate.now().isBefore(dateLimite);
    }

    @OneToMany(mappedBy = "offre",fetch = FetchType.EAGER)
    private List<Candidature> candidatures;

    public OffreEmploi() {
    }

    public OffreEmploi(Long id, String titre, String description, LocalDate dateLimite) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateLimite = dateLimite;
    }

    public OffreEmploi(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Titre is mandatory") String getTitre() {
        return titre;
    }

    public void setTitre(@NotBlank(message = "Titre is mandatory") String titre) {
        this.titre = titre;
    }

    public @NotBlank(message = "Description is mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is mandatory") String description) {
        this.description = description;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }
}
