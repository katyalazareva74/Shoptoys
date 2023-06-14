package savefile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutInput {
    void savefile(Object stoy) throws FileNotFoundException, IOException;

    Object loadfile() throws FileNotFoundException, IOException, ClassNotFoundException;
}
