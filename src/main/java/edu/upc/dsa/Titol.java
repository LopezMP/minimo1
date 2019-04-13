package edu.upc.dsa;

import edu.upc.dsa.util.RandomUtils;

import java.util.HashMap;

public class Titol {
    private String idTitol, name, album;
    private Artist artista;
    private double duració;

    public Titol(String name, String album, String nameArtist, String surname, double duració){
        this.idTitol= RandomUtils.getId();
        this.name=name;
        this.album=album;
        this.artista= new Artist(nameArtist, surname);
        this.duració=duració;
    }

    public String getName() {
        return name;
    }

    public String getIdTitol() {
        return idTitol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuració() {
        return duració;
    }
    @Override
    public String toString() {
        return "Titulo [id="+getIdTitol()+", name=" + getName() + ", Artista=" + getArtista().getName()+" "+getArtista().getSurname() +", album="+getAlbum()+", duració="+duració+"]";
    }
}
