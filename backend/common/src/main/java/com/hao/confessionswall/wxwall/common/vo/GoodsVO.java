package com.hao.confessionswall.wxwall.common.vo;

import com.hao.confessionswall.wxwall.common.model.SeckillImage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author hao
 * @create 2021/8/28 10:23 下午
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GoodsVO {
  private String goodsName;
  private String content;
  private String mainImg;
  private List<SeckillImage> list;
}
