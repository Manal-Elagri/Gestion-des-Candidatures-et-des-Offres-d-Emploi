/*package com.example.demo.service;

import com.example.demo.entities.Candidat;
import com.example.demo.entities.Candidature;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.CandidatureRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    public void saveCandidature(Candidature candidature) {
        candidatureRepository.save(candidature);
    }

    public List<OffreEmploi> getAvailableOffers() {
        return offreEmploiRepository.findByDateLimiteAfter(LocalDate.now());
    }

    public Candidat getCandidatByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }

    // D'autres méthodes peuvent être ajoutées selon les besoins
}*/
