package com.hao.confessionswall.backend.common.exception.constant;

/**
 * @Author hao
 * @create 2021/8/26 7:32 下午
 */
public class CommonException extends BaseException {
  public CommonException(int code, String msg) {
    super(code, msg);
  }
  
  public static CommonException SERVER_ERROR = new CommonException(500100, "服务端异常");
  public static CommonException BIND_ERROR = new CommonException(500101, "参数校验异常");
  public static CommonException REQUEST_ILLEGAL = new CommonException(500102, "请求非法");
  public static CommonException ACCESS_LIMIT_REACHED = new CommonException(500104, "访问频繁！");
}
