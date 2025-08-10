import java.io.*;
import java.util.*;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n1.Add Note  2.View Notes  3.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (ch == 1) {
                System.out.print("Enter your note: ");
                String note = sc.nextLine();
                try (FileWriter fw = new FileWriter(fileName, true)) { // append mode
                    fw.write(note + "\n");
                    System.out.println("Note saved!");
                } catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }

            } else if (ch == 2) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    System.out.println("\n--- Your Notes ---");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No notes found!");
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }

            } else if (ch == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
