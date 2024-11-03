/*package com.example.demo.service;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
    @Autowired
    private HttpSession session;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

  /*  @Autowired
    private PasswordEncoder passwordEncoder;

 /*   public CandidatService(CandidatRepository candidatRepository, PasswordEncoder passwordEncoder) {
        this.candidatRepository = candidatRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CandidatService.java
    public Candidat getCandidatActuel(Long candidatId) {
        return (candidatId != null) ? candidatRepository.findById(candidatId).orElse(null) : null;
    }
*/


    // Ajoutez la méthode pour authentifier un candidat
 /*   public Candidat authentifier(String email, String password) {
        Optional<Candidat> candidat = candidatRepository.findByEmail(email);
        if (candidat.isPresent()) {
            boolean passwordMatch = passwordEncoder.matches(password, candidat.get().getPasseword());
            if (passwordMatch) {
                return candidat.get();
            }
            System.out.println("Mot de passe incorrect.");
        } else {
            System.out.println("Email non trouvé.");
        }
        return null;
    }*/





///////////////////Modification////////////////////////
  /*  public Candidat  registerCandidat(Candidat candidat) {
        // Vérifie que le mot de passe n'est pas nul
        if (candidat.getPasseword() == null || candidat.getPasseword().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être nul ou vide");
        }

        // Encodage du mot de passe
        String encodedPassword = passwordEncoder.encode(candidat.getPasseword());
        candidat.setPasseword(encodedPassword);

        // Enregistrement du candidat
        return  candidatRepository.save(candidat);
    } */

 /*   public Candidat inscrireCandidat(Long offreId, Candidat candidat) {
        OffreEmploi offre = offreEmploiRepository.findById(offreId)
                .orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));
        candidat.getOffres().add(offre);
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(Long candidatId, Candidat updatedCandidat) {
        Candidat existingCandidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new IllegalArgumentException("Candidat non trouvé"));
        existingCandidat.setNom(updatedCandidat.getNom());
        existingCandidat.setEmail(updatedCandidat.getEmail());
        existingCandidat.setCv(updatedCandidat.getCv());
        return candidatRepository.save(existingCandidat);
    }

    public void deleteCandidature(Long candidatId, Long offreId) {
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new IllegalArgumentException("Candidat non trouvé"));
        OffreEmploi offre = offreEmploiRepository.findById(offreId)
                .orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));
        candidat.getOffres().remove(offre);
        candidatRepository.save(candidat);
    }

    //////////////////zyada//////////////////
    public Candidat findById(Long id) {
        return candidatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Candidat not found"));
    }
    ////////////////////////////////////////////////

    public Optional<Candidat> getCandidatById(Long id) {
        return candidatRepository.findById(id);
    }

    // Méthode pour enregistrer un candidat lors de l'inscription
   public Candidat registerCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    // Méthode pour authentifier un candidat
    public Optional<Candidat> authenticateCandidat(String nom, String email) {
        return candidatRepository.findByNomAndEmail(nom, email);
    }

    // Méthode pour récupérer les offres disponibles (exemple de méthode)
    public List<OffreEmploi> getAvailableOffres() {
        // Remplacez cette ligne par la logique pour récupérer les offres disponibles
        return offreEmploiRepository.findAllByDateLimiteAfter(LocalDate.now());
    }*/
    // Dans CandidatService
 /*   @Autowired
    private CandidatureRepository candidatureRepository;

  /*  public void inscrireCandidat(Long offreId, Candidat candidat) {
        OffreEmploi offre = offreEmploiRepository.findById(offreId).orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));
        Candidature candidature = new Candidature(candidat, offre);
        candidatureRepository.save(candidature);
    }  */
 /* public void inscrireCandidat(Long offreId, Long candidatId) {
      OffreEmploi offre = offreEmploiRepository.findById(offreId)
              .orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));

      Candidat candidat = candidatRepository.findById(candidatId)
              .orElseThrow(() -> new IllegalArgumentException("Candidat non trouvé"));

      Candidature candidature = new Candidature(candidat, offre);
      candidatureRepository.save(candidature);
  } */
 /*  public void inscrireCandidat(Long offreId, Candidat candidat) {
       // Vérifier si le candidat existe déjà
       Optional<Candidat> existingCandidat = candidatRepository.findById(candidat.getId());
       Candidat finalCandidat;

       if (existingCandidat.isPresent()) {
           // Mettre à jour le CV du candidat si déjà existant
           Candidat foundCandidat = existingCandidat.get();
           foundCandidat.setCv(candidat.getCv()); // Met à jour le champ CV
           finalCandidat = candidatRepository.save(foundCandidat); // Enregistre les modifications
       } else {
           // Enregistre le candidat (logique d'inscription initiale)
           finalCandidat = candidatRepository.save(candidat);
       }

       // Récupérer l'offre d'emploi
       OffreEmploi offre = offreEmploiRepository.findById(offreId)
               .orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));

       // Ajouter le candidat à l'offre
       offre.getCandidats().add(finalCandidat);
       offreEmploiRepository.save(offre);
   }       */

/*
package com.example.demo.service;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    public void save(Candidat candidat) {
        candidatRepository.save(candidat);
    }

    public Optional <Candidat> findByEmailAndPassword(String email, String password) {
        return candidatRepository.findByEmailAndPassword(email, password);
    }


    // Méthode pour enregistrer un candidat lors de l'inscription
    public Candidat registerCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    // Méthode pour authentifier un candidat
    public Optional <Candidat> authenticateCandidat(String nom, String password) {
        return candidatRepository.findByEmailAndPassword(nom, password);
    }

    // Méthode pour récupérer les offres disponibles (exemple de méthode)
    public List<OffreEmploi> getAvailableOffres() {
        // Remplacez cette ligne par la logique pour récupérer les offres disponibles
        return offreEmploiRepository.findAllByDateLimiteAfter(LocalDate.now());
    }
}
*/