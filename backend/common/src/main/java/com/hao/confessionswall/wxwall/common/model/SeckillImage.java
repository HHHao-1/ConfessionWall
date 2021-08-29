package com.hao.confessionswall.wxwall.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 秒杀商品信息表(seckill_image)实体类
 *
 * @author hao
 * @description
 * @since 2021-08-28 21:47:54
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SeckillImage implements Serializable {
  private static final long serialVersionUID = 1L;
  
  /**
   * 秒杀商品名称
   */
  private String goodsId;
  /**
   * 图片url
   */
  private String url;
  
}