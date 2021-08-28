package com.hao.confessionswall.backend.common.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author hao
 * @create 2021/8/25 5:33 下午
 */
@Getter
@AllArgsConstructor
public abstract class BaseException {
  
  private final int code;
  private final String msg;
}
