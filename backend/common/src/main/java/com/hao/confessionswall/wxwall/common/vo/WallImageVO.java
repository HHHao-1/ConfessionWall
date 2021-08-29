package com.hao.confessionswall.wxwall.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author hao
 * @create 2021/8/28 11:10 下午
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WallImageVO {
  private String amUrl;
  private String pmUrl;
  private String amSort;
  private String pmSort;
}
