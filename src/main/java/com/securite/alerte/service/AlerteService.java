/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securite.alerte.service;

import com.securite.alerte.model.Alerte;
import com.securite.alerte.repository.AlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlerteService {

    @Autowired
    private AlerteRepository alerteRepository;

    public Alerte envoyerAlerte(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    public List<Alerte> recupererToutesLesAlertes() {
        return alerteRepository.findAll();
    }

    public Optional<Alerte> recupererAlerteParId(Long id) {
        return alerteRepository.findById(id);
    }

    public List<Alerte> recupererAlertesParCompte(Long compteId) {
        return alerteRepository.findByCompteId(compteId);
    }

    public void supprimerAlerte(Long id) {
        alerteRepository.deleteById(id);
    }
}
