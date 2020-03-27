package database.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Relation {
    String[] hasOne() default {};
    String[] hasMany() default {};
    String[] hasAndBelongsToMany() default {};
    String[] belongsTo() default {};
    String[] belongsToMany() default {};
}
