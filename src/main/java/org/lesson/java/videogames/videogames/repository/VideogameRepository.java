package org.lesson.java.videogames.videogames.repository;

import org.lesson.java.videogames.videogames.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository  extends JpaRepository<Videogame, Integer>{
    
}
