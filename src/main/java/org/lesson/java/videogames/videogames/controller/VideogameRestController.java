package org.lesson.java.videogames.videogames.controller;

import java.util.List;
import java.util.Optional;
import org.lesson.java.videogames.videogames.model.Videogame;
import org.lesson.java.videogames.videogames.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



// creo annotation per renderlo un rest controller
@RestController
// creo il mapping per le api
@RequestMapping("/api/videogames")
public class VideogameRestController {
 
    // ignetto il service di videogame
    @Autowired
    private VideogameService videoService;


    // creo api show per mandare tutti i videogame 
    // INDEX
    @GetMapping
    public List<Videogame> index() {
        // prendo tutti i videogame e li trasformo in lista
        List<Videogame> videogames = videoService.findAllVideogame();
        return  videogames ;
    }


    // creo la visualizzazione nel dettaglio
    //   SHOW
    @GetMapping("/{id}")
    // tramite in pathvariable recupero il valore dalla url e lo salvo in id
    public ResponseEntity<Videogame> show(@PathVariable Integer id) {
        // Chiama il service, che va a cercare il Videogame in base all’id nel database.
        Optional<Videogame> videogame = videoService.findById(id);
        // Il risultato è un Optional, che può contenere il risultato oppure essere vuoto.
        // lo gestisco con un if
        if(videogame.isEmpty()){
            return new ResponseEntity<Videogame>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Videogame>(videogame.get(), HttpStatus.OK);
    }
    

    







}
