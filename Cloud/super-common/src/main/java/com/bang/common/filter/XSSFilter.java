package com.bang.common.filter;


import org.apache.commons.collections.MapUtils;
import javax.servlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * 过滤器：
 *
 */
public class XSSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     * @param request
     * @param response
     * @param chain  Filter是一个实现了特殊接口的Java类，与servlet类似，
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

    //将容易引起xss漏洞的半角字符直接替换成全角字符 在保证不删除数据的情况下保存
    private static String xssEncode(String value){
        if (value == null || value.isEmpty()) {
            return value;
        }
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\"'][\\s]*javascript:(.*)[\"']", "\"\"");
        value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
        value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
        value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
        value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
        return value;
    }

    //递归替换xss内容
    private void recursionReplaceXssValue(Map<String, Object> data) {
        if (MapUtils.isEmpty(data)) {
            return;
        }
        data.forEach((k, v) -> {
            if (Objects.isNull(v)) {
                return;
            }
            if (v instanceof String) {
                data.put(k, xssEncode((String) v));
            } else if (v instanceof Map) {
                recursionReplaceXssValue((Map) v);
            }
        });
    }

}
