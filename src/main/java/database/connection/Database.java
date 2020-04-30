package database.connection;
import java.sql.*;

public class Database {
    private String DB_URL = "jdbc:mysql://localhost/orm";
    private String DB_USER = "root";
    private String DB_PASSWORD = "Cucklife1";
    private Connection con = null;
    Statement stmt = null;

    private static Database db = null;

    public static Database getInstance() {
        if (db == null)
            db = new Database();
        return db;
    }

    private void tableList() {
        try {
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet execute(String qu) {
        System.out.println("EXECUTE: " + qu);
        ResultSet rs = null;
        try {

            stmt = con.createStatement();

            rs = stmt.executeQuery(qu);
//            while (rs.next()) {
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("name"));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void insert(String qu) {
        System.out.println("INSERT: " + qu);
        try {
            stmt = con.createStatement();
            Boolean rs = stmt.execute(qu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();

            this.tableList();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
