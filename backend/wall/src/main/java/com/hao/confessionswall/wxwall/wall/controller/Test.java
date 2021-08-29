package com.hao.confessionswall.wxwall.wall.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author hao
 * @create 2021/8/29 6:10 下午
 */
@FeignClient("WXWALL-IMAGE")
public interface Test {
  
  @GetMapping(value = "wxwall/image/file")
  String test();
  
}