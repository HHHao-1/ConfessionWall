package com.hao.confessionswall.wxwall.common.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao.confessionswall.wxwall.common.constant.CommonType;
import com.hao.confessionswall.wxwall.common.dao.SysUserDao;
import com.hao.confessionswall.wxwall.common.exception.CustomException;
import com.hao.confessionswall.wxwall.common.exception.constant.DealException;
import com.hao.confessionswall.wxwall.common.exception.constant.SafeException;
import com.hao.confessionswall.wxwall.common.model.SysUser;
import com.hao.confessionswall.wxwall.common.rediskey.UserKey;
import com.hao.confessionswall.wxwall.common.service.IUserService;
import com.hao.confessionswall.wxwall.common.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @create 2021/8/28 11:50 下午
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
  private final SysUserDao sysUserDao;
  private final RedisOperator redis;
  private final ObjectMapper jackson;
  
  public UserServiceImpl(SysUserDao sysUserDao, RedisOperator redis, ObjectMapper jackson) {
    this.sysUserDao = sysUserDao;
    this.redis = redis;
    this.jackson = jackson;
  }
  
  @Override
  public SysUser login(String openId) {
    Map<Object, Object> map = redis.hgetall(UserKey.login.getPrefix() + openId);
    if (map.isEmpty()) {
      try {
        SysUser sysUser = mysqlToRedis(openId);
        return sysUser;
      } catch (Exception exception) {
        log.error(DealException.DATABASE_ERROR.getMsg());
        throw new CustomException(DealException.DATABASE_ERROR);
      }
    } else {
      return jackson.convertValue(map, SysUser.class);
    }
  }
  
  @Override
  public boolean authRole(String openId) {
    Map<Object, Object> map = redis.hgetall(UserKey.login.getPrefix() + openId);
    if (map.isEmpty()) {
      throw new CustomException(SafeException.SESSION_ERROR);
    } else {
      Integer role = (Integer) map.get("role");
      if (role == 0) {
        throw new CustomException(SafeException.USER_AUTH_ERROR);
      }
    }
    return true;
  }
  
  @Override
  public boolean authLogin(String openId) {
    Map<Object, Object> map = redis.hgetall(UserKey.login.getPrefix() + openId);
    if (map.isEmpty()) {
      throw new CustomException(SafeException.SESSION_ERROR);
    }
    return true;
  }
  
  private SysUser mysqlToRedis(String openId) {
    sysUserDao.setUser(openId);
    SysUser sysUser = sysUserDao.getUser(openId);
    if (sysUser.getEnabled() == 0) {
      throw new CustomException(SafeException.USER_ENABLED_ERROR);
    }
    Map<String, Object> map = new HashMap<>(4);
    map.put("userId", sysUser.getId());
    map.put("openId", sysUser.getOpenId());
    map.put("enabled", sysUser.getEnabled());
    map.put("role", sysUser.getRole());
    redis.hsetAll(UserKey.login.getPrefix() + openId, map);
    redis.expire(UserKey.login.getPrefix() + openId, 15L * CommonType.ONE_DAY_MILLIS);
    return sysUser;
  }
}
