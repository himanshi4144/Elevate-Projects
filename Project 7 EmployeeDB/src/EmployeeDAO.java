import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String query = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
            System.out.println("✅ Employee Added!");
        } catch (SQLException e) {
            System.out.println("Error Adding Employee: " + e.getMessage());
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("id"), rs.getString("name"),
                        rs.getString("department"), rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            System.out.println("Error Fetching Employees: " + e.getMessage());
        }
        return list;
    }

    public void updateEmployee(int id, double newSalary) {
        String query = "UPDATE employee SET salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ Employee Updated!");
        } catch (SQLException e) {
            System.out.println("Error Updating Employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Employee Deleted!");
        } catch (SQLException e) {
            System.out.println("Error Deleting Employee: " + e.getMessage());
        }
    }
}
