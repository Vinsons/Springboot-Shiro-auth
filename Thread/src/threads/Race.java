package threads;

/**
 * @ClassName Race
 * @Description  龟兔赛跑
 * @Author 黄文聪
 * @Date 2019-11-21 15:53
 * @Version 1.0
 **/
public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int step = 1; step <= 100; step++) {
            String role= Thread.currentThread().getName();
            //随机生成0到100的随机整数
            int steps =(int)(Math.random()*101);
            System.out.println("步数-->"+steps);
            if (role.equals("兔子")&&steps==step){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + step);
            boolean flag = gameOver(step);
            if (flag){
                System.out.println("比赛结束");
                break;
            }
        }

    }

    private boolean gameOver(int step) {
        if (null != winner) {
            return true;
        }
        if (100 == step) {
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是：" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
