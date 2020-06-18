package Entity;

import database.annotation.Relation;
import database.annotation.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

@Table(name = "owners")
@Relation(hasMany = {"Owners", "test"})
public class Owners extends Entity {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int id;
    public String name;

    private Owners (ResultSet rs) throws SQLException {
        try {
            if (rs.next()) {
                this.id = rs.getInt("id");
                this.name = rs.getString("name");
            } else {
                throw new SQLException("Error: Id provided for the Owner Entity doesn't exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Owners find(int id) {
        ResultSet rs = Entity.findByID(Owners.class.getSimpleName(), id);
        try {
            return new Owners(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
