package com.hao.common.controller;

import com.hao.common.TemporaryModel;
import com.hao.common.constant.SafeException;
import com.hao.common.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hao
 * @create 2021/8/25 7:38 下午
 */
@RestController
public class TestController {
  @GetMapping("/test1")
  public String a() {
    throw new CustomException(SafeException.SESSION_ERROR);
  }
  
  @GetMapping("/test2")
  public TemporaryModel b() {
    return TemporaryModel.of("1").setAge(1);
  }
}
