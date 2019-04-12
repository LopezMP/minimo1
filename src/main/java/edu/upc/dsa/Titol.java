package edu.upc.dsa;

import edu.upc.dsa.util.RandomUtils;

import java.util.HashMap;

public class Titol {
    private String idTitol, name, album, artist;
    private double duració;

    public Titol(String name, String album, String artist, double duració){
        this.idTitol= RandomUtils.getId();
        this.name=name;
        this.album=album;
        this.artist=artist;
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

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuració() {
        return duració;
    }
}
