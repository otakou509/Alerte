/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securite.alerte.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alerte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;      // Ex: vols, activité illégale, agression, etc.
    private String adresse;   // Lieu de l’incident
    private LocalDateTime dateHeure;

    @ManyToOne
    @JoinColumn(name = "compte_id")  // Nom de la colonne dans la table Alerte
    private Compte compte;

    public Alerte() {
        this.dateHeure = LocalDateTime.now(); // Met automatiquement la date actuelle
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
