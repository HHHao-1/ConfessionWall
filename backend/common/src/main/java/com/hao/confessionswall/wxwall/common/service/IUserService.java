package com.hao.confessionswall.wxwall.common.service;

import com.hao.confessionswall.wxwall.common.model.SysUser;

/**
 * @Author hao
 * @create 2021/8/28 11:46 下午
 */
public interface IUserService {
  SysUser login(String openId);
  
  boolean authRole(String openId);
  
  boolean authLogin(String openId);
}
