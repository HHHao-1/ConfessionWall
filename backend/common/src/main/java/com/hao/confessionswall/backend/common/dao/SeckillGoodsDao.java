package com.hao.confessionswall.backend.common.dao;

import com.hao.confessionswall.backend.common.model.SeckillGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hao
 * @create 2021/8/28 9:52 下午
 */
@Mapper
public interface SeckillGoodsDao {
  @Insert("insert into seckill_goods(user_id,goods_name,content,main_img)values(#{userId},#{goodsName},#{content}," +
      "#{mainImg})")
  int setGoods(SeckillGoods seckillGoods);
  
  @Select("select * from seckill_goods")
  List<SeckillGoods> getGoodsList();
  
  @Select("select * from seckill_goods where user_id = userId ")
  List<SeckillGoods> getOwerGoodsList(Integer userId);
}
