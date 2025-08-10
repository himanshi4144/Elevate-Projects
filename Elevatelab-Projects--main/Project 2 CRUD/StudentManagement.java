import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " - " + name + " - " + marks;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add  2.View  3.Update  4.Delete  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();
                list.add(new Student(id, name, marks));
                System.out.println("Student Added!");

            } else if (ch == 2) {
                if (list.isEmpty()) {
                    System.out.println("No Students Found!");
                } else {
                    for (Student s : list) {
                        System.out.println(s);
                    }
                }

            } else if (ch == 3) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Student s : list) {
                    if (s.id == id) {
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        s.name = sc.nextLine();
                        System.out.print("Enter New Marks: ");
                        s.marks = sc.nextDouble();
                        found = true;
                        System.out.println("Updated!");
                        break;
                    }
                }
                if (!found) System.out.println("Student Not Found!");

            } else if (ch == 4) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                boolean deleted = list.removeIf(s -> s.id == id);
                if (deleted) System.out.println("Deleted!");
                else System.out.println("Student Not Found!");

            } else if (ch == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}

