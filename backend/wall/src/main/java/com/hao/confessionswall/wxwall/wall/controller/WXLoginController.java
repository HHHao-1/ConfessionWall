package com.hao.confessionswall.wxwall.wall.controller;

import com.hao.confessionswall.wxwall.common.model.SysUser;
import com.hao.confessionswall.wxwall.wall.service.IWXLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hao
 */
@RestController
public class WXLoginController {
  
  private final IWXLoginService wxLoginService;
  private final Test test;
  
  public WXLoginController(IWXLoginService wxLoginService, Test test) {
    this.wxLoginService = wxLoginService;
    this.test = test;
  }
  
  @PostMapping("/wxLogin")
  public SysUser wxLogin(String code) {
    return wxLoginService.wxLogin(code);
  }
  
  @GetMapping("/eu")
  public String eu() {
    return test.test();
  }
  
}
