package com.hao.common;

import com.hao.common.constant.SafeException;
import com.hao.common.exception.CustomException;

/**
 * @Author hao
 * @create 2021/8/25 6:19 下午
 */
public class TemporaryTest {
  public static void main(String[] args) {
    SafeException b = new SafeException(0, "1");
    System.out.println();
    throw new CustomException(SafeException.SESSION_ERROR);
  }
}
