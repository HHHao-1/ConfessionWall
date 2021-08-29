package com.hao.confessionswall.wxwall.common.dao;

import com.hao.confessionswall.wxwall.common.model.WallImage;
import com.hao.confessionswall.wxwall.common.vo.WallImageVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hao
 */
@Mapper
public interface WallImageDao {
  @Insert("insert into wall_image (user_id,url,time,date) values (#{userId},#{url},#{time},#{date},#{sort})")
  int setWallImage(WallImage wallImage);

//  @Select("select max(id) from wall_image")
//  WallImage getLastId(Integer id);
  
  @Select("select w.url am_url,w.sort am_sort,w.date,ww.url pm_url,ww.sort pm_sort from wall_image w join wall_image " +
      "ww on w.time=0 and ww.time=1 " +
      "where w.date = (select date from wall_image where id =(select max(id) from wall_image))")
  List<WallImageVO> getLastDay(Integer id);
  
  @Select("select w.url am_url,w.sort am_sort,w.date,ww.url pm_url,ww.sort pm_sort from wall_image w join wall_image " +
      "ww on w.time=0 and ww.time=1 " +
      "where w.date = #{date}")
  List<WallImageVO> getPreDay(String date);
  
  @Select("select url from wall_img where user_id = #{userId}")
  List<WallImage> getOwerWallImg(Integer userId);
  
}
