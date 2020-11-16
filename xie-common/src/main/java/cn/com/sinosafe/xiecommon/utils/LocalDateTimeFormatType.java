package cn.com.sinosafe.xiecommon.utils;

import java.time.format.DateTimeFormatter;

/** 日期的格式化类型 */
public interface LocalDateTimeFormatType {

    /** yyyy-MM-dd HH:mm:ss SSS */
    DateTimeFormatter  YYYY_MM_DD_HH_MM_SS_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
    /** yyyy-MM-dd HH:mm:ss */
    DateTimeFormatter  YYYY_MM_DD_HH_MM_SS =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /** yyyy-MM-dd HH:mm */
    DateTimeFormatter YYYY_MM_DD_HH_MM =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    /** yyyy-MM-dd */
    DateTimeFormatter YYYY_MM_DD =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /** yyyy-MM */
    DateTimeFormatter YYYY_MM =  DateTimeFormatter.ofPattern("yyyy-MM");
    /** yyyy-MM-dd am/pm --> am/pm 会根据时区自动完成, 也就是如果当前时区是北京的话, 会显示成 上午/下午 */
    DateTimeFormatter YYYY_MM_DD_AP =  DateTimeFormatter.ofPattern("yyyy-MM-dd a");

    /** yyyyMMddHHmmssSSS */
    DateTimeFormatter YYYYMMDDHHMMSSSSS =  DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    /** yyyyMMddHHmmss */
    DateTimeFormatter YYYYMMDDHHMMSS =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /** yyMMddHHmmss */
    DateTimeFormatter YYMMDDHHMMSS =  DateTimeFormatter.ofPattern("yyMMddHHmmss");
    /** yyyyMMddHHmm */
    DateTimeFormatter YYYYMMDDHHMM =  DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    /** yyMMddHHmm */
    DateTimeFormatter YYMMDDHHMM =  DateTimeFormatter.ofPattern("yyMMddHHmm");
    /** yyyyMMdd */
    DateTimeFormatter  YYYYMMDD =  DateTimeFormatter.ofPattern("yyyyMMdd");
    /** yyMMdd */
    DateTimeFormatter YYMMDD =  DateTimeFormatter.ofPattern("yyMMdd");
    /** yyyyMM */
    DateTimeFormatter YYYYMM =  DateTimeFormatter.ofPattern("yyyyMM");

    /** HH:mm:ss */
    DateTimeFormatter HH_MM_SS =  DateTimeFormatter.ofPattern("HH:mm:ss");
    /** HH:mm */
    DateTimeFormatter HH_MM =  DateTimeFormatter.ofPattern("HH:mm");

    /** 到毫秒: yyyy-MM-ddTHH:mm:ss.SSSZ */
    DateTimeFormatter TSZ =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    /** 到毫秒: yyyy-MM-ddTHH:mm:ss.SSS */
    DateTimeFormatter  TS =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    /** 到秒: yyyy-MM-ddTHH:mm:ssZ */
    DateTimeFormatter TZ =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    /** 到秒: yyyy-MM-ddTHH:mm:ss */
    DateTimeFormatter T =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /** yyyy/MM/dd */
    DateTimeFormatter USA_YYYY_MM_DD =  DateTimeFormatter.ofPattern("yyyy/MM/dd");
    /** yyyy/MM/dd */
    DateTimeFormatter USA_YYYY_MM_DD_HH_MM =  DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    /** yyyy/MM/dd */
    DateTimeFormatter USA_YYYY_MM_DD_HH_MM_SS =  DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /** MM/dd/yyyy HH:mm:ss */
    DateTimeFormatter USA_MM_DD_YYYY_HH_MM =  DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
    /** MM/dd/yyyy HH:mm:ss */
    DateTimeFormatter USA_MM_DD_YYYY_HH_MM_SS =  DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /** yyyy年MM月dd日 HH时mm分ss秒 */
    DateTimeFormatter CN_YYYY_MM_DD_HH_MM_SS =  DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
    /** yyyy年MM月dd日 HH点 */
    DateTimeFormatter CN_YYYY_MM_DD_HH =  DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点");
    /** yyyy年MM月dd日 HH点 */
    DateTimeFormatter CN_YYYY_MM_DD_HH_MM =  DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分");
    /** yyyy年MM月dd日 */
    DateTimeFormatter CN_YYYY_MM_DD =  DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    /** 直接打印 new Date =  DateTimeFormatter.ofPattern() 时的样式 */
    DateTimeFormatter CST =  DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");


}
