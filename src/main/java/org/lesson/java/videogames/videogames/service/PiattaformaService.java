package org.lesson.java.videogames.videogames.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.videogames.videogames.model.Piattaforma;
import org.lesson.java.videogames.videogames.model.Videogame;
import org.lesson.java.videogames.videogames.repository.PiattaformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiattaformaService {

@Autowired
private PiattaformaRepository piattaformaRepository;

// logica di SHOW
public List<Piattaforma> findAllPiattaforma(){
    return piattaformaRepository.findAll();
}

// logica di CREATE

public Piattaforma create(Piattaforma piattaforma){
return piattaformaRepository.save(piattaforma);
}

// logica di UPDATE
public Piattaforma update(Piattaforma videogame){
    return piattaformaRepository.save(videogame);
    }

    // logica di DELETE
    public void delete(Integer id){
        piattaformaRepository.deleteById(id);
    }

     //logica del  FINDiD
public Piattaforma getById(Integer id){
    Optional<Piattaforma> piattaformaAttempt = piattaformaRepository.findById(id);
    if(piattaformaAttempt.isEmpty()){

    }
    return piattaformaAttempt.get();
}


    
}
