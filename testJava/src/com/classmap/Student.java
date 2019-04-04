package com.classmap;

import lombok.Data;

/**
 * Created by meridian on 2018/12/10.
 */
@Data
public class Student {
  private String name;
    private String phone;
    private Integer age ;
    private int sex;
    private MonitorEarlywarnOrAlarmParam param;
    @Override
    public String toString(){
      return "name:"+name+",phone:"+phone+",age"+age+",{param:oneMaxSymbol-"+param.getOneMaxSymbol()+",oneMaxValue-"+param.getOneMaxValue()+"}";
    }
}
