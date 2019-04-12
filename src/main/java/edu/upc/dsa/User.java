package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String idUser, name, surname;
    private PlayList[] playLists;
    public static final int numMax = 10; //numero maximo de playlists
    private int num;

    public User(String idUser, String name, String surname){
        this.idUser=idUser;
        this.name=name;
        this.surname=surname;
        this.num=0;
        this.playLists = new PlayList[numMax];
    }

    public String getName() {
        return name;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PlayList findplaylist (String idPlaylist) throws PlaylistNotFoundException {
        for (int i=0; i< this.num; i++){
            if(this.playLists[i].getIdPlaylist().equals(idPlaylist)){
                return this.playLists[i];
            }
        }
        throw new PlaylistNotFoundException();
    }

    public PlayList getPlayLists(int i) {
        return playLists[i];
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }
}