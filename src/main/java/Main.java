import Entity.Pets;
import database.connection.Database;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
//        db.connection();
        Pets pet = new Pets("Mathis", 2);
        Field[] fields = pet.getClass().getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName());
        }
    }
}
