package com.example.demo.repositories;
import com.example.demo.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
   //Candidat findByEmail(String email);
   //Optional<Candidat> findByEmailAndPassword(String email, String password);
   Optional<Candidat> findByEmailAndPassword(String email, String password);

}
