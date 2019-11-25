package threads;

import com.sun.deploy.util.StringUtils;
import util.WebDownloader;

/**
 * @ClassName Download
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-21 16:14
 * @Version 1.0
 **/
public class Download implements Runnable {
    private String url;
    private String name;

    public Download(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载的内容是："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        String name = "立春.jpg";
        String name1 = "雨水.jpg";
        String name2 = "下雨天儿.jpg";
        Download we = new Download("http://img95.699pic.com/photo/50078/8115.jpg_wh300.jpg",name);
        Download we1 = new Download("http://img95.699pic.com/photo/50046/5245.jpg_wh300.jpg",name1);
        Download we2 = new Download("http://img95.699pic.com/photo/50052/6575.jpg_wh300.jpg",name2);
        new Thread(we,name).start();
        new Thread(we1,name1).start();
        new Thread(we2,name2).start();
    }
}
