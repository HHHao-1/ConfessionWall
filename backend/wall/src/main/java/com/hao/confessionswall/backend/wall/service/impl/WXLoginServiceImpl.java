package com.hao.confessionswall.backend.wall.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao.confessionswall.backend.common.exception.CustomException;
import com.hao.confessionswall.backend.common.exception.constant.DealException;
import com.hao.confessionswall.backend.common.model.SysUser;
import com.hao.confessionswall.backend.common.service.IUserService;
import com.hao.confessionswall.backend.common.utils.RedisOperator;
import com.hao.confessionswall.backend.wall.model.WXSessionModel;
import com.hao.confessionswall.backend.wall.service.IWXLoginService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @create 2021/8/28 8:49 下午
 */
@Service
@ConfigurationProperties(prefix = "wx")
public class WXLoginServiceImpl implements IWXLoginService {
  private String appid;
  private String secret;
  
  private final RestTemplate restTemplate;
  private final ObjectMapper jackson;
  private final RedisOperator redis;
  private final IUserService userService;
  
  public WXLoginServiceImpl(String appid, RestTemplate restTemplate, ObjectMapper jackson, RedisOperator redis, IUserService userService) {
    this.restTemplate = restTemplate;
    this.jackson = jackson;
    this.redis = redis;
    this.userService = userService;
  }
  
  @Override
  public SysUser wxLogin(String code) {
    String url = "https://api.weixin.qq.com/sns/jscode2session";
    Map<String, String> param = new HashMap<>();
    param.put("appid", appid);
    param.put("secret", secret);
    param.put("js_code", code);
    param.put("grant_type", "authorization_code");
    String wxResult = restTemplate.getForObject(url, String.class, param);
    WXSessionModel model;
    try {
      model = jackson.readValue(wxResult, WXSessionModel.class);
    } catch (Exception exception) {
      throw new CustomException(DealException.JACKSON_ERROR);
    }
    // 存入openid到redis
    return userService.login(model.getOpenid());
  }
}
