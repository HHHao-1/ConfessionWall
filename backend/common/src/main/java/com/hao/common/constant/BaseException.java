package com.hao.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author hao
 * @create 2021/8/25 5:33 下午
 */
@Getter
@AllArgsConstructor
public class BaseException {
  
  private final int code;
  private final String msg;
  
  public static BaseException SERVER_ERROR = new BaseException(500100, "服务端异常");
  public static BaseException BIND_ERROR = new BaseException(500101, "参数校验异常");
  public static BaseException REQUEST_ILLEGAL = new BaseException(500102, "请求非法");
  public static BaseException ACCESS_LIMIT_REACHED = new BaseException(500104, "访问频繁！");
}
