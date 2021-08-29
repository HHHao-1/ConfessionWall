package com.hao.confessionswall.wxwall.common.dao;

import com.hao.confessionswall.wxwall.common.model.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author hao
 */
@Mapper
public interface SysUserDao {
  @Insert("insert into sys_user (open_id) values (#{openId})")
  int setUser(String openId);
  
  @Select("select id,open_id,role from sys_user where open_id = #{openId} and enabled = 1")
  SysUser getUser(String openId);
}
