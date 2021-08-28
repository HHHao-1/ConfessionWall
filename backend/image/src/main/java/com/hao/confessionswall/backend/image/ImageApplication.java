package com.hao.confessionswall.backend.image;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hao
 */
@SpringBootApplication(scanBasePackages = {"com.hao.confessionswall.backend"})
@MapperScan({"com.hao.confessionswall.backend.common.dao"})
public class ImageApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ImageApplication.class, args);
  }
  
}
