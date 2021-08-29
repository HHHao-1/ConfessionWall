package com.hao.confessionswall.wxwall.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 告白墙图片信息表(wall_image)实体类
 *
 * @author hao
 * @description
 * @since 2021-08-28 21:47:54
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WallImage implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * 上传用户id
   */
  private Long userId;
  /**
   * 图片url
   */
  private String url;
  /**
   * 0表示上午am，1表示下午pm,分文件夹存储
   */
  private Integer time;
  /**
   * 图片上传日期，分文件夹存储
   */
  private String date;
  /**
   * 图片分类，分文件夹存储
   */
  private String sort;
  
}