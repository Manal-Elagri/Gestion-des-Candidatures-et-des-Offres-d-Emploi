package com.example.demo.controller;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Candidature;
import com.example.demo.entities.CandidaturePK;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatureRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.OffreEmploiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller

public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private OffreEmploiService offreEmploiService;

    @Autowired
    private CandidatureRepository candidatureRepository;

    @GetMapping("/logine")
    public String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/login";
    }

    @RequestMapping("/login")
    public String authenticate(@ModelAttribute Admin admin, Model model, HttpSession session) {
        Optional<Admin> authenticatedAdmin = adminService.authenticate(admin.getNom(), admin.getEmail());
        if (authenticatedAdmin.isPresent()) {
            session.setAttribute("admin", authenticatedAdmin.get());
            return "redirect:/home";
        }
        model.addAttribute("error", "Nom ou email incorrect");
        return "admin/login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "admin/home"; // Page d'accueil après connexion
    }




    @GetMapping("/offres")
    public String adminOffres(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/login";
        }
        model.addAttribute("offres", offreEmploiService.getAllOffres());
        return "admin/offres";
    }

    @GetMapping("/offres/create")
    public String createOffreForm(Model model) {
        model.addAttribute("offre", new OffreEmploi());
        return "admin/create";
    }
   /*------------------Modufication----------------------*/

   @PostMapping("/offres/save")
    public String saveOffre(@ModelAttribute OffreEmploi offre, Model model) {
        offreEmploiService.saveOrUpdateOffre(offre);
        model.addAttribute("offres", offreEmploiService.getAllOffres());
        return "admin/offres";
    }

    /***********************      Methode pour afficher les candidature associer à chaque offre       ***************************/

    @GetMapping("/offres/candidatures/{id}")
    public String listCandidaturesByOffre(@PathVariable Long id, Model model) {
        OffreEmploi offre = offreEmploiService.getOffreById(id).orElse(null);
        if (offre == null) {
            model.addAttribute("error", "Offre non trouvée");
            return "admin/offres"; // Retourner à la liste des offres en cas d'erreur
        }

        List<Candidature> candidatures = candidatureRepository.findByOffreId(id);
        model.addAttribute("offre", offre);
        model.addAttribute("candidatures", candidatures);
        return "admin/candidaturesoffres"; // Nom du fichier HTML à créer pour afficher les candidatures
    }

     /************************    Supprimer les Condidature           ***************************/

     @GetMapping("/deletecandudatureoffre")
     public String deleteCandidature(@RequestParam Long candidatId, @RequestParam Long offreId, @RequestParam String dateinscription, RedirectAttributes redirectAttributes) {
         CandidaturePK id = new CandidaturePK(candidatId, offreId, dateinscription); // Incluez la date d'inscription si elle est nécessaire
         if (candidatureRepository.existsById(id)) {
             candidatureRepository.deleteById(id);
             redirectAttributes.addFlashAttribute("message", "Candidature supprimée avec succès.");
         } else {
             redirectAttributes.addFlashAttribute("error", "Candidature non trouvée.");
         }
         return "redirect:/offres/candidatures/" + offreId; // Redirection vers la liste des candidatures du candidat
     }


    /******************************************/
    @GetMapping("/offres/edit/{id}")
    public String editOffreForm(@PathVariable Long id, Model model) {
        OffreEmploi offre = offreEmploiService.getOffreById(id).orElse(null);
        model.addAttribute("offre", offre);
        return "admin/edit";
    }

    @PostMapping("/offres/update")
    public String updateOffre(@ModelAttribute OffreEmploi offre, Model model) {
        offreEmploiService.saveOrUpdateOffre(offre);
        model.addAttribute("offres", offreEmploiService.getAllOffres());

        return "admin/offres";
    }

    @GetMapping("/offres/delete/{id}")
    public String deleteOffre(@PathVariable Long id, Model model) {
        offreEmploiService.deleteOffre(id);
        model.addAttribute("offres", offreEmploiService.getAllOffres());
        return "admin/offres";
    }
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login"; // Modifiez le chemin ici
    }
   /* @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/admin/login";
    }       */

}
