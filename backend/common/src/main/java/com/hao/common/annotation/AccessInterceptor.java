//package com.hao.common.annotation;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class AccessInterceptor extends HandlerInterceptorAdapter {
//
//
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//    if (handler instanceof HandlerMethod) {
//      HandlerMethod hm = (HandlerMethod) handler;
//      AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
//      if (accessLimit == null) {
//        return true;
//      }
//      int seconds = accessLimit.seconds();
//      int maxCount = accessLimit.maxCount();
//      boolean needLogin = accessLimit.needLogin();
//      return false;
//    }
//    return true;
//  }
//}
