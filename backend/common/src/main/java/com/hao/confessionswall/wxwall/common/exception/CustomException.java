package com.hao.confessionswall.wxwall.common.exception;

import com.hao.confessionswall.wxwall.common.exception.constant.BaseException;

/**
 * @author hao
 */
public class CustomException extends RuntimeException {
  
  private static final long serialVersionUID = 3170546969613021650L;
  
  private final BaseException baseException;
  
  public CustomException(BaseException exceptionType) {
    super(exceptionType.getMsg());
    this.baseException = exceptionType;
  }
  
  public BaseException getException() {
    return baseException;
  }
  
}
