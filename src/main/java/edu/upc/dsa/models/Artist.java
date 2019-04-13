package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;

public class Artist {
    private String idArtist, name, surname;
    private LinkedList<Titol>titols;

    public Artist(String name, String surname){
        this.idArtist= RandomUtils.getId();
        this.name=name;
        this.surname=surname;
        this.titols=new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LinkedList<Titol> getTitols() {
        return titols;
    }

    public String getIdArtist() {
        return idArtist;
    }

    public void setTitols(LinkedList<Titol> titols) {
        this.titols = titols;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
