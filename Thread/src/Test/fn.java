package Test;

import java.util.Scanner;

/**
 * @ClassName fn
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-22 16:28
 * @Version 1.0
 **/
public class fn {
    static int f(int n) {
        if (n==0||n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        return (n-1)*(f(n-1)+f(n-2));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("人数是：");
        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int f = f(p);
            System.out.println(p+"个人的时候有："+f+"坐法");
        }
        scanner.close();
    }

}
