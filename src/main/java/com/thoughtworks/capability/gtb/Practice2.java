package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {
    LocalDate result;
    if(date.getDayOfWeek() == DayOfWeek.FRIDAY){
      result = date.plusDays(3);
    }
    else if(date.getDayOfWeek() == DayOfWeek.SATURDAY){
      result = date.plusDays(2);
    }
    else{
      result = date.plusDays(1);
    }
    return result;
  }
}
