package com.redis.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static Properties loadPropertiesFile(String name){
        Properties pro=new Properties();
        InputStream is=PropertyUtil.class.getClassLoader().getResourceAsStream(name);
        try {
            pro.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
    }
    public static String getProperty(String key){
       Properties p=loadPropertiesFile("redis.properties");
       return p.getProperty(key);
    }


    public static void main(String[] args) {
        System.out.println(getProperty("redis.host"));
    }

}
