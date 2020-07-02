package Entity;

import database.annotation.Relation;
import database.annotation.Table;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

@Table(name = "Pet")
@Relation(hasOne = {"Owners"})
public class Pets extends Entity {
    public String name;
    public int id_owner;

    public int getId_owner() {
        return this.id_owner;
    }

    public Pets(String name, int id_owner) throws SQLException {
        this.name = name;
        this.id_owner = id_owner;
        Field[] fields = this.getClass().getDeclaredFields();
        super.find().where("name", "=", this.name).and("id_owner", "=", this.id_owner);
        try {
            if (!super.executeQuery()) {
                super.insert(fields, new Object[]{this.name, this.id_owner}).executeInsert();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Owners owners() {
        Owners owner = null;
        if (this.hasOne(this.getId_owner(), "Owners"))
            owner = Owners.find(this.getId_owner());
        return owner;
    }
}
