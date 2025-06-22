/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securite.alerte.controller;

import com.securite.alerte.model.Alerte;
import com.securite.alerte.model.Compte;
import com.securite.alerte.repository.AlerteRepository;
import com.securite.alerte.repository.CompteRepository;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlerteController {

    @Autowired
    private AlerteRepository alerteRepository;

    @Autowired
    private CompteRepository compteRepository;

   @PostMapping("/alerte")
public String enregistrerAlerte(@ModelAttribute Alerte alerte, Principal principal) {
    String email = principal.getName();
    Optional<Compte> optionalCompte = compteRepository.findByEmail(email);

    if (optionalCompte.isPresent()) {
        Compte compte = optionalCompte.get();
        alerte.setCompte(compte);
        alerteRepository.save(alerte);
        return "redirect:/home"; // redirection après enregistrement
    } else {
        // Gérer le cas où l’utilisateur n’est pas trouvé (optionnel)
        return "redirect:/login?error"; // ou une autre page d’erreur
    }
}
@GetMapping("/alerte")
public String afficherFormulaireAlerte(Model model, Principal principal) {
    Compte compte = compteRepository.findByEmail(principal.getName()).orElse(null);
    model.addAttribute("nomUtilisateur", compte != null ? compte.getNom() : "utilisateur");
    model.addAttribute("alerte", new Alerte());
    return "home";
}



}
