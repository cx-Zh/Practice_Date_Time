package com.thoughtworks.capability.gtb;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 脑洞会议系统v3.0
 * 1.当前会议时间"2020-04-01 14:30:00"表示伦敦的本地时间，而输出的新会议时间是芝加哥的本地时间
 * 2.用Period来实现下个会议时间的计算
 *
 * @author itutry
 * @create 2020-05-19_18:43
 */
public class MeetingSystemV3 {

  public static void main(String[] args) {
    String timeStr = "2020-04-01 14:30:00";

    // 根据格式创建格式化类
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // 从字符串解析得到会议时间
    LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

    // 初始化为伦敦本地时间
    ZonedDateTime zonedDateTime = ZonedDateTime.of(meetingTime, ZoneId.of("Europe/London"));
    // 从伦敦本地时间转化到芝加哥本地时间
    ZonedDateTime otherLocalDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Chicago"));
    meetingTime = otherLocalDateTime.toLocalDateTime();

    LocalDateTime now = LocalDateTime.now();
    if (now.isAfter(meetingTime)) {
      LocalDateTime tomorrow = now.plusDays(1);
      int newDayOfYear = tomorrow.getDayOfYear();
      meetingTime = meetingTime.withDayOfYear(newDayOfYear);

      // 格式化新会议时间
      String showTimeStr = formatter.format(meetingTime);
      System.out.println(showTimeStr);

      // 通过period获取到下个会议时间的天数
      Period period = Period.between(now.toLocalDate(), meetingTime.toLocalDate());
      System.out.println(period);
    } else {
      System.out.println("会议还没开始呢");
    }
  }
}
