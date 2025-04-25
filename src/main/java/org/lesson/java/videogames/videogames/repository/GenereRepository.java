package org.lesson.java.videogames.videogames.repository;

import org.lesson.java.videogames.videogames.model.Genere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenereRepository extends JpaRepository<Genere, Integer> {
    
}
