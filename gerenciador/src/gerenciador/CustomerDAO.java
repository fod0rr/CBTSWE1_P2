//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection conn;

    public CustomerDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/p2?serverTimezone=America/Sao_Paulo",
            "root",
            "*Arcane315"
        );
    }

    public void insert(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (CUSTOMER_ID, CUST_NAME, CITY, GRADE, SALESMAN_ID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustName());
            stmt.setString(3, customer.getCity());
            stmt.setInt(4, customer.getGrade());
            stmt.setInt(5, customer.getSalesmanId());
            stmt.executeUpdate();
        }
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
                customer.setCustName(rs.getString("CUST_NAME"));
                customer.setCity(rs.getString("CITY"));
                customer.setGrade(rs.getInt("GRADE"));
                customer.setSalesmanId(rs.getInt("SALESMAN_ID"));
                customers.add(customer);
            }
        }
        return customers;
    }

    public void update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET CUST_NAME = ?, CITY = ?, GRADE = ?, SALESMAN_ID = ? WHERE CUSTOMER_ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustName());
            stmt.setString(2, customer.getCity());
            stmt.setInt(3, customer.getGrade());
            stmt.setInt(4, customer.getSalesmanId());
            stmt.setInt(5, customer.getCustomerId());
            stmt.executeUpdate();
        }
    }

    public void delete(int customerId) throws SQLException {
        String sql = "DELETE FROM customer WHERE CUSTOMER_ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.executeUpdate();
        }
    }
}