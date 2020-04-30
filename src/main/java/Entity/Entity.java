package Entity;

import database.annotation.Table;
import database.connection.Database;
import database.querybuilder.QueryBuilder;
import orm.mapper.MapperInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Entity implements MapperInterface {
    private int id;
    private String createdAt;
    private String modifiedAt;
    public String query;

    public static void findByID(int id) {

    }

    public void findAll() {

    }

    public void findBy(String field, String value) {

    }

    protected Boolean executeQuery() throws SQLException {
        Database db = Database.getInstance();
        return db.execute(this.query).next();
    }

    protected Boolean executeInsert() throws SQLException {
        Database db = Database.getInstance();
//        return db.insert(this.query);
        db.insert(this.query);
        return true;
    }

    @Override
//    public void insert(Field[] field, Object[] values) {
    public Entity insert(Field[] field, Object[] values) {
        Table table = this.getClass().getDeclaredAnnotation(Table.class);

        this.query = QueryBuilder.insertQueryBuilder(table.name(), field, values);
        return this;
    }

    @Override
    public Entity find() {
//        Database db = Database.getInstance();
//        db.execute("SELECT * FROM pet");
        Table table = this.getClass().getDeclaredAnnotation(Table.class);

        this.query = QueryBuilder.findAllQueryBuilder(table.name());
        return this;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Entity where(String field, String condition, String value) {
        this.query = QueryBuilder.where(this.query, field, condition, value);
        return this;
    }

    @Override
    public Entity where(String field, String condition, int value) {
        this.query = QueryBuilder.where(this.query, field, condition, value);
        return this;
    }

    @Override
    public Entity and(String field, String condition, String value) {
        this.query = QueryBuilder.and(this.query, field, condition, value);
        System.out.println("[AND] -- " + this.query);
        return this;
    }

    @Override
    public Entity and(String field, String condition, int value) {
        this.query = QueryBuilder.and(this.query, field, condition, value);
        System.out.println("[AND] -- " + this.query);
        return this;
    }

    @Override
    public void findByID() {

    }

    protected void hasMany() {
        System.out.println("hello");
    }
}
