package com.hao.confessionswall.wxwall.image.service.impl;

import com.hao.confessionswall.wxwall.common.exception.CustomException;
import com.hao.confessionswall.wxwall.common.exception.constant.DealException;
import com.hao.confessionswall.wxwall.image.service.IImageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @Author hao
 * @create 2021/8/28 5:24 下午
 */
@Service
@ConfigurationProperties(prefix = "img")
public class ImageServiceImpl implements IImageService {
  
  private String absoluteUrlWall;
  private String absoluteUrlGoods;
  
  @Override
  public String wallUpload(MultipartFile file, String sort, String openid) {
    if (file.isEmpty() || file.getOriginalFilename() == null) {
      throw new CustomException(DealException.UP_LOAD_ERROR);
    }
    String fileName = file.getOriginalFilename();
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    if (!StringUtils.isEmpty(sort)) {
      wallImages(file, sort, suffixName);
      return "告白墙图片上传成功";
    }
    throw new CustomException(DealException.UP_LOAD_ERROR);
  }
  
  @Override
  public String goodsUpload(MultipartFile file, String goodsName, String openid) {
    if (file.isEmpty() || file.getOriginalFilename() == null) {
      throw new CustomException(DealException.UP_LOAD_ERROR);
    }
    String fileName = file.getOriginalFilename();
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    if (!StringUtils.isEmpty(goodsName)) {
      goodsImages(file, goodsName, suffixName);
      return "商品图片上传成功";
    }
    throw new CustomException(DealException.UP_LOAD_ERROR);
  }
  
  private void goodsImages(MultipartFile file, String goodsName, String suffixName) {
    String storagePath = absoluteUrlGoods + goodsName;
    String storageName = UUID.randomUUID() + suffixName;
    String path = storagePath + storageName;
    imgTransfer(file, path);
  }
  
  private void wallImages(MultipartFile file, String sort, String suffixName) {
    String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH").format(LocalDateTime.now());
    String date = dateTime.substring(0, dateTime.indexOf(":"));
    String time = dateTime.substring(dateTime.indexOf(":") + 1);
    int number = Integer.parseInt(time);
    if (number < 12) {
      time = "am";
    } else {
      time = "pm";
    }
    String storagePath = absoluteUrlWall + date + "/" + time + "/" + sort;
    String storageName = UUID.randomUUID() + suffixName;
    String path = storagePath + storageName;
    imgTransfer(file, path);
  }
  
  private void imgTransfer(MultipartFile file, String path) {
    File dest = new File(path);
    if (!dest.exists()) {
      try {
        dest.mkdirs();
        file.transferTo(dest);
      } catch (IOException e) {
        throw new CustomException(DealException.UP_LOAD_ERROR);
      }
    }
  }
}
