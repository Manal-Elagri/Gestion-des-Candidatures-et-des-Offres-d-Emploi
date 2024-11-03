package com.example.demo.controller;
import com.example.demo.entities.Candidat;
import com.example.demo.entities.Candidature;
import com.example.demo.entities.OffreEmploi;
import com.example.demo.repositories.CandidatRepository;
import com.example.demo.repositories.OffreEmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CandidatController {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;


    // Affiche le formulaire d'inscription
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("candidat", new Candidat());
        return "add-user";
    }

    // Ajoute un nouvel utilisateur
    @PostMapping("/adduser")
    public String addUser(@Valid Candidat candidat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        candidatRepository.save(candidat);
       // model.addAttribute("candidat", candidatRepository.findAll());
        return "index";
    }

    // Ajoute un nouvel utilisateur
    @GetMapping("/listuser")
    public String listUser( Model model) {
        List<Candidat> candidats = candidatRepository.findAll();
        model.addAttribute("candidats", candidats);
      //  model.addAttribute("candidat", candidatRepository.findAll());
        return "list-user";
    }


    @GetMapping("/offres-disponibles")
    public String showAvailableOffers(Model model) {
        List<OffreEmploi> offres = offreEmploiRepository.findAllByDateLimiteAfter(LocalDate.now());
       // System.out.println("Nombre d'offres trouvées : " + offres.size());
        model.addAttribute("offres", offres);
        return "offres-disponibles";
    }

    /***************************          Partie Connection                  ******************************/

    // Page de connexion ou d'inscription
    @GetMapping("/connect")
    public String connexionPage(Model model) {
        model.addAttribute("candidat", new Candidat());
        return "connexion";
    }

    // Gestion de la connexion
    @PostMapping("/connexion")
    public String loginCandidat(@ModelAttribute("candidat") Candidat authCandidat, Model model) {
        // Vous devez implémenter la méthode authenticateCandidat dans CandidatService
        Optional<Candidat> candidatOpt = candidatRepository.findByEmailAndPassword(authCandidat.getEmail(), authCandidat.getPassword());

        if (candidatOpt.isPresent()) {
            // Authentification réussie, redirection vers les offres disponibles
            return "redirect:/offres-disponibles";
        } else {
            model.addAttribute("error", "Identifiants incorrects !");
            return "connexion";
        }
    }


    /********           Fin Partie Connexion          ********/

    // Affiche le formulaire de mise à jour
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("candidat", candidat);
        return "update-user";
    }

    // Met à jour l'utilisateur
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Candidat candidat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            candidat.setId(id);
            return "update-user";
        }
        candidatRepository.save(candidat);
        model.addAttribute("candidats", candidatRepository.findAll());
        return "list-user";
    }

    // Supprime un utilisateur
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        candidatRepository.delete(candidat);
        model.addAttribute("candidats", candidatRepository.findAll());
        return "list-user";
    }



    // ajouter un utilisateur
    @GetMapping("/add-user")
    public String showAddUserForm(Model model) {
        model.addAttribute("candidat", new Candidat());
        return "add-user";
    }







 /*   @Autowired
    private CandidatureService candidatureService;
    @Autowired
    private CandidatService candidatService;

    @Autowired
    private OffreEmploiService offreService; // Service pour obtenir les détails de l'offre



    /******************************************************************/
/*    private static final Logger logger = LoggerFactory.getLogger(CandidatController.class);

    // Page de connexion ou d'inscription
    @GetMapping("/connexion")
    public String connexionPage(Model model) {
        logger.info("Affichage de la page de connexion");
        model.addAttribute("candidat", new Candidat());
        return "candidats/connexion";
    }

    // Gestion de la connexion
    @PostMapping("/connexion")
    public String loginCandidat(@ModelAttribute("authCandidat") Candidat authCandidat, Model model) {
        Optional<Candidat>  candidatOpt = candidatService.authenticateCandidat(authCandidat.getEmail(), authCandidat.getPassword());

        if (candidatOpt.isPresent()) {
            // Authentification réussie, redirection vers les offres disponibles
            return "redirect:/offres-disponibles";
        } else {
            // En cas d'échec
            return "redirect:/connexion?error=true";
        }

    }

    // Page d'inscription
    @PostMapping("/register")
    public String registerCandidat(Candidat candidat) {
        candidatService.save(candidat); // Méthode à implémenter dans CandidatService
        return "redirect:/offres-disponibles";
    }


    // Afficher les offres disponibles
    @GetMapping("/offres-disponibles")
    public String offresDisponibles(Model model) {
        model.addAttribute("offres", candidatService.getAvailableOffres()); // Méthode à implémenter pour récupérer les offres disponibles
        return "candidats/offres-disponibles"; // Assurez-vous que ce fichier existe dans templates/candidats
    }

    ///////////////////////////////////////////    Parie de l'inscription        /////////////////////////////////////////////////
 /*   @GetMapping("/inscription")
    public String showRegistrationForm(Model model) {
        model.addAttribute("candidat", new Candidat());
         return "candidats/inscription";
    }

    @PostMapping("/inscription")
    public String registerCandidat(@ModelAttribute("newCandidat") Candidat candidat) {
        candidatService.save(candidat);
       // model.addAttribute("message", "Inscription réussie !");
        return "candidats/connexion"; // Rediriger vers la page de connexion
    }*/

    /////////////////////////////  Partie de Connexion   ////////////////////////////////////
/*

    @GetMapping("/connexion")
    public String showLoginForm(Model model) {
        return "candidats/connexion"; // Afficher la page de connexion
    }

    @PostMapping("/connexion")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Candidat candidat = candidatService.findByEmailAndPassword(email, password);
        if (candidat != null) {
            session.setAttribute("candidatId", candidat.getId());
            return "redirect:/offres-disponibles"; // Rediriger vers les offres disponibles
        } else {
            model.addAttribute("error", "Identifiants incorrects !");
            return "candidats/connexion"; // Renvoyer à la page de connexion
        }
    }*/
/*

    @GetMapping("/candidats/{candidatId}/inscrire")
    public String showInscriptionForm(@PathVariable Long candidatId, @RequestParam Long offreId, Model model) {
        model.addAttribute("candidatId", candidatId);
        model.addAttribute("offreId", offreId);
        return "candidats/inscription-candidature"; // Page pour confirmer l'inscription
    }

    @PostMapping("/candidats/{candidatId}/inscrire")
    public String inscrireCandidat(@PathVariable Long candidatId, @RequestParam Long offreId) {
        CandidaturePK candidaturePK = new CandidaturePK(candidatId, offreId);
        Candidature candidature = new Candidature(candidaturePK);
        candidatureService.saveCandidature(candidature);
        return "redirect:/offres-disponibles"; // Rediriger vers la page des offres disponibles
    }
*/

}
