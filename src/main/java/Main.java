import database.connection.Database;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Database db = Database.getInstance();
        db.connection();
    }
}
