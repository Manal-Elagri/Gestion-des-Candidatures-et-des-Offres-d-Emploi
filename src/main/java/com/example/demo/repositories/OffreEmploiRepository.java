package com.example.demo.repositories;
import com.example.demo.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface OffreEmploiRepository  extends JpaRepository<OffreEmploi, Long> {
   // List<OffreEmploi> findByDateLimiteAfter(LocalDate date);
    //List<OffreEmploi> findAllByDateLimiteAfter(LocalDate date);
    List<OffreEmploi> findAllByDateLimiteAfter(LocalDate dateLimite);

}
