package com.hao.confessionswall.backend.common.annotation;

import com.hao.confessionswall.backend.common.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {
  
  private final IUserService userService;
  
  public AccessInterceptor(IUserService userService) {
    this.userService = userService;
  }
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    if (handler instanceof HandlerMethod) {
      HandlerMethod hm = (HandlerMethod) handler;
      AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
      if (accessLimit == null) {
        return true;
      }
//      int seconds = accessLimit.seconds();
//      int maxCount = accessLimit.maxCount();
      boolean needLogin = accessLimit.needLogin();
      boolean needAuth = accessLimit.needAuth();
      if (needLogin) {
        return userService.authLogin(request.getParameter("openId"));
      }
      if (needAuth) {
        return userService.authRole(request.getParameter("openId"));
      }
      return false;
    }
    return true;
  }
}
