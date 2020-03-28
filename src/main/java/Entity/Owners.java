package Entity;


import database.annotation.Table;

import java.lang.reflect.Field;

@Table(name = "owners")
public class Owners extends Entity {
    public String name;

    public Owners(String name) {
//        super.insert();
        this.name = name;
        Field[] fields = this.getClass().getDeclaredFields();
//        super.insert(fields, new Object[]{this.name});
//        super.find().where("id", "=", "6");
//        super.test();
    }
}
