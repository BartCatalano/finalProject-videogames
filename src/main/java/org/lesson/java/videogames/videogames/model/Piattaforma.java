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

    public List<Videogame> getVideogame() {
        return this.videogame;
    }

    public void setVideogame(List<Videogame> videogame) {
        this.videogame = videogame;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "inserire il titolo del videogames")
    private String nomePiattaforma;
    
    private String logo;
    @NotNull(message = "inserire prezzo dell videogame")
    private BigDecimal prezzo; 


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

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    
}
