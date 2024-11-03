/*package com.example.demo.service;
import com.example.demo.entities.Candidat;
import com.example.demo.repositories.CandidatRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;

@Service
public class CandidatDetailsService implements UserDetailsService {

    private final CandidatRepository candidatRepository;

    public CandidatDetailsService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Candidat> candidat = candidatRepository.findByEmail(email);
        if (candidat.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        return new org.springframework.security.core.userdetails.User(
                candidat.get().getEmail(),
                candidat.get().getPasseword(),
                new ArrayList<>()  // ici, vous pouvez ajouter des rôles ou des autorisations si nécessaire
        );
    }
}
*/