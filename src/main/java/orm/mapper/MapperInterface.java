package orm.mapper;

import java.lang.reflect.Field;

public interface MapperInterface {
    public void insert(Field[] field, Object[] values);
    public void find();
    public void update();
    public void delete();

    public void where();
    public void findByID();
}
