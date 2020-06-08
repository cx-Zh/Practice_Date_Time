package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {

  public static long getDaysBetweenNextLaborDay(LocalDate date) {
    LocalDate labor_day = LocalDate.of(date.getYear(), 5, 1);
//    Period period = Period.between(date, labor_day);
    long days;
    if(date.isAfter(labor_day)) {
      labor_day = labor_day.plusYears(1);
    }
    days = ChronoUnit.DAYS.between(date, labor_day);

    return days;
  }
}
