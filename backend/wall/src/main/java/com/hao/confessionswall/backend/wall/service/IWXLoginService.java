package com.hao.confessionswall.backend.wall.service;

import com.hao.confessionswall.backend.common.model.SysUser;

/**
 * @Author hao
 * @create 2021/8/28 8:48 下午
 */
public interface IWXLoginService {
  SysUser wxLogin(String code);
}
