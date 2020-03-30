package database.core;

import database.annotation.Relation;
import database.connection.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Relations {
    public static boolean getTable(Database db, String[] tables) {
        ResultSet rs = db.tableList();
        try {
            while (rs.next()) {
                for (String table: tables) {
                    if (rs.getString(1).equals(table))
                        return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}