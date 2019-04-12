package edu.upc.dsa;

import java.util.List;

public interface MyMusic {



    public void addArtist (String name, String surname);
    public List<Artist> artists();
    public void addPlayList (String idUser, String namePlayList) throws UserNotFoundException;
    public void addTitol (String idUser, String idPlaylist, String name, String album, String artist, double duració) throws UserNotFoundException, PlaylistNotFoundException;
    public List<PlayList> listPlaylist(String idUser) throws UserNotFoundException;
}
