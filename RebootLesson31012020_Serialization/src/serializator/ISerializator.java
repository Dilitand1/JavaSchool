package serializator;

import java.io.IOException;

public interface ISerializator {
    void serialize(Object o, String filename) throws IOException;
    Object deserialize(String filename) throws IOException;
}
