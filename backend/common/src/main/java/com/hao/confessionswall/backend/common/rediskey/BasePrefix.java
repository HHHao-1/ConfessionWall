package com.hao.confessionswall.backend.common.rediskey;

/**
 * @Author hao
 * @create 2021/8/27 7:02 下午
 */
public abstract class BasePrefix {
  private int expireSeconds;
  
  private String prefix;
  
  
  public BasePrefix(int expireSeconds, String prefix) {
    this.expireSeconds = expireSeconds;
    this.prefix = prefix;
  }
  
  public int getExpireSeconds() {//默认0代表永不过期
    return expireSeconds;
  }
  
  public String getPrefix() {
    return getClass().getSimpleName() + ":" + prefix + ":";
  }
  
}
