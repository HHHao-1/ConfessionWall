package com.hao.common.constant;


/**
 * @Author hao
 * @create 2021/8/25 5:35 下午
 */
public class SeckillException extends BaseException {
  public SeckillException(int code, String msg) {
    super(code, msg);
  }
  
  public static SeckillException ORDER_NOT_EXIST = new SeckillException(500400, "订单不存在");
  public static SeckillException MIAO_SHA_OVER = new SeckillException(500500, "商品已经秒杀完毕");
  public static SeckillException REPEATE_MIAOSHA = new SeckillException(500501, "不能重复秒杀");
  public static SeckillException MIAOSHA_FAIL = new SeckillException(500502, "秒杀失败");
}
