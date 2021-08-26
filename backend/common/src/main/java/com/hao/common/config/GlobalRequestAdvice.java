package com.hao.common.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hao
 */
@ControllerAdvice
public class GlobalRequestAdvice {
  
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //true表示转换为日期的字符串可以为空，不设置这个值接收空串会报错
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)
    );
  }
  
  
  //这两个方法现在是全局的，也可单独用于某个controller
  //  @ModelAttribute("s")
  //  protected String tt() {
  //    return "ttt";
  //  }
  //@GetMapping("/test2")
  //public String b(@ModelAttribute("s")String s, Date tim)
  //public String b(Model model)
  
}
