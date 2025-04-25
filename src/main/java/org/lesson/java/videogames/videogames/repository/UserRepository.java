package org.lesson.java.videogames.videogames.repository;


import java.util.Optional;

import org.lesson.java.videogames.videogames.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
} 