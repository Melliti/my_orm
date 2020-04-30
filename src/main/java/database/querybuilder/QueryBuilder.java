package database.querybuilder;

import Entity.Entity;

import java.lang.reflect.Field;

public class QueryBuilder {
    public static Entity insertQueryBuilder(Entity entity, String table, Field[] fields, Object[] values) {
        int it = 0;
        entity.query = "INSERT INTO ";
        entity.query += table + " (";
        for (Field field: fields) {
            entity.query += field.getName();
            it++;
            if (it != fields.length)
                entity.query += ", ";
        }
        it = 0;
        entity.query += ") VALUES (";
        for (Object value: values) {
            entity.query += value;
            it++;
            if (it != values.length)
                entity.query += ", ";
        }
        entity.query += ")";
        System.out.println(entity.query);
        return entity;
    }

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
            if (value instanceof String)
                query += "'" + value + "'";
            else
                query += value;
            it++;
            if (it != values.length)
                query += ", ";
        }
        query += ")";
        return query;
    }

    public static String findAllQueryBuilder(String table) {
        return "SELECT * FROM " + table;
    }

    public static String where(String query, String field, String condition, String value) {
        query += " WHERE " + field + " ";
        query += condition + " \'" + value + "\'";
        return query;
    }

    public static String where(String query, String field, String condition, int value) {
        query += " WHERE " + field + " ";
        query += condition + " " + value;
        return query;
    }

    public static String and(String query, String field, String condition, String value) {
        query += " AND " + field + " ";
        query += condition + " \'" + value + "\'";
        return query;
    }

    public static String and(String query, String field, String condition, int value) {
        query += " AND " + field + " ";
        query += condition + " " + value;
        return query;
    }

}
