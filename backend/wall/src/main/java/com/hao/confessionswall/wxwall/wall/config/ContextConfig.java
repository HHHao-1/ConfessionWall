package com.hao.confessionswall.wxwall.wall.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author hao
 * @create 2021/8/27 6:38 下午
 */
@Configuration
public class ContextConfig {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
  }
  
  public ObjectMapper jackson() {
    return new ObjectMapper();
  }
}
