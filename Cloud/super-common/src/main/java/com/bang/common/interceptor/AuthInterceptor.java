package com.bang.common.interceptor;

import com.bang.common.utils.RequestWrapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * HandlerInterceptorAdapter:使用该适配器来实现自己的拦截器。可以拦截所有的请求并作相应的处理
 * 在HandlerInterceptorAdapter中主要提供了以下的方法：
 *      preHandle：在方法被调用前执行。在该方法中可以做类似校验的功能。如果返回true，则继续调用下一个拦截器。如果返回false，则中断执行，也就是说我们想调用的方法 不会被执行，但是你可以修改response为你想要的响应。
 *      postHandle：在方法执行后调用。
 *      afterCompletion：在整个请求处理完毕后进行回调，也就是说视图渲染完毕或者调用方已经拿到响应。
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 就像上方写的，在方法被调用前执行
     * 可以用来验证用户和用户的功能权限
     * @param request
     * @param response
     * @param handler
     * @return
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        ServletRequest requestWrapper = null;

        if(request instanceof HttpServletRequest){
            requestWrapper = new RequestWrapper((HttpServletRequest) request);
            if (restTemplate == null){
                // 拦截器中无法自动注入spring bean，autowired的对象是null
                BeanFactory factory = WebApplicationContextUtils
                        .getRequiredWebApplicationContext(requestWrapper.getServletContext());
                restTemplate = (RestTemplate) factory.getBean("restTemplate");
            }
            String requestBody = RequestWrapper.ReadAsChars(requestWrapper);
        }


        return false;
    }


}
