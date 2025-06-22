/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securite.alerte.service;

import com.securite.alerte.model.Compte;
import com.securite.alerte.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Compte compte = compteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email non trouvé"));

        return new User(compte.getEmail(), compte.getMotDePasse(), Collections.emptyList());
    }
}
