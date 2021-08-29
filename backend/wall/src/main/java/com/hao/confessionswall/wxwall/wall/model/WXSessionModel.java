package com.hao.confessionswall.wxwall.wall.model;

import lombok.Data;

@Data
public class WXSessionModel {
  
  private String session_key;
  private String openid;
}
