package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nom is mandatory")
    private String nom;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "CV is mandatory")
    private String cv;

    @NotBlank(message = "Password is mandatory")
    private String password; // Supposons que le CV soit stocké sous forme de texte

    @OneToMany(mappedBy = "candidat",fetch = FetchType.EAGER)
    private List<Candidature> candidatures;

    public Candidat() {
    }


    public Candidat(Long id) {
        this.id = id;
    }

    public Candidat(Long id, String nom, String email, String cv, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.cv = cv;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getNom() {
        return nom;
    }

    public void setNom( String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public  String getCv() {
        return cv;
    }

    public void setCv( String cv) {
        this.cv = cv;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }
}
