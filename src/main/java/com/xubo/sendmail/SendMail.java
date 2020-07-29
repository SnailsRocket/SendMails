package com.xubo.sendmail;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @Author: Xubo
 * @Date: 2020/7/29 20:25
 */
public class SendMail {
    private static Map<String, Long> map = new HashMap<String, Long>();

    private static final String str = "";
    public static Calendar calendar = Calendar.getInstance();

    public static Date date = new Date();
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");


    public static void main(String[] args) {
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)-30);
        String path = "E:\\MailSendFile";
        int[] arr ={1,5,8,9};
        getFile(path);
        Set<String> set = map.keySet();
        for (String fileName : set) {
            System.out.println(sdf.format(map.get(fileName))+"\n"+fileName+"\n");

        }
        map.clear();

    }
    //    TODO 这里用策略模式和工厂模式 替换掉大量的 if-else
    public static void getFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        System.out.println(files.length);
        if (files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
//                    是目录 递归
                    getFile(f.getAbsolutePath());
                } else {
                    if (f.lastModified()>calendar.getTimeInMillis() && f.lastModified()<date.getTime()) {
                        try {
                            if (f.createNewFile()) {
//                            create
                                map.put(f.getAbsolutePath()+"\t\tcreate file",f.lastModified());
                            } else {
//                            update
                                map.put(f.getAbsolutePath()+"\t\tupdate file",f.lastModified());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("文件不存在");
                        }
                    }
                }
            }
        }
    }

    public static void sendMail() {

    }
}
