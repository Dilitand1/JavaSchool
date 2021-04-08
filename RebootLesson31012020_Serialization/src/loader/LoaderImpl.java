package loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoaderImpl implements Loader {
    @Override
    public Object load(String fileName) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            return objectInputStream.readObject();
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
