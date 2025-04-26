package org.lesson.java.videogames.videogames.security;


import java.util.HashSet;
import java.util.Set;

import org.lesson.java.videogames.videogames.model.Role;
import org.lesson.java.videogames.videogames.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// implementazione di UserDetails che serve per far capire a Spring come gestire l'utente loggato
public class DatabaseUserDetails implements UserDetails {
    // var di istanza visibili solo in questa classe "private" una volta istanzate non puo piu essere riassegnato "final"
    private final Integer id;
    private final String username;
    private final String password;
    // creo le autorità dove salvero i permessi dell utente
    private final Set<GrantedAuthority> authorities;
    // È il costruttore della classe DatabaseUserDetails Riceve come parametro un oggetto User, entità utente presa dal database
    public DatabaseUserDetails(User user){
        // Copia i dati principali dall'oggetto User:
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        // Crea un nuovo insieme (Set) vuoto per contenere le authorities, i ruoli o permessi che l’utente ha
        this.authorities = new HashSet<GrantedAuthority>();
        // Cicla su ogni Role che l'utente ha.
        for (Role role : user.getRoles()){
            // Per ogni Role, crea una SimpleGrantedAuthority usando il nome del ruolo ("ROLE_ADMIN") e la aggiunge alla lista authorities
            this.authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

    }


    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }


    public Set<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

  

    public Integer getId() {
        return this.id;
    }
}
