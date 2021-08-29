package com.hao.confessionswall.wxwall.wall.service;


import com.hao.confessionswall.wxwall.common.model.SysUser;

/**
 * @Author hao
 * @create 2021/8/28 8:48 下午
 */
public interface IWXLoginService {
  SysUser wxLogin(String code);
}
