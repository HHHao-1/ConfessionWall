package com.hao.confessionswall.backend.image.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author hao
 * @create 2021/8/28 5:22 下午
 */
public interface IImageService {
  /***
   * 上传表白墙照片
   * @param file
   * @param sort
   * @return
   */
  String wallUpload(MultipartFile file, String sort, String openid);
  
  String goodsUpload(MultipartFile file, String goodsName, String openid);
}
