package threads;

import java.lang.annotation.Annotation;

/**
 * @ClassName Demo01
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-22 13:28
 * @Version 1.0
 **/
public class Demo01 {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("threads.Demo02");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation:annotations){
                System.out.println(annotation);
            }
            Annotation annotation = clazz.getAnnotation(Test01.class);
            System.out.println(annotation);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
