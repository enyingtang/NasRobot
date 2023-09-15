package com.nasrobot.commons.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CookieUtils {

    public static void main(String[] args) {
        String s = "bid=cFpfJDBqYtE; _pk_id.100001.4cf6=b1d2f0f0235525c8.1693983235.; ll=\"118267\"; _vwo_uuid_v2=D690568391E26B6FD62EBF1BFC16197D4|7954ab8504774a08b8895d07bd8c82d1; douban-fav-remind=1; dbcl2=\"274433919:C8lcGSD0SGM\"; push_noty_num=0; push_doumail_num=0; ck=us9H; _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1694681951%2C%22https%3A%2F%2Fwww.google.com%2F%22%5D; _pk_ses.100001.4cf6=1; ap_v=0,6.0";
        Map<String, String> stringStringMap = CookieUtils.cookieStringToMap(s);

        String s1 = CookieUtils.cookieMapToString(stringStringMap);

        System.out.printf("" + s.equals(s1));
    }

    public static Map<String, String> cookieStringToMap(String cookieString) {
        if (!cookieString.contains("=")) {
            return new HashMap<>();
        }
        if (cookieString.contains(";")) {
            Map<String, String> cookieMap = new HashMap<>();
            for (String cookie : cookieString.split(";")) {
                String[] split = cookie.split("=");
                cookieMap.put(split[0], split[1]);
            }
            return cookieMap;
        } else {
            String[] split = cookieString.split("=");
            return new HashMap<>(Map.of(split[0], split[1]));
        }
    }

    public static String cookieMapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

}
