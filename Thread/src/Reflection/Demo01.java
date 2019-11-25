package Reflection;

import java.lang.reflect.Field;

/**
 * @ClassName Demo01
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-22 14:30
 * @Version 1.0
 **/
public class Demo01 {

    public static void main(String[] args) {
        String path = "Reflection.User";
        try {
            Class<?> clazz = Class.forName(path);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field :fields){
                System.out.println(field);

            }
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
