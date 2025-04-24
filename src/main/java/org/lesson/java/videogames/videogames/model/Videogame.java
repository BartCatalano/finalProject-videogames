package org.lesson.java.videogames.videogames.model;

import java.math.BigDecimal;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


// inserisco annotation che rende un entità la classe videogame
@Entity
public class Videogame {
    // creo la relazione tra videogame e generi con getter e setter
    @ManyToOne
    @JoinColumn(name = "genere_id")
    private Genere genere;

    public Genere getGenere() {
        return this.genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    // creo la relazione many to many con le piattaforme
    @ManyToMany
    // indico il nome della tabella ponte
    @JoinTable(name = "piattaforma_videogame",
    // inserisco le due colonne della tabella
    joinColumns  = @JoinColumn(name = "videogame_id"),
    inverseJoinColumns = @JoinColumn(name="piattaforma_id"))
    // annotation che evita la ricorsione infinita
    @JsonManagedReference
    // inserisco la lista di piattaforme associate al videogame
    private List<Piattaforma> piattaforma;


    public List<Piattaforma> getPiattaforma() {
        return this.piattaforma;
    }

    public void setPiattaforma(List<Piattaforma> piattaforma) {
        this.piattaforma = piattaforma;
    }


    // creo le var di istanza che saranno le colonne della tabella videogames
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "inserire il titolo del videogames")
    private String title;
    @NotBlank(message = "Inserire la descrizione")
    private String descrizione;

    private String foto;

    @NotNull(message = "inserire prezzo dell videogame")
    private BigDecimal prezzo; 

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }


}
