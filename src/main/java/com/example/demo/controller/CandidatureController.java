package com.example.demo.controller;
import com.example.demo.entities.Candidature;
import com.example.demo.entities.CandidaturePK;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatureRepository;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CandidatureController {

    @Autowired
    private CandidatureRepository candidatureRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    @GetMapping("/add")
    public String showAddCandidatureForm(Model model) {
        model.addAttribute("candidature", new Candidature());
        model.addAttribute("candidats", candidatRepository.findAll());
      //  model.addAttribute("offres", offreEmploiRepository.findAll());
        List<OffreEmploi> offres = offreEmploiRepository.findAllByDateLimiteAfter(LocalDate.now());
        model.addAttribute("offres", offres);
        return "candidatures/add-candidature";
    }

    @PostMapping("/save")
    public String saveCandidature(@ModelAttribute Candidature candidature,
                                  @RequestParam("dateinscription") String dateinscription,
                                  @RequestParam("candidatId") Long candidatId,
                                  @RequestParam("offreId") Long offreId) {
        // Création  une instance de la clé composite
        CandidaturePK candidaturePK = new CandidaturePK(candidatId, offreId, dateinscription);
        candidature.setId(candidaturePK);

        // Associe les objets `Candidat` et `OffreEmploi` à la candidature
        candidature.setCandidat(candidatRepository.findById(candidatId).orElse(null));
        candidature.setOffre(offreEmploiRepository.findById(offreId).orElse(null));

        candidatureRepository.save(candidature);
        return "redirect:/candidatures/" + candidatId;
    }


    /*******************       Liste des candidatures d'un Candidat           *******************/

     @GetMapping("/candidatures/{candidatId}")
      public String listCandidaturesByCandidat(@PathVariable Long candidatId, Model model) {
       List<Candidature> candidatures = candidatureRepository.findByCandidatId(candidatId);
        model.addAttribute("candidatures", candidatures);
      return "candidatures/list-candidatures-by-candidat";
     }

                 /**************    Fin methode         ************/

                 // Affiche la liste des candidatures
                 @GetMapping("/listcandidatures")
                 public String listCandidatures(Model model) {
                 List<Candidature> candidatures = candidatureRepository.findAll();
                 model.addAttribute("candidatures", candidatures);
                 return "candidatures/list";
                 }

    /* // Supprime une candidature par identifiant composite
    @GetMapping("/delete")
    public String deleteCandidature(@RequestParam Long candidatId, @RequestParam Long offreId) {
        CandidaturePK id = new CandidaturePK(candidatId, offreId);
        candidatureRepository.deleteById(id);
        return "redirect:/list";
    }*/
/*
    @GetMapping("/delete")
    public String deleteCandidature(@RequestParam Long candidatId, @RequestParam Long offreId, Model model) {
        CandidaturePK id = new CandidaturePK(candidatId, offreId);
        if (candidatureRepository.existsById(id)) { // Vérifiez si l'identifiant existe
            candidatureRepository.deleteById(id);
        }
        model.addAttribute("candidatures", candidatureRepository.findAll());
        return "redirect:/list-candidatures-by-candidat";
    }*/
   @GetMapping("/deletecandudature")
   public String deleteCandidature(@RequestParam Long candidatId, @RequestParam Long offreId, @RequestParam String dateinscription, RedirectAttributes redirectAttributes) {
       CandidaturePK id = new CandidaturePK(candidatId, offreId, dateinscription); // Incluez la date d'inscription si elle est nécessaire
       if (candidatureRepository.existsById(id)) {
           candidatureRepository.deleteById(id);
           redirectAttributes.addFlashAttribute("message", "Candidature supprimée avec succès.");
       } else {
           redirectAttributes.addFlashAttribute("error", "Candidature non trouvée.");
       }
       return "redirect:/candidatures/" + candidatId;
   }

                           /*****************   Methode pour afficher les candidature selon une offres    ******************/
                     /*      @GetMapping("/offre/{offreId}/candidatures")
                           public String listCandidaturesByOffre(@PathVariable Long offreId, Model model) {
                               List<Candidature> candidatures = candidatureRepository.findByOffreId(offreId);
                               model.addAttribute("candidatures", candidatures);
                               model.addAttribute("offreId", offreId);
                               return "candidatures/list-candidatures-by-offre";
                           }*/



                           @GetMapping("/deletecandudatureadmin")
                           public String deleteCandidatures(@RequestParam Long candidatId, @RequestParam Long offreId, @RequestParam String dateinscription, RedirectAttributes redirectAttributes) {
                               CandidaturePK id = new CandidaturePK(candidatId, offreId, dateinscription);
                               if (candidatureRepository.existsById(id)) {
                                   candidatureRepository.deleteById(id);
                                   redirectAttributes.addFlashAttribute("message", "Candidature supprimée avec succès.");
                               } else {
                                   redirectAttributes.addFlashAttribute("error", "Candidature non trouvée.");
                               }
                               return "/candidatures/list" ;
                           }


}
