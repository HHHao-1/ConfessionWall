package com.hao.confessionswall.backend.common;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author hao
 * @create 2021/8/25 6:20 下午
 */
@Accessors(chain = true)
@Data
@RequiredArgsConstructor(staticName = "of")
public class TemporaryModel {
  @NonNull
  private String name;
  private int age;
}
