package com.hao.confessionswall.backend.common.exception.constant;

/**
 * @Author hao
 * @create 2021/8/27 6:56 下午
 */
public class DealException extends BaseException {
  public DealException(int code, String msg) {
    super(code, msg);
  }
  
  public static DealException JACKSON_ERROR = new DealException(500301, "Jackson处理异常");
  public static DealException UP_LOAD_ERROR = new DealException(500302, "图片上传异常");
  public static DealException DATABASE_ERROR = new DealException(500303, "数据库操作异常");
}
