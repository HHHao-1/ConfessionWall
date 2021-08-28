package com.hao.confessionswall.backend.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户信息表(sys_user)实体类
 *
 * @author hao
 * @description
 * @since 2021-08-28 21:47:54
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysUser implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id;
  /**
   * 小程序openid
   */
  private String openId;
  /**
   * 0禁用用户，1是激活用户
   */
  private Integer enabled;
  /**
   * 0是普通用户，1是管理员
   */
  private Integer role;
}