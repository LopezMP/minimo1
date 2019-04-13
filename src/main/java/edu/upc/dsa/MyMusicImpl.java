package edu.upc.dsa;

import java.util.*;

import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;
public class MyMusicImpl implements MyMusic {
    static Logger logger = Logger.getLogger(MyMusicImpl.class);

    private static MyMusicImpl singleton;
    private HashMap<String, User> users;
    private LinkedList<Artist>artists;
    private int numArtist;

    private MyMusicImpl(){// solo se usa una vez al crearse con el singleton
        this.users =new HashMap<>();
        this.artists=new LinkedList<>();
        this.numArtist=0;
    }
    public static MyMusicImpl getInstance() //Singleton
    {
        if (singleton == null)
            singleton = new MyMusicImpl();
        return singleton;
    }

    public void addUser(String idUser, String name, String surname) {
        this.users.put(idUser, new User(idUser,name,surname));
        logger.info("added user"+name);
    }


    @Override
    public void addArtist(String name, String surname) {
        logger.info("añadir Artista");
        this.artists.add(new Artist(name, surname));
        this.numArtist++;
        logger.info(name+" se ha añadido");
    }

    @Override
    public List<Artist> artists() {
        logger.info("se ha devuelto la lista de artistas");
        return this.artists;
    }

    @Override
    public int numPlayList(String idUser) throws UserNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error numPlaylist");
            throw new UserNotFoundException();
        }
        else {
            logger.info("playlist añadido");
            return user.getNum();
        }
    }

    @Override
    public void addPlayList(String idUser, String namePlayList) throws UserNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error añadiendo playlist");
            throw new UserNotFoundException();
        }
        else {
            user.addPlayLists(namePlayList);
            user.setNum(1);
            logger.info("playlist añadido");
        }
    }

    @Override
    public int numTitol(String idUser, String namePlaylist) throws UserNotFoundException, PlaylistNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error encontrando user");
            throw new UserNotFoundException();
        }
        else {
            return user.findplaylist(namePlaylist).getNumTitols();
        }
    }

    @Override
    public void addTitol(String idUser, String namePlaylist, String name, String album, String nameArtist, String surname, double duració) throws UserNotFoundException, PlaylistNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error añadiendo titulo");
            throw new UserNotFoundException();
        }
        else {
             user.findplaylist(namePlaylist).addTitol(new Titol(name, album, nameArtist, surname, duració));
            logger.info("titulo añadido");
        }
    }

    @Override
    public List<String> listPlaylist(String idUser, String namePlaylist) throws UserNotFoundException, PlaylistNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error sacando la lista");
            throw new UserNotFoundException();
        }
        else {
            user.findplaylist(namePlaylist);
            List<String> Playlists = new ArrayList<String>();
            for (int i=0; i<user.getNum(); i++){
                Playlists.add(user.getPlayLists(i).toString());
            }
            logger.info("Se devuelve correctamente la playlist");
            return  Playlists;
        }
    }
    @Override
    public int numArtist() {
        return this.numArtist;
    }


    @Override
    public void clear() {
        this.users =new HashMap<>();
        this.artists=new LinkedList<>();
        this.numArtist=0;
    }
}
