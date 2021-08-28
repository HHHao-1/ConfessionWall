package com.hao.confessionswall.backend.common.config;


import com.hao.confessionswall.backend.common.exception.CustomException;
import com.hao.confessionswall.backend.common.exception.constant.BaseException;
import com.hao.confessionswall.backend.common.exception.constant.CommonException;
import com.hao.confessionswall.backend.common.result.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hao
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody
  @ExceptionHandler(CustomException.class)
  public ApiResponse<BaseException> customerException(CustomException e) {
    return ApiResponse.error(e.getException());
  }
  
  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ApiResponse<BaseException> unfoundException() {
    return ApiResponse.error(CommonException.SERVER_ERROR);
  }
}