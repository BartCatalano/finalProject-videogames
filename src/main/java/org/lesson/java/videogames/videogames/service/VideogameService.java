package org.lesson.java.videogames.videogames.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.videogames.videogames.model.Videogame;
import org.lesson.java.videogames.videogames.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// si crea un service per gestire la logica in modo da usare la SoC cioè separazione di responsabilità
@Service
public class VideogameService {
    
// ignetto la repository di videogame
@Autowired
private VideogameRepository videogameRepository;

// logica di SHOW
public List<Videogame> findAllVideogame(){
    return videogameRepository.findAll();
}

// logica di CREATE

public Videogame create(Videogame videogame){
return videogameRepository.save(videogame);
}

// logica di UPDATE
public Videogame update(Videogame videogame){
    return videogameRepository.save(videogame);
    }

    // logica di DELETE
    public void delete(Integer id){
        videogameRepository.deleteById(id);
    }

    //logica del  FINDiD
public Videogame getById(Integer id){
    Optional<Videogame> videogameAttempt = videogameRepository.findById(id);
    if(videogameAttempt.isEmpty()){

    }
    return videogameAttempt.get();
}

// gestisco la casistica in cui l'id non viene trovato
public Optional<Videogame> findById(Integer id){
    return videogameRepository.findById(id);
   }








}
