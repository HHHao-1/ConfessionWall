package com.hao.common.rediskey;

/**
 * @Author hao
 * @create 2021/8/27 7:03 下午
 */
public class UserKey extends BasePrefix {
  public UserKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }
  
  public static UserKey login = new UserKey(BasePrefix.oneDay, "login");
}
