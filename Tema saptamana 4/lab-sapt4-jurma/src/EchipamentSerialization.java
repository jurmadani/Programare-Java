import java.io.*;
import java.util.List;

public class EchipamentSerialization {
    public static void serialize(List<Echipament> echipamente) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("echip.bin"))) {
            oos.writeObject(echipamente);
            System.out.println("Colecția de obiecte a fost serializată cu succes în fișierul 'echip.bin'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Echipament> deserialize() {
        List<Echipament> echipamente = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("echip.bin"))) {
            echipamente = (List<Echipament>) ois.readObject();
            System.out.println("Colecția de obiecte a fost deserializată cu succes din fișierul 'echip.bin'.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return echipamente;
    }
}
