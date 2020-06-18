import Entity.Owners;
import Entity.Pets;
import database.connection.Database;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.connection();
//        Pets.findByID(2);
        Pets pet = new Pets("Niro", 1);
        Owners owner = pet.owners();
        // Check if the id_owner from the pet match
//        Owners owner = Owners.find(1);
        System.out.println(owner.getName());

//        Field[] fields = pet.getClass().getDeclaredFields();
//        for (Field field: fields) {
//            System.out.println(field.getName());
//        }
    }
}
