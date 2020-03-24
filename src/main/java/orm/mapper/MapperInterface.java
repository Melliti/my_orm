package orm.mapper;

import Entity.Entity;

import java.lang.reflect.Field;

public interface MapperInterface {
//    public void insert(Field[] field, Object[] values);
    public Entity insert(Field[] field, Object[] values);
    public void find();
    public void update();
    public void delete();

    public void where(String field, String condition, String value);
    public void findByID();
}
