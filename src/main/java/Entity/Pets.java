package Entity;

import database.annotation.Table;

import java.lang.reflect.Field;

@Table(name = "pet")
public class Pets extends Entity {
    public String name;
    public int id_owner;

    public Pets(String name, int id_owner) {
//        super.insert();
        this.name = name;
        this.id_owner = id_owner;
        Field[] fields = this.getClass().getDeclaredFields();
        super.insert(fields, new Object[]{this.name, this.id_owner});
//        super.find();
    }

    public static void tmp() {}
}
