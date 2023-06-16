package savefile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad implements OutInput {

    private static final int Java = 0;

    @Override
    public void savefile(Object stoy) throws FileNotFoundException, IOException {
        try (ObjectOutputStream savetoys = new ObjectOutputStream(new FileOutputStream("Java/data.dat"))) {
            savetoys.writeObject(stoy);
            savetoys.close();
        }
    }

    @Override
    public Object loadfile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream loadtoys = new ObjectInputStream(new FileInputStream("Java/data.dat"));
        Object ltoy = new Object();
        ltoy = loadtoys.readObject();
        loadtoys.close();
        return ltoy;
    }
    
}
