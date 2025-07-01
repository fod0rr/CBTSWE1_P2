//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;

    public OrderDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/p2?serverTimezone=America/Sao_Paulo",
            "root",
            "*Arcane315"
        );
    }

    public void insert(Order o) throws SQLException {
        String sql = "INSERT INTO orders (ORD_NO, PURCH_AMT, ORD_DATE, CUSTOMER_ID, SALESMAN_ID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, o.getOrderNo());
            stmt.setDouble(2, o.getPurchaseAmt());
            stmt.setDate(3, o.getOrderDate());
            stmt.setInt(4, o.getCustomerId());
            stmt.setInt(5, o.getSalesmanId());
            stmt.executeUpdate();
        }
    }

    public List<Order> getAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Order order = new Order();
                order.setOrderNo(rs.getInt("ORD_NO"));
                order.setPurchaseAmt(rs.getDouble("PURCH_AMT"));
                order.setOrderDate(rs.getDate("ORD_DATE"));
                order.setCustomerId(rs.getInt("CUSTOMER_ID"));
                order.setSalesmanId(rs.getInt("SALESMAN_ID"));
                orders.add(order);
            }
        }
        return orders;
    }

    public void update(Order order) throws SQLException {
        String sql = "UPDATE orders SET PURCH_AMT = ?, ORD_DATE = ?, CUSTOMER_ID = ?, SALESMAN_ID = ? WHERE ORD_NO = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, order.getPurchaseAmt());
            stmt.setDate(2, order.getOrderDate());
            stmt.setInt(3, order.getCustomerId());
            stmt.setInt(4, order.getSalesmanId());
            stmt.setInt(5, order.getOrderNo());
            stmt.executeUpdate();
        }
    }

    public void delete(int orderNo) throws SQLException {
        String sql = "DELETE FROM orders WHERE ORD_NO = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderNo);
            stmt.executeUpdate();
        }
    }
}