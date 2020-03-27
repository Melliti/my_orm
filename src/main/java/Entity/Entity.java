package Entity;

import database.annotation.Table;
import database.connection.Database;
import database.querybuilder.QueryBuilder;
import orm.mapper.MapperInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Entity implements MapperInterface {
    private int id;
    private String createdAt;
    private String modifiedAt;
    public String query;

    public void findByID(int id) {

    }

    public void findAll() {

    }

    public void findBy(String field, String value) {

    }

    @Override
//    public void insert(Field[] field, Object[] values) {
    public Entity insert(Field[] field, Object[] values) {
        Table table = this.getClass().getDeclaredAnnotation(Table.class);

        this.query = QueryBuilder.insertQueryBuilder(table.name(), field, values);
//        QueryBuilder.insertQueryBuilder(this, table.name(), field, values);
//        System.out.println("TEST");
//        System.out.println(query);
        Database db = Database.getInstance();
        db.insert(this.query);
        return this;
    }

    @Override
    public void find() {
        Database db = Database.getInstance();
        db.execute("SELECT * FROM pet");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void where(String field, String conditon, String value) {
        this.query = QueryBuilder.where(this.query, field, conditon, value);
    }

    @Override
    public void findByID() {

    }
}
