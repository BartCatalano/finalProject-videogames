package org.lesson.java.videogames.videogames.controller;

import java.util.List;
import org.lesson.java.videogames.videogames.model.Videogame;
import org.lesson.java.videogames.videogames.repository.GenereRepository;
import org.lesson.java.videogames.videogames.repository.PiattaformaRepository;
import org.lesson.java.videogames.videogames.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;








// inserisco annotation controller
@Controller
// inserisco la rotta base di riferimento del controller
@RequestMapping("/videogames")
public class VideogameController {
    // uso annotation autowired per creare in automatico l'oggetto che estende
    // l'interfaccia per la repository
    @Autowired
    private VideogameRepository videogameRepository;
    @Autowired
    private PiattaformaRepository piattaformaRepository;
    @Autowired
    private GenereRepository genereRepository;

    // inizio con la index

    @GetMapping()
    public String getAllVideogames(Model model) {
        // prendo la lista di tutti i videogames
        List<Videogame> videogame = videogameRepository.findAll();
        model.addAttribute("videogames",videogame);
        model.addAttribute("piattaforme", piattaformaRepository.findAll());
        model.addAttribute("generi", genereRepository.findAll());
        return "videogames/index";
    }

    // create
    // get per ricevere la pagina del form
    @GetMapping("/create")
    public String createVideogame(Model model) {
        // creo un oggetto vuoto di tipo videogame
        model.addAttribute("videogame", new Videogame());
        model.addAttribute("piattaforme", piattaformaRepository.findAll());
        model.addAttribute("generi", genereRepository.findAll());
        // mando la pagina html del create
        return "videogames/create";
    }
    
    @PostMapping("/create")
    // inserisco la validazione e lego i campi del form all oggetto videogame
    public String saveVideogame(@Valid @ModelAttribute ("videogame") Videogame videogameForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "videogames/create";}
            videogameRepository.save(videogameForm);
        
        return "redirect:/videogames";
    }
    
    // EDIT
    @GetMapping("/edit/{id}")
    // inserisco la variabile per prendere l id insieme al model
    public String editVideogame(@PathVariable Integer id, Model model) {
        // al model uso la repo per prendere per id
        model.addAttribute("videogame", videogameRepository.findById(id).get());
        model.addAttribute("piattaforme", piattaformaRepository.findAll());
        model.addAttribute("generi", genereRepository.findAll());
         return "videogames/edit";
    }

    @PostMapping("/edit/{id}")
    // inserisco la validazione e recupero i campi del form dell oggetto videogame per poterli modificare e poi salvo il risultato
    public String saveEditVideogame(@Valid @ModelAttribute("videogame") Videogame forVideogame, BindingResult bindingResult,Model model) {
         if(bindingResult.hasErrors()){
            return "videogames/edit";
         }
        videogameRepository.save(forVideogame);
        return "redirect:/videogames";
    }
    
    // DELETE
    @PostMapping("delete/{id}")
    public String deleteVideogame(@PathVariable ("id") Integer id) {
        videogameRepository.deleteById(id);
        return "redirect:/videogames";
    }

    // SHOW/DETTAGLIO
// per creare lo show della pizza selezionata ho bisogno di tutta la lista e poi paragonare l'id selezionato con un ciclo for, quando lo trova mi restituisce il videogame che corrisponde lo salvo nel model e e lo mostro in pagina
    @GetMapping("/{id}")
    public String dettaglioVideogame(@PathVariable Integer id, Model model) {
        // prendo tutti i videogame
        List<Videogame> videogames = videogameRepository.findAll();
        // ora li ciclo per controllarli tutti
        for (Videogame videogame : videogames){
            // costrutto if per la corrispondenza
            if(videogame.getId() == id){
                // ora al model aggiungo il videogame corrispondente
                model.addAttribute("videogame", videogame);
                model.addAttribute("piattaforme", piattaformaRepository.findAll());
                return "videogames/dettaglio";
            }  } 
        // nel model inserisco il non trovato in caso di mancanza di corrispondenza
            model.addAttribute("videogame", + id + "non trovato");
            return "/videogames";
    }
    
    
    

}
