package com.hao.confessionswall.backend.common.dao;

import com.hao.confessionswall.backend.common.model.SeckillImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author hao
 * @create 2021/8/28 9:53 下午
 */
@Mapper
public interface SeckillImageDao {
  @Insert("insert into seckill_image (goods_id,url,) values (#{goodsId},#{url})")
  int setGoodsImage(SeckillImage seckillImage);
  
  @Select("select url from seckill_image where goods_id = #{goodsId} ")
  SeckillImage getGoodsDetails(Integer goodsId);
}
