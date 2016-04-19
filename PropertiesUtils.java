package com.hanshow.fresh.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by tachao on 16-3-22.
 */
public class PropertiesUtils {

    private static InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("META-INF/conf/config.properties");
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(is));
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取key对应的String字符串
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        return prop.getProperty(key);
    }

    /**
     * 获取key对应的String字符串,若未获取到值,则使用defaultVal作为返回值
     *
     * @param key
     * @param defaultVal
     * @return
     */
    public static String getString(String key, String defaultVal) {
        String value = prop.getProperty(key);
        return value != null ? value : defaultVal;
    }

    /**
     * 获取key对应的int型数字
     *
     * @param key
     * @return
     */
    public static int getInt(String key) {
        String s = prop.getProperty(key);
        return Integer.parseInt(s);
    }

    /**
     * 获取key对应的int型数字,若未获取到值,则使用defaultVal作为返回值
     *
     * @param key
     * @param defaultVal
     * @return
     */
    public static int getInt(String key, int defaultVal) {
        String s = prop.getProperty(key);
        return s != null ? Integer.parseInt(s) : defaultVal;
    }

    /**
     * 获取key对应的Boolean型值
     *
     * @param key
     * @return
     */
    public static Boolean getBoolean(String key) {
        String value = prop.getProperty(key);
        return Boolean.parseBoolean(value);
    }

    /**
     * 获取key对应的Boolean型值,若未获取到值,则使用defaultVal作为返回值
     *
     * @param key
     * @param defaultVal
     * @return
     */
    public static Boolean getBoolean(String key, Boolean defaultVal) {
        String value = prop.getProperty(key);
        return Boolean.valueOf(value != null ? Boolean.parseBoolean(value) : defaultVal.booleanValue());
    }
}
