package com.example.demo.service;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OffreEmploiService {

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    public List<OffreEmploi> getAllOffres() {
        return offreEmploiRepository.findAll();
    }

    public Optional<OffreEmploi> getOffreById(Long id) {
        return offreEmploiRepository.findById(id);
    }

    public List<OffreEmploi> getAvailableOffres() {
        return offreEmploiRepository.findAll().stream().filter(OffreEmploi::isAvailable).collect(Collectors.toList());
    }

    //////////////////////zyada/////////////////////
    public OffreEmploi findById(Long id) {
        return offreEmploiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Offre not found"));
    }
    /////////////////////////////////////

    public List<OffreEmploi> getNonAvailableOffres() {
        return offreEmploiRepository.findAll().stream().filter(offre -> !offre.isAvailable()).collect(Collectors.toList());
    }

    public OffreEmploi saveOrUpdateOffre(OffreEmploi offre) {

        return offreEmploiRepository.save(offre);
    }

    public void deleteOffre(Long id) {
        offreEmploiRepository.deleteById(id);
    }

    @Autowired
    private CandidatRepository candidatRepository;

   // @Autowired
  //  private CandidatureRepository candidatureRepository;

   /* public void inscrireCandidat(Long offreId, Candidat candidat) {
        // Vérifier si le candidat existe déjà par email (ou par ID selon votre logique)
        Optional<Candidat> existingCandidat = candidatRepository.findById(candidat.getId());
        Candidat savedCandidat;

        if (existingCandidat.isPresent()) {
            // Si le candidat existe déjà, mettre à jour son CV
            savedCandidat = existingCandidat.get();
            savedCandidat.setCv(candidat.getCv());
            candidatRepository.save(savedCandidat); // Enregistrez les modifications
        } else {
            // Si le candidat n'existe pas, enregistrez-le
            savedCandidat = candidatRepository.save(candidat);
        }

        // Récupérer l'offre d'emploi
        OffreEmploi offre = offreEmploiRepository.findById(offreId)
                .orElseThrow(() -> new IllegalArgumentException("Offre non trouvée"));

        // Vérifier si le candidat a déjà postulé à l'offre
        if (!offre.getCandidats().contains(savedCandidat)) {
            // Ajouter le candidat à l'offre
            offre.getCandidats().add(savedCandidat);
            offreEmploiRepository.save(offre); // Enregistrez les modifications de l'offre
        }

        // Créer la candidature (optionnel si vous n'utilisez pas une table de jointure séparée)
        Candidature candidature = new Candidature(savedCandidat, offre);
        candidatureRepository.save(candidature); // Enregistrez la candidature
    }*/


}
