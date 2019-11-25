package threads;

/**
 * @ClassName Test
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-21 14:33
 * @Version 1.0
 **/
public class Test extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("听歌");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
//        test.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("啊啊啊");
        }
    }
}
