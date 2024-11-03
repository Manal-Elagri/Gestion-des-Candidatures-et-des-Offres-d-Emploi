package com.example.demo.controller;

import com.example.demo.service.OffreEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class OffreEmploiController {

/*
    @Autowired
    private OffreEmploiService offreEmploiService;

    @GetMapping
    public String listOffres(Model model) {
        model.addAttribute("offres", offreEmploiService.getAllOffres());
        return "offres/list";
    }

    @GetMapping("/available")
    public String listAvailableOffres(Model model) {
        model.addAttribute("offres", offreEmploiService.getAvailableOffres());
        return "offres/list";
    }

    @GetMapping("/non-available")
    public String listNonAvailableOffres(Model model) {
        model.addAttribute("offres", offreEmploiService.getNonAvailableOffres());
        return "offres/list";
    }
*/


}
