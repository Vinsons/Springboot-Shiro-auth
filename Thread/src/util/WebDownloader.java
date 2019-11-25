package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName WebDownloader
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-21 16:16
 * @Version 1.0
 **/
public class WebDownloader {
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("不合法的url");
        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
