
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println();
    }
}

public class SaveLoad {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Rahul", "abc123"),
            new Student(2, "Priya", "xyz789")
        };

        // Save objects to a file
        try (ObjectOutputStream out =
                 new ObjectOutputStream(
                     new FileOutputStream("students.dat"))) {

            out.writeObject(students);
            System.out.println("Objects saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving objects: " + e.getMessage());
            return;
        }

        // Load objects from the file
        try (ObjectInputStream in =
                 new ObjectInputStream(
                     new FileInputStream("students.dat"))) {

            Student[] loadedStudents = (Student[]) in.readObject();

            System.out.println("\nLoaded Student Details:");
            for (Student s : loadedStudents) {
                s.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading objects: " + e.getMessage());
        }
    }
}
