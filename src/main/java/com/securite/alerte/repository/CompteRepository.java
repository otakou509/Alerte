/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.securite.alerte.repository;

import com.securite.alerte.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    Optional<Compte> findByEmail(String email);

}
