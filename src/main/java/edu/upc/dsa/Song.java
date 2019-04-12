package edu.upc.dsa;

public class Song {
    private String idSong, name, album, artist;
    private double duració;

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getIdSong() {
        return idSong;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setIdSong(String idSong) {
        this.idSong = idSong;
    }
}
