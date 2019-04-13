package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;

public class PlayList {

    private String idPlaylist, name;
    private int numTitols;
    private LinkedList<Titol> titols;

    public PlayList(String name){
        this.idPlaylist= RandomUtils.getId();
        this.name=name;
        this.numTitols=0;
        this.titols= new LinkedList<Titol>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTitol(Titol titol){
        this.titols.add(titol);
        this.numTitols++;
    }

    public int getNumTitols() {
        return numTitols;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public LinkedList<Titol> getTitols() {
        return titols;
    }
}
