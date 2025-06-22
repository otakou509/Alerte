/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securite.alerte.controller;

import com.securite.alerte.model.Compte;
import com.securite.alerte.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String afficherAccueilParDefaut() {
        return "redirect:/inscription";
    }

    @GetMapping("/inscription")
    public String afficherFormulaireInscription(Model model) {
        model.addAttribute("compte", new Compte());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String enregistrerCompte(@ModelAttribute("compte") Compte compte, Model model) {
        Optional<Compte> compteExistant = compteRepository.findByEmail(compte.getEmail());

        if (compteExistant.isPresent()) {
            model.addAttribute("erreur", "Cet email est déjà utilisé.");
            return "inscription";
        }

        compte.setMotDePasse(passwordEncoder.encode(compte.getMotDePasse()));
        compteRepository.save(compte);
        return "redirect:/home";
    }

   
}
