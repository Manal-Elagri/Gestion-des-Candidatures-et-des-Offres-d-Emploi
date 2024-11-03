package com.example.demo.service;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> authenticate(String nom, String email) {
        return adminRepository.findByNomAndEmail(nom, email); // Méthode à créer dans le repository
    }
}
