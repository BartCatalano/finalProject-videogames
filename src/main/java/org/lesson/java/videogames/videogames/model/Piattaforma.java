package org.lesson.java.videogames.videogames.model;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
// imposto come entity
@Entity
public class Piattaforma {
// genero id automatico

// creo la relazione many to many con i videogame semplice, già definito in videogames
 @ManyToMany(mappedBy = "piattaforma")
 @JsonBackReference
 private List<Videogame> videogame;

//  getter e setter di videogame per rendere bidirezionali
    public List<Videogame> getVideogame() {
        return this.videogame;
    }

    public void setVideogame(List<Videogame> videogame) {
        this.videogame = videogame;
    }


// creo le var di istanza della piattaforma
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "inserire il titolo della piattaforma")
    private String nomePiattaforma;
    
    private String logo;

    @NotNull(message = "inserire prezzo della piattaforma più recente")
    private BigDecimal prezzoPiattaforma; 


    // creo getter e setter
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePiattaforma() {
        return this.nomePiattaforma;
    }

    public void setNomePiattaforma(String nomePiattaforma) {
        this.nomePiattaforma = nomePiattaforma;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public BigDecimal getPrezzoPiattaforma() {
        return this.prezzoPiattaforma;
    }

    public void setPrezzoPiattaforma(BigDecimal prezzoPiattaforma) {
        this.prezzoPiattaforma = prezzoPiattaforma;
    }

    
}
