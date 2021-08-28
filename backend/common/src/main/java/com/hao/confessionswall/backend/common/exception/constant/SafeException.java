package com.hao.confessionswall.backend.common.exception.constant;

/**
 * @Author hao
 * @create 2021/8/25 5:34 下午
 */
public class SafeException extends BaseException {
  public SafeException(int code, String msg) {
    super(code, msg);
  }
  
  public static SafeException SESSION_ERROR = new SafeException(500201, "Session不存在或者已经失效");
  public static SafeException USER_AUTH_ERROR = new SafeException(500202, "您没有权限访问资源！");
  public static SafeException USER_ENABLED_ERROR = new SafeException(500203, "您的用户已被禁用！");
  public static SafeException PASSWORD_EMPTY = new SafeException(500211, "登录密码不能为空");
  public static SafeException MOBILE_EMPTY = new SafeException(500212, "手机号不能为空");
  public static SafeException MOBILE_ERROR = new SafeException(500213, "手机号格式错误");
  public static SafeException MOBILE_NOT_EXIST = new SafeException(500214, "手机号不存在");
  public static SafeException PASSWORD_ERROR = new SafeException(500215, "密码错误");
}
