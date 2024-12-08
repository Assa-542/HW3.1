import java.io.*;

public class Main {
    public static void serializePerson(Person person, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePerson(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        String filename = "person.ser";

        // Сериализация
        serializePerson(person, filename);
        System.out.println("Serialized person: " + person);

        // Десериализация
        Person deserializedPerson = deserializePerson(filename);
        System.out.println("Deserialized person: " + deserializedPerson);
    }
}
