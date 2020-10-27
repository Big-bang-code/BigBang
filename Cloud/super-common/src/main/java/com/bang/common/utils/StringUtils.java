package com.bang.common.utils;

import java.net.URLDecoder;

public class StringUtils {

    /**
     * 对于请求内容解码
     * @param data
     * @return
     */
    public static String replacer(String data) {
        try {
            data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            data = data.replaceAll("\\+", "%2B");
            data = URLDecoder.decode(data, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
