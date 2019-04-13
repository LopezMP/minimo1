import edu.upc.dsa.MyMusic;
import edu.upc.dsa.MyMusicImpl;
import edu.upc.dsa.models.PlaylistNotFoundException;
import edu.upc.dsa.models.UserNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyMusicTest  {
    private MyMusic mb;

    @Before
    public void setUp() throws Exception {
        this.mb = MyMusicImpl.getInstance();

        this.mb.addUser("id", "Juan", "Lopex");
        this.mb.addArtist("Lola", "Lopez");
        this.mb.addArtist("Pepe", "Tez");

        Assert.assertEquals(2, this.mb.numArtist());
        this.mb.addPlayList("id", "09");

        this.mb.addTitol("id","09","nombre","res","lola","perez", 22);
        this.mb.addTitol("id","09","nombre2","nada","juan","Gonzalez", 2);
        Assert.assertEquals(1, this.mb.numPlayList("id"));
        Assert.assertEquals(2, this.mb.numTitol("id", "09"));

    }

    @After
    public void tearDown(){
        this.mb.clear();
    }

    @Test
    public void addPlayList()throws Exception {
        this.mb.addPlayList("id", "playlist1");
        Assert.assertEquals(2, this.mb.numPlayList("id"));
    }
    @Test(expected = UserNotFoundException.class)
    public void addPlayList2()throws Exception {
        this.mb.addPlayList("id33", "playlist2");
    }
    @Test
    public void addTitol() throws Exception{
        this.mb.addTitol("id","09","nombre3","nada","juan","pepito", 3);
        Assert.assertEquals(3, this.mb.numTitol("id", "09"));
    }

  @Test
    public void listPlaylist() throws  Exception{
        List<String> playLists= this.mb.listPlaylist("id", "09");
    }
    @Test(expected = PlaylistNotFoundException.class)
    public void listPlaylist2() throws  Exception{
        List<String> playLists= this.mb.listPlaylist("id", "9a9");
    }

}
