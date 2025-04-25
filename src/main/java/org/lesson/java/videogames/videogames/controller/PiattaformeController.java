package org.lesson.java.videogames.videogames.controller;

import java.util.List;
import org.lesson.java.videogames.videogames.model.Piattaforma;
import org.lesson.java.videogames.videogames.service.PiattaformaService;
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
@RequestMapping("/piattaforme")
public class PiattaformeController {

    @Autowired
    private PiattaformaService piService;


    // prendo tutte le piattaforme
     @GetMapping()
    public String getAllPiattaforme(Model model) {
        // prendo la lista di tutti i videogames
        List<Piattaforma> piattaforma = piService.findAllPiattaforma();
        model.addAttribute("piattaforme",piattaforma);
        return "piattaforme/index";
    }

      // create
    // get per ricevere la pagina del form
    @GetMapping("/create")
    public String createPiattaforma(Model model) {
        // creo un oggetto vuoto di tipo piattaforma
        model.addAttribute("piattaforma", new Piattaforma());
        // mando la pagina html del create
        return "piattaforme/create";
    }
    
    @PostMapping("/create")
    // inserisco la validazione e lego i campi del form all oggetto videogame
    public String savePittaforma(@Valid @ModelAttribute ("piattaforma") Piattaforma piattaformaForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "piattaforme/create";}
            piService.create(piattaformaForm);
        
        return "redirect:/piattaforme";
    }

// EDIT
    @GetMapping("/edit/{id}")
    // inserisco la variabile per prendere l id insieme al model
    public String editPiattaforma(@PathVariable Integer id, Model model) {
        // al model uso la repo per prendere per id
        model.addAttribute("piattaforma", piService.getById(id));
         return "piattaforme/edit";
    }

    @PostMapping("/edit/{id}")
    // inserisco la validazione e recupero i campi del form dell oggetto videogame per poterli modificare e poi salvo il risultato
    public String saveEditPiattaforme(@Valid @ModelAttribute("piattaforma") Piattaforma piattaformaForm, BindingResult bindingResult,Model model) {
         if(bindingResult.hasErrors()){
            return "piattaforme/edit";
         }
         piService.create(piattaformaForm);
        return "redirect:/piattaforme";
    }





    // DELETE
    @PostMapping("delete/{id}")
    public String deletePiattaforma(@PathVariable ("id") Integer id) {
        piService.delete(id);
        return "redirect:/piattaforme";
    }

    
}
