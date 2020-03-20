package database.connection;
import java.sql.*;

public class Database {
    private String DB_URL = "jdbc:mysql://localhost/orm";
    private String DB_USER = "root";
    private String DB_PASSWORD = "Cucklife1";
    private Connection con = null;

    private static Database db = null;

    public static Database getInstance() {
        if (db == null)
            db = new Database();
        return db;
    }

    private void tableList() {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            this.tableList();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
