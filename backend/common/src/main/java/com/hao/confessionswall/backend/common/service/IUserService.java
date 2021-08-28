package com.hao.confessionswall.backend.common.service;

import com.hao.confessionswall.backend.common.model.SysUser;

/**
 * @Author hao
 * @create 2021/8/28 11:46 下午
 */
public interface IUserService {
  SysUser login(String openId);
  
  boolean authRole(String openId);
  
  boolean authLogin(String openId);
}
