package com.example.demo.repositories;
import com.example.demo.entities.Candidature;
import com.example.demo.entities.CandidaturePK;
import com.example.demo.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatureRepository extends JpaRepository<Candidature, CandidaturePK> {

    @Query("SELECT c FROM Candidature c WHERE c.id.candidat = :candidatId")
    List<Candidature> findByCandidatId(@Param("candidatId") Long candidatId);
   // List<Candidature> findByOffreId(Long offreId);
   // public List<Candidature> findByOffre(OffreEmploi offre);
    //List<Candidature> findByCandidatId(Long candidatId);


    @Query("SELECT c FROM Candidature c WHERE c.offre.id = :offreId")
    List<Candidature> findByOffreId(@Param("offreId") Long offreId);



}

