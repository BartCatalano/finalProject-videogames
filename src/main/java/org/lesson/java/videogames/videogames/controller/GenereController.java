package org.lesson.java.videogames.videogames.controller;

import java.util.List;
import org.lesson.java.videogames.videogames.model.Genere;
import org.lesson.java.videogames.videogames.model.Piattaforma;
import org.lesson.java.videogames.videogames.repository.GenereRepository;
import org.lesson.java.videogames.videogames.repository.VideogameRepository;
import org.lesson.java.videogames.videogames.service.GenereService;
import org.lesson.java.videogames.videogames.service.PiattaformaService;
import org.lesson.java.videogames.videogames.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/generi")
public class GenereController {

    @Autowired
private VideogameService videoService;
@Autowired 
private GenereService geService;


    // prendo tutti i generi
     @GetMapping()
    public String getAllGenere(Model model) {
        // prendo la lista di tutti e generi e dei videogames
        List<Genere> genere = geService.findAllGenere();
        model.addAttribute("generi",genere);
        model.addAttribute("videogames", videoService.findAllVideogame());
        return "generi/index";
    }


       // create
    // get per ricevere la pagina del form
    @GetMapping("/create")
    public String createGenere(Model model) {
        // creo un oggetto vuoto di tipo piattaforma
        model.addAttribute("genere", new Genere());
        // mando la pagina html del create
        return "generi/create";
    }
    
    @PostMapping("/create")
    // inserisco la validazione e lego i campi del form all oggetto videogame
    public String saveGenere(@Valid @ModelAttribute ("genere") Genere genereForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "generi/create";}
            geService.create(genereForm);
        
        return "redirect:/generi";
    }

     // DELETE
    @PostMapping("delete/{id}")
    public String deleteGenere(@PathVariable ("id") Integer id) {
        geService.delete(id);
        return "redirect:/generi";
    }


    // EDIT
    @GetMapping("/edit/{id}")
    // inserisco la variabile per prendere l id insieme al model
    public String editGenere(@PathVariable Integer id, Model model) {
        // al model uso la repo per prendere per id
        model.addAttribute("genere", geService.getById(id));
         return "generi/edit";
    }

    @PostMapping("/edit/{id}")
    // inserisco la validazione e recupero i campi del form dell oggetto videogame per poterli modificare e poi salvo il risultato
    public String saveEditGenere(@Valid @ModelAttribute("genere") Genere genereForm, BindingResult bindingResult,Model model) {
         if(bindingResult.hasErrors()){
            return "generi/edit";
         }
         geService.create(genereForm);
        return "redirect:/generi";
    }

    
}
