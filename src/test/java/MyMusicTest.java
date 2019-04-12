import edu.upc.dsa.MyMusic;
import edu.upc.dsa.MyMusicImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyMusicTest {
    private MyMusic mb; @Before
    public void setUp() throws Exception {
        this.mb = MyMusicImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");

        this.mb.addArtist("Lola", "Lopez");
        this.mb.addArtist("Pepe", "Tez");

        this.mb.addTitol("id","09","nombre","res","lola",22);
        this.mb.addTitol("id01","19","nombre2","nada","juan",2);


    }

    @After
    public void tearDown(){
        this.mb.clear();
    }

}
