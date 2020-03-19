package database.connection;
import java.sql.*;

public class DatabaseConnection {
    private String DB_URL = "jdbc:mysql://localhost/orm";
    private String DB_USER = "root";
    private String DB_PASSWORD = "Cucklife1";

    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from user");
//            while (rs.next()) {
//                System.out.println("loop");
//            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
