package threads;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE,ElementType.METHOD}) //限定修饰类型
@Retention(RetentionPolicy.RUNTIME)
public @interface Test01 {
    String value();
}
