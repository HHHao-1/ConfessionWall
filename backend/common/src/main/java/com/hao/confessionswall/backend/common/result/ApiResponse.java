package com.hao.confessionswall.backend.common.result;

import com.hao.confessionswall.backend.common.exception.constant.BaseException;
import lombok.Data;

/**
 * 接口数据请求统一响应数据结构
 *
 * @author hao
 */
@Data
public class ApiResponse<T> {
  
  public static final int SUCCESS_CODE = 200;
  public static final String SUCCESS_MSG = "success";
  
  private int code;
  private String msg;
  private T data;
  
  private ApiResponse(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
  
  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<T>(SUCCESS_CODE, SUCCESS_MSG, data);
  }
  
  public static <T> ApiResponse<T> error(BaseException exceptionType) {
    return new ApiResponse<T>(exceptionType.getCode(), exceptionType.getMsg(), null);
  }
}