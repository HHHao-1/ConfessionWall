package com.hao.confessionwall.wxwall.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hao
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
  
}
