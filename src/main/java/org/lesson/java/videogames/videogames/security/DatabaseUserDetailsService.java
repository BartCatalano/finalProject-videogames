package org.lesson.java.videogames.videogames.security;

import java.util.Optional;

import org.lesson.java.videogames.videogames.model.User;
import org.lesson.java.videogames.videogames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
// dice a Spring che questa è una classe di servizio
@Service
// implementiamo l'interfaccia obbligatoria per fare il login in Spring Security.
public class DatabaseUserDetailsService implements UserDetailsService {
    // Inietto la repository per accedere agli utenti nel database
    @Autowired
    private UserRepository userRepository;

    // Questo è il metodo che Spring Security chiama quando un utente tenta di fare login.Gli passa lo username digitato nel form di login.
    // lo cerca nel database e restituire un oggetto che implementa UserDetails.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         // cerco l utente nel db
        Optional<User> userAttempt = userRepository.findByUsername(username);
        //  Se l'utente esiste, lo prendi e lo wrappi in un oggetto DatabaseUserDetails.
        if (userAttempt.isPresent()){
            return new DatabaseUserDetails(userAttempt.get());
        } else {
            // Se non esiste, lanci un’eccezione che Spring intercetta per dire “login fallito”.
            throw new UsernameNotFoundException("No user with username " + " have been found");
        }
    }

    
}
