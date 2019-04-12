package edu.upc.dsa;

import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.apache.log4j.Logger;
public class MyMusicImpl implements MyMusic {
    static Logger logger = Logger.getLogger(MyMusicImpl.class);

    private static MyMusicImpl singleton;
    private HashMap<String,User> users;
    private LinkedList<Artist>artists;

    private MyMusicImpl(){// solo se usa una vez al crearse con el singleton
        this.users =new HashMap<>();
        this.artists=new LinkedList<>();
    }
    public static MyMusicImpl getInstance() //Singleton
    {
        if (singleton == null)
            singleton = new MyMusicImpl();
        return singleton;
    }

    @Override
    public void addArtist(String name, String surname) {
        logger.info("añadir Artista");
        this.artists.add(new Artist(name, surname));
        logger.info(name+" se ha añadido");
    }

    @Override
    public List<Artist> artists() {
        logger.info("se ha devuelto la lista de artitas");
        return this.artists;
    }

    @Override
    public void addPlayList(String idUser, String namePlayList) throws UserNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error añadiendo playlist");
            throw new UserNotFoundException();
        }
        else {
            user.setName(namePlayList);
            logger.info("playlist añadido");
        }

    }

    @Override
    public void addTitol(String idUser, String idPlaylist, String name, String album, String artist, double duració) throws UserNotFoundException, PlaylistNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error añadiendo titulo");
            throw new UserNotFoundException();
        }
        else {
            PlayList playList=user.findplaylist(idPlaylist);
             playList.addTitol(new Titol(name, album, artist, duració));
            logger.info("titulo añadido");
        }
    }

    @Override
    public List<PlayList> listPlaylist(String idUser) throws UserNotFoundException {
        User user= this.users.get(idUser);
        if(user==null){
            logger.info("error sacando la lista");
            throw new UserNotFoundException();
        }
        else {
            List<PlayList> Playlists = new LinkedList<>();
            for (int i=0; i<user.getPlayLists().length; i++){
                Playlists.add(user.getPlayLists(i));
            }
            return  Playlists;
        }
    }
}
