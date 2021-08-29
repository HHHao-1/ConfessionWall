package com.hao.confessionswall.wxwall.common.rediskey;

import com.hao.confessionswall.wxwall.common.constant.CommonType;

/**
 * @Author hao
 * @create 2021/8/27 7:03 下午
 */
public class UserKey extends BasePrefix {
  public UserKey(int expireSeconds, String prefix) {
    super(expireSeconds, prefix);
  }
  
  public static UserKey login = new UserKey(CommonType.ONE_DAY_MILLIS, "login");
}
