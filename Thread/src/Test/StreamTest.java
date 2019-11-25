package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-25 9:33
 * @Version 1.0
 **/
public class StreamTest {
    static class User {
        private Integer id;
        private String Name;
        private String Pwd;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPwd() {
            return Pwd;
        }

        public void setPwd(String pwd) {
            Pwd = pwd;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public User() {
        }

        public User(Integer id, String name, String pwd) {
            this.id = id;
            Name = name;
            Pwd = pwd;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", Name='" + Name + '\'' +
                    ", Pwd='" + Pwd + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName(String.valueOf(random.nextInt(12)));
            user.setPwd(String.valueOf(random.nextInt(12)));
            user.setId(random.nextInt(12));
            list.add(user);
        }
        list = list.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }
}
