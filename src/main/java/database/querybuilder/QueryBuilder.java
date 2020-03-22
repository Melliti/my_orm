package database.querybuilder;

import java.lang.reflect.Field;

public class QueryBuilder {
    public static String insertQueryBuilder(String table, Field[] fields, Object[] values) {
        int it = 0;
        String query = "INSERT INTO ";
        query += table + " (";
        for (Field field: fields) {
            query += field.getName();
            it++;
            if (it != fields.length)
                query += ", ";
        }
        it = 0;
        query += ") VALUES (";
        for (Object value: values) {
            query += value;
            it++;
            if (it != values.length)
                query += ", ";
        }
        query += ")";
        System.out.println(query);
        return null;
    }

    public static String findAllQueryBuilder(String table) {
        
    }
}
