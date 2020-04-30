package Entity;

import database.annotation.Relation;
import database.annotation.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;

@Table(name = "pet")
@Relation(hasMany = {"Owners"})
public class Pets extends Entity {
    public String name;
    public int id_owner;

    public Pets(String name, int id_owner) {
        this.name = name;
        this.id_owner = id_owner;
        Field[] fields = this.getClass().getDeclaredFields();
        super.find().where("name", "=", this.name).and("id_owner", "=", this.id_owner);
        try {
            if (!super.executeQuery()) {
                System.out.println("INSERTION");
                super.insert(fields, new Object[]{this.name, this.id_owner}).executeInsert();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void owner() {
        this.hasMany();
    }
}
