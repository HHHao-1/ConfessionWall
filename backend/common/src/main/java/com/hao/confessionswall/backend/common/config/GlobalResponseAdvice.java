package com.hao.confessionswall.backend.common.config;

import com.hao.confessionswall.backend.common.result.ApiResponse;
import org.springdoc.webmvc.api.OpenApiResource;
import org.springdoc.webmvc.ui.SwaggerWelcome;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author hao
 */
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {
  
  //这个方法表示对于哪些请求要执行beforeBodyWrite，返回true执行，返回false不执行
  @Override
  public boolean supports(MethodParameter returnType, Class converterType) {
    Class<?> clazz = returnType.getDeclaringClass();
    boolean res = clazz.equals(SwaggerWelcome.class) || clazz.equals(OpenApiResource.class);
    return !res;
  }
  
  //对于返回的对象如果不是最终对象ResponseResult，则选包装一下
  @Override
  public Object beforeBodyWrite(Object body,
                                MethodParameter returnType,
                                MediaType selectedContentType,
                                Class selectedConverterType,
                                ServerHttpRequest request,
                                ServerHttpResponse response) {
    
    //对于JSON类型的响应数据
    if (selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
      if (!(body instanceof ApiResponse)) {
        //如果Controller返回值body的数据类型不是Result，
        //就将body封装为AjaxResponse类型返回，总之要统一数据响应的类型
        return ApiResponse.success(body);
      }
      //将业务异常状态码赋值给HTTP状态码
      response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return body;
  }
}
