package com.bang.common.utils;

import com.bang.common.entity.ApiRequest;
import com.bang.common.entity.ApiResponse;
import com.bang.common.enums.Result;
import com.bang.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@Slf4j
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;


//    public <I, O> O sendAndGetResponseData(ApiRequest<I> apiRequest, ParameterizedTypeReference<ApiResponse<O>> typeRef, String url) {
//
//        HttpEntity<ApiRequest<I>> httpEntity = new HttpEntity<>(apiRequest);
//        ResponseEntity<ApiResponse<O>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeRef);
//        if (Objects.isNull(responseEntity)) {
//            log.error("调用远程服务失败,responseEntity为null,url:{}", url);
//            throw new ApiException(Result.SYSTEM_ERROR);
//        }
//        ApiResponse<O> apiResponse = responseEntity.getBody();
//        if (Objects.isNull(apiResponse)) {
//            log.error("调用远程服务失败,url:{}", url);
//            throw new ApiException(Result.SYSTEM_ERROR);
//        } else if (apiResponse.getCode() != Result.SUCCESS.getCode()) {
//            log.error("调用的远程服务器出错了，url：{},{}", url,apiResponse);
//            throw new ApiException(Result.SYSTEM_ERROR);
//        }
//        return apiResponse.getData();
//
//    }
}
