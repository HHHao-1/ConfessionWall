package com.hao.confessionswall.wxwall.image;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hao
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.hao.confessionswall.wxwall"})
@MapperScan({"com.hao.confessionswall.wxwall.common.dao"})
public class ImageApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ImageApplication.class, args);
  }
  
}
