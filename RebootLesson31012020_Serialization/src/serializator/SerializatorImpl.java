package serializator;

import sun.plugin.javascript.navig.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializatorImpl implements ISerializator {
    @Override
    public void serialize(Object o, String filename) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(o);
        }
    }

    @Override
    public Object deserialize(String filename) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            return objectInputStream.readObject();
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
