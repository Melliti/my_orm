import database.connection.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        DatabaseConnection db = new DatabaseConnection();
        db.connection();
    }
}
