package com.hao.confessionswall.backend.image.controller;

import com.hao.confessionswall.backend.common.annotation.AccessLimit;
import com.hao.confessionswall.backend.common.utils.RedisOperator;
import com.hao.confessionswall.backend.image.service.IImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author hao
 * @create 2021/8/28 2:01 下午
 */

@Slf4j
@RestController
public class ImageController {
  private final IImageService imageService;
  
  public ImageController(IImageService imageService, RedisOperator redis) {
    this.imageService = imageService;
  }
  
  @GetMapping(value = "/file")
  public String file() {
    return "file";
  }
  
  @AccessLimit(needAuth = false)
  @PostMapping(value = "/UpWallImg")
  public String wallUpload(@RequestParam(value = "file") MultipartFile file, @RequestParam String sort, @RequestParam String openid) {
    return imageService.wallUpload(file, sort, openid);
  }
  
  @AccessLimit(needLogin = false)
  @PostMapping(value = "/UpGoodsImg")
  public String goodsUpload(@RequestParam(value = "file") MultipartFile file, @RequestParam String goodsName, @RequestParam String openid) {
    return imageService.goodsUpload(file, goodsName, openid);
  }
}
