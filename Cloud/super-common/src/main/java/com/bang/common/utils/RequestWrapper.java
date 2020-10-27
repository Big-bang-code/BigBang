package com.bang.common.utils;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 从请求体中获取参数请求包装类
 *
 * 当请求过来时，该类将获取到其中的内容
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    //将流保存下来
    private byte[] requestBody;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        requestBody = StreamUtils.copyToByteArray(request.getInputStream());
    }

    public void setRequestBody(byte[] requestBody){
        this.requestBody = requestBody;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
        return  new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), StandardCharsets.UTF_8));
    }

    /**
     * 读取请求体中内容
     * @param request
     * @return
     */
    public static String ReadAsChars(ServletRequest request){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try{
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String getParameter(String name){
        String value = super.getParameter(name);
        //处理中文乱码问题
        if (value != null) {
            value = StringUtils.replacer(value);
        }
        return value;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> valueMap = super.getParameterMap();
        Iterator iterator = valueMap.entrySet().iterator();
        Map<String, String[]> resMap = new HashMap<>();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iterator.next();
            String key = entry.getKey();
            String[] value_arr = entry.getValue();
            handlerValues(value_arr);
            resMap.put(key, value_arr);
        }
        return resMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            handlerValues(arr);
        }
        return arr;
    }

    /**
     * 处理value值乱码
     * @param arr
     */
    private static void handlerValues(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String value = arr[i];
            //处理中文乱码问题
            if (value != null) {
                value = StringUtils.replacer(value);
            }
            arr[i] = value;
        }
    }

}
