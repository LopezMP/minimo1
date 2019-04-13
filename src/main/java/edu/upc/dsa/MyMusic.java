package edu.upc.dsa;

import java.util.List;

public interface MyMusic {


    public void addUser(String idUser, String name, String surname);
    public int numArtist();
    public void addArtist (String name, String surname);
    public List<Artist> artists();
    public int numPlayList(String idUser) throws UserNotFoundException;
    public void addPlayList (String idUser, String namePlayList) throws UserNotFoundException;
    public int numTitol(String idUser, String namePlaylist) throws  UserNotFoundException, PlaylistNotFoundException;
    public void addTitol (String idUser, String namePlaylist, String name, String album, String nameArtist, String surname, double duració) throws UserNotFoundException, PlaylistNotFoundException;
    public List<String> listPlaylist(String idUser, String namePlaylist) throws UserNotFoundException, PlaylistNotFoundException;

    public void clear();
}
