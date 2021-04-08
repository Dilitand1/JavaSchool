package loader;

import java.io.IOException;

public interface Loader {
    Object load(String fileName) throws IOException;
}
