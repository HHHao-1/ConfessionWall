package com.hao.confessionswall.backend.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 秒杀商品信息表(seckill_goods)实体类
 *
 * @author hao
 * @description
 * @since 2021-08-28 21:47:54
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SeckillGoods implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * 上传用户id
   */
  private Long userId;
  /**
   * 秒杀商品名称
   */
  private String goodsName;
  /**
   * 秒杀商品文字描述
   */
  private Object content;
  /**
   * 首页图片
   */
  private String mainImg;
  
}