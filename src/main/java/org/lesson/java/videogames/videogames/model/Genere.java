package org.lesson.java.videogames.videogames.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
// gli dico che è un entità tramite annotation, una tabella del db
@Entity
public class Genere {

    // creo relazione manyToOne con videogames
    @OneToMany(mappedBy = "genere")
    private List<Videogame> videogame;

    // getter e setter di videogame per rendere bidirezionale
    public List<Videogame> getVideogame() {
        return this.videogame;
    }

    public void setVideogame(List<Videogame> videogame) {
        this.videogame = videogame;
    }


    // creo un id dinamico automatico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "inserire il nome del genere")
    private String nameGenere;
    @NotBlank(message = "Inserire la descrizione")
    private String descrizioneGenere;
// creo getter e setter 
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGenere() {
        return this.nameGenere;
    }

    public void setNameGenere(String nameGenere) {
        this.nameGenere = nameGenere;
    }

    public String getDescrizioneGenere() {
        return this.descrizioneGenere;
    }

    public void setDescrizioneGenere(String descrizioneGenere) {
        this.descrizioneGenere = descrizioneGenere;
    }


}
