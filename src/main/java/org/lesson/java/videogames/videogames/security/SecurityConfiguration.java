package org.lesson.java.videogames.videogames.security;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
@SuppressWarnings("removal")
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
            .requestMatchers("/videogames/create", "/videogames/edit/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.POST, "/videogames/**").hasAuthority("ADMIN")
            .requestMatchers("/piattaforme", "/piattaforme/**").hasAnyAuthority("USER","ADMIN")
            .requestMatchers("/generi", "/generi/**").hasAnyAuthority("USER","ADMIN")
            .requestMatchers("/videogames", "/videogames/**").hasAnyAuthority("USER", "ADMIN")
            .requestMatchers("/", "/login", "/css/**", "/js/**", "/images/**").permitAll()
            .and().formLogin()
            .and().logout()
            .and().exceptionHandling();

    return http.build();
}


    @Bean
    DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}
