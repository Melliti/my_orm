package Entity;

import database.annotation.Relation;
import database.annotation.Table;

import java.lang.reflect.Field;

@Table(name = "pet")
@Relation(belongsToMany = {"owners"})
public class Pets extends Entity {
    public String name;
    public int id_owner;

    public Pets(String name, int id_owner) {
//        super.insert();
        this.name = name;
        this.id_owner = id_owner;
        Field[] fields = this.getClass().getDeclaredFields();
//        super.insert(fields, new Object[]{this.name, this.id_owner});
//        super.find().where("id_owner", "=", "2");
        super.test();
    }

    public static void tmp() {}
}
