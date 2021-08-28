package com.hao.common.constant;

/**
 * @Author hao
 * @create 2021/8/27 6:56 下午
 */
public class DealException extends BaseException {
  public DealException(int code, String msg) {
    super(code, msg);
  }
  
  public static DealException JACKSON_ERROR = new DealException(500301, "Jackson处理异常");
}
