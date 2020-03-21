package Entity;

import database.connection.Database;
import database.querybuilder.QueryBuilder;
import orm.mapper.MapperInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Entity implements MapperInterface {
    private int id;
    private String createdAt;
    private String modifiedAt;

    public void findByID(int id) {

    }

    public void findAll() {

    }

    public void findBy(String field, String value) {

    }

    @Override
    public void insert(Field[] field, Object[] values) {
        String query = QueryBuilder.insertQueryBuilder(field, values);
//        Database db = Database.getInstance();
//        db.insertdata("INSERT INTO PET (name, id_owner) values (\"Paasu\", 3)");
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
    public void where() {

    }

    @Override
    public void findByID() {

    }
}
