import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Salary\n4. Delete Employee\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    dao.addEmployee(new Employee(0, name, dept, sal));
                    break;
                case 2:
                    List<Employee> list = dao.getEmployees();
                    for (Employee e : list) {
                        System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDepartment() + " | " + e.getSalary());
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int idU = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    dao.updateEmployee(idU, newSal);
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int idD = sc.nextInt();
                    dao.deleteEmployee(idD);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
