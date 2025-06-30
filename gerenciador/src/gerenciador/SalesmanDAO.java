//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesmanDAO {
    private Connection conn;

    public SalesmanDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/p2?serverTimezone=America/Sao_Paulo",
            "root",
            "*Arcane315"
        );
    }

    public void insert(Salesman s) throws SQLException {
        String sql = "INSERT INTO salesman (SALESMAN_ID, NAME, CITY, COMMISSION) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getSalesmanId());
            stmt.setString(2, s.getName());
            stmt.setString(3, s.getCity());
            stmt.setDouble(4, s.getCommission());
            stmt.executeUpdate();
        }
    }

    public List<Salesman> getAll() throws SQLException {
        List<Salesman> salesmen = new ArrayList<>();
        String sql = "SELECT * FROM salesman";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Salesman salesman = new Salesman();
                salesman.setSalesmanId(rs.getInt("SALESMAN_ID"));
                salesman.setName(rs.getString("NAME"));
                salesman.setCity(rs.getString("CITY"));
                salesman.setCommission(rs.getDouble("COMMISSION"));
                salesmen.add(salesman);
            }
        }
        return salesmen;
    }

    public void update(Salesman salesman) throws SQLException {
        String sql = "UPDATE salesman SET NAME = ?, CITY = ?, COMMISSION = ? WHERE SALESMAN_ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salesman.getName());
            stmt.setString(2, salesman.getCity());
            stmt.setDouble(3, salesman.getCommission());
            stmt.setInt(4, salesman.getSalesmanId());
            stmt.executeUpdate();
        }
    }

    public void delete(int salesmanId) throws SQLException {
        String sql = "DELETE FROM salesman WHERE SALESMAN_ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salesmanId);
            stmt.executeUpdate();
        }
    }
}