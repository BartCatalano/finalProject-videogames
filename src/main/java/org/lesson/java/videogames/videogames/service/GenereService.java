package org.lesson.java.videogames.videogames.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.videogames.videogames.model.Genere;
import org.lesson.java.videogames.videogames.model.Piattaforma;
import org.lesson.java.videogames.videogames.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenereService {

    @Autowired
    private GenereRepository genereRepository;

    // logica di SHOW
public List<Genere> findAllGenere(){
    return genereRepository.findAll();
}

// logica di CREATE

public Genere create(Genere genere){
return genereRepository.save(genere);
}

// logica di UPDATE
public Genere update(Genere genere){
    return genereRepository.save(genere);
    }

    // logica di DELETE
    public void delete(Integer id){
        genereRepository.deleteById(id);
    }

    public Genere getById(Integer id){
    Optional<Genere> genereAttempt = genereRepository.findById(id);
    if(genereAttempt.isEmpty()){

    }
    return genereAttempt.get();
}


    
}
