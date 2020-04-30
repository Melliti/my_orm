package orm.mapper;

import Entity.Entity;

import java.lang.reflect.Field;

public interface MapperInterface {
//    public void insert(Field[] field, Object[] values);
    public Entity insert(Field[] field, Object[] values);
    public Entity find();
    public void update();
    public void delete();

    public Entity where(String field, String condition, String value);
    public Entity where(String field, String condition, int value);
    public Entity and(String field, String condition, String value);
    public Entity and(String field, String condition, int value);
    public void findByID();
}
