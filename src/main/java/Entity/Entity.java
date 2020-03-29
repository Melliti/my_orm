package Entity;

import database.annotation.Relation;
import database.annotation.Table;
import database.connection.Database;
import database.core.Relations;
import database.querybuilder.QueryBuilder;
import orm.mapper.MapperInterface;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;

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
    public void insert(Field[] field, Object[] values) {
        Table table = this.getClass().getDeclaredAnnotation(Table.class);

        this.query = QueryBuilder.insertQueryBuilder(table.name(), field, values);
//        QueryBuilder.insertQueryBuilder(this, table.name(), field, values);
        Database db = Database.getInstance();
        db.insert(this.query);
//        return this;
    }

    @Override
    public Entity find() {
        Table table = this.getClass().getDeclaredAnnotation(Table.class);
        QueryBuilder.findAllQueryBuilder(this, table.name());
        Database db = Database.getInstance();
//        db.execute(this.query);
        return this;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void where(String field, String condition, String value) {
        QueryBuilder.where(this, field, condition, value);
        Database db = Database.getInstance();
        db.execute(this.query);

    }

    @Override
    public void findByID() {

    }

    protected void test() {
        Relation relation = this.getClass().getDeclaredAnnotation(Relation.class);
//        Relations rs = new Relations();
//        rs
        if (relation.hasOne().length > 0)
            Relations.getTable(Database.getInstance(), relation.hasOne());
        if (relation.hasMany().length > 0)
            Relations.getTable(Database.getInstance(), relation.hasMany());
        if (relation.hasAndBelongsToMany().length > 0)
            Relations.getTable(Database.getInstance(), relation.hasAndBelongsToMany());
        if (relation.belongsTo().length > 0)
            Relations.getTable(Database.getInstance(), relation.belongsTo());
        if (relation.belongsToMany().length > 0)
            Relations.getTable(Database.getInstance(), relation.belongsToMany());
        System.out.println(relation.belongsToMany()[0]);
    }
}
