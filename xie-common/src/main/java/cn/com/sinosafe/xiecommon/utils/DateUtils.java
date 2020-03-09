package cn.com.sinosafe.xiecommon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * 
 * @author sinosafe
 */
public final class DateUtils {
	
	public static String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
	public static String FORMAT_DATE = "yyyy-MM-dd";
	public static String FORMAT_DATE_WITHOUT = "yyyyMMdd";
	public static String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_Chinese = "yyyy年MM月dd日";
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmsssss";

	/**
	 * 一天包含多少秒
	 */
	public static final long ONE_DAY = 24*3600;
	
	
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }
    
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

	
	public static int minusDay(String dateContent, String destDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateContent);
		Calendar cal = Calendar.getInstance();    
        cal.setTime(date); 
        Date date2 = sdf.parse(destDate);
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(date2);    
        long time2 = cal.getTimeInMillis();         
        long betweenDays=(time2-time1)/(1000*3600*24);  
        return Math.abs(Integer.valueOf(betweenDays + ""));
	}
	 
	/**
	 * 格式化日期
	 * @author liansonghui
	 * @param content
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String parseDateByPattern(Date date, String format) throws ParseException {
		if(date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;
	}
	/**
	 * 格式化日期
	 * @author liansonghui
	 * @param content
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDateByPattern(String content, String format) throws ParseException {
		if(StrUtils.isNotEmpty(content)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(content);
			return date;
		}
		return null;
	}
	
	/**
	 * 获取多少天之前或之后的按格式的String类型日期
	 * @param day 时间间期 正数为后几天，负数为前几天
	 * @param 时间格式
	 */
	public static String getBeforeDay(int day, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(calendar.getTime());
		return time;
	}
	
	/**
	 * 获取多少天之前或之后的当前年份
	 * @param day 时间间期 正数为后几天，负数为前几天
	 * @param 时间格式
	 */
	public static int getYearByBeforeDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取多少周之前或之后的按格式的String类型的开始日期
	 * @param day 时间间期 正数为后几周，负数为前几周
	 * @param 时间格式
	 */
	public static String getStartDayByBeforeWeek(int day, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		 if (dayOfWeek == 0) {
			 dayOfWeek = 7;
		 }
		 calendar.add(Calendar.DATE, -dayOfWeek + 1);
		calendar.add(Calendar.WEEK_OF_YEAR, day);
		//最后一天
		calendar.add(Calendar.DAY_OF_YEAR, 6);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(calendar.getTime());
		return time;
	}
	
	/**
	 * 获取多少周之前或之后的开始日期的年份
	 * @param day 时间间期 正数为后几周，负数为前几周
	 * @param 时间格式
	 */
	public static int getStartYearByBeforeWeek(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_MONTH, day);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取多少周之前或之后的按格式的String类型的结束日期
	 * @param day 时间间期 正数为后几周，负数为前几周
	 * @param 时间格式
	 */
	public static String getEndDayByBeforeWeek(int day, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		 if (dayOfWeek == 0) {
			 dayOfWeek = 7;
		 }
		 calendar.add(Calendar.DATE, -dayOfWeek + 1);
		calendar.add(Calendar.WEEK_OF_YEAR, day);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(calendar.getTime());
		return time;
	}
	
	/**
	 * 获取多少周之前或之后的结束日期的年份
	 * @param day 时间间期 正数为后几周，负数为前几周
	 * @param 时间格式
	 */
	public static int getEndYearByBeforeWeeky(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_MONTH, day);
		calendar.add(Calendar.DAY_OF_YEAR, 6);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取多少月之前或之后的开始日期的月份
	 * @param month 时间间期 正数为后几月，负数为前几月
	 * @param 时间格式
	 */
	public static String getMonthByBeforeMonth(int month, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, month);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(calendar.getTime());
		return time;
	}

	/**
	 * 获取多少月之前或之后的结束日期的年份
	 * @param month 时间间期 正数为后几月，负数为前几月
	 * @param 时间格式
	 */
	public static int getYearByBeforeMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, month);
		return calendar.get(Calendar.YEAR);
	}
	
	
	/**
	 * 获得当前时间 格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowTime() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		String time = sdf.format(nowday);
		return time;
	}
	
	/**
	 * 获得当前时间 格式为：yyyy-MM-dd
	 */
	public static String getNowDate() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
		String time = sdf.format(nowday);
		return time;
	}

	/**
	 * 获得当前时间 格式为：HH:mm:ss
	 */
	public static String getDateHHmmss() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(nowday);
		return time;
	}
	/**
	 * 获得当前时间 格式为：yyyyMMdd
	 */
	public static String getNowDateWithOut() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_WITHOUT);
		String time = sdf.format(nowday);
		return time;
	}
	/**
	 * 获得当前年份
	 */
	public static String getNowYear() {
		Calendar calendar = Calendar.getInstance();
		int year  = calendar.get(Calendar.YEAR);
		return String.valueOf(year);
	}
	
	/**
	 * 获得当前时间 格式为：yyyyMMddHHmmss
	 */
	public static String getNowTimeNo() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sdf.format(nowday);
		return time;
	}

	/**
	 * 获取当前系统时间戳
	 * 
	 * @return
	 */
	public static Long getNowTimeStamp() {
		return System.currentTimeMillis();
	}

	public static Long getNowDateTime() {
		return System.currentTimeMillis()/ 1000;
	}

	/**
	 * 自定义日期格式
	 * 
	 * @param format
	 * @return
	 */
	public static String getNowTime(String format) {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//精确到秒
		String time = sdf.format(nowday);
		return time;
	}

	/**
	 * 将时间字符转成Unix时间戳
	 * 
	 * @param timeStr
	 * @return
	 * @throws ParseException
	 */
	public static Long getTime(String timeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		// 精确到秒
		Date date = sdf.parse(timeStr);
		return date.getTime() / 1000;
	}

	/**
	 * 将时间字符转成Unix时间戳,精确到毫秒
	 *
	 * @param timeStr
	 * @return
	 * @throws ParseException
	 */
	public static Long getTimeM(String timeStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		// 精确到毫秒
		Date date = null;
		date = sdf.parse(timeStr);
		return date.getTime();
	}

	/**
	 * 将Unix时间戳转成时间字符
	 *
	 * @param timestamp
	 * @return
	 */
	public static String getTime(long timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		// 精确到秒
		Date date = new Date(timestamp);
		return sdf.format(date);
	}

	/**
	 * 获取半年后的时间 时间字符格式为：yyyy-MM-dd HH:mm:ss
	 *
	 * @return 时间字符串
	 */
	public static String getHalfYearLaterTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		int halfYear = 6;

		Calendar calendar = Calendar.getInstance();
		int currMonth = calendar.get(Calendar.MONTH) + 1;

		if (currMonth >= 1 && currMonth <= halfYear) {
			calendar.add(Calendar.MONTH, halfYear);
		} else {
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.MONTH, currMonth - halfYear - 1);
		}

		return sdf.format(calendar.getTime());
	}

	/**
	 *  获得当天0点时间戳
	 */
	public static long getTimesMorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return  (cal.getTimeInMillis());
	}

	/**
	 *  获得当天0点时间戳
	 */
	public static Date getStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return  cal.getTime();
	}


	/**获得当前时间30分钟之前的时间戳
	 * @return
	 */
	public static long getTimesBefore30Min() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -30);
		return  (cal.getTimeInMillis());
	}

	/**获得当前时间5分钟之前的时间戳
	 * @return
	 */
	public static long getTimesBefore5Min() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -5);
		return  (cal.getTimeInMillis());
	}


	/**获得当前时间30秒之前的时间戳
	 * @return
	 */
	public static long getTimesBefore30S() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, -30);
		return  (cal.getTimeInMillis());
	}

	/**获得当前时间60秒之前的时间戳
	 * @return
	 */
	public static long getTimesBefore60S() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, -60);
		return  (cal.getTimeInMillis());
	}

	/**获得指定天数的0点时间戳
	 * @param day
	 * @return
	 */
	public static long getTimesMorningAfterDay(int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return  (cal.getTimeInMillis());
	}



	/**比较输入时间和当前时间是否大于一天
	 * @param timeStr 当前时间字符串
	 * @return
	 */
	public static boolean timeSpanThanOneDay(String timeStr)
	{
		try {
			Long time = getTime(timeStr);
			Long nowTime = getNowDateTime();
			return (nowTime - time) > ONE_DAY;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**是否是昨天以前
	 * @param timeStr
	 * @return
	 */
	public static boolean isBeforeYesterday(String timeStr)
	{
		long yesterdayL = getTimesMorningAfterDay(-1);
		try {
			Long time = getTimeM(timeStr);
			return time < yesterdayL;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**是否是昨天
	 * @param timeStr
	 * @return
	 */
	public static boolean isYesterday(String timeStr)
	{
		long yesterdayL = getTimesMorningAfterDay(-1);
		long nowL = getTimesMorningAfterDay(0);
		try {
			Long time = getTimeM(timeStr);
			return yesterdayL <= time && time < nowL;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}


	/**
	 * 是否是今天
	 */
	public static boolean isToday(String timeStr)
	{
		long nowL = getTimesMorningAfterDay(0);
		long tomorrowL = getTimesMorningAfterDay(1);
		try {
			Long time = getTimeM(timeStr);
			return nowL <= time && time < tomorrowL;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 将时间字符转成Unix时间戳
	 *
	 * @param timeStr
	 * @return
	 * @throws ParseException
	 */
	public static Long getTimeS(String timeStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = sdf.parse(timeStr);
		return date.getTime() / 1000;
	}
	
	
	
	/**
	 * 校验时间格式（仅格式）
	 */
	public static boolean checkHHMM(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
         try {
             @SuppressWarnings("unused")
			Date t = dateFormat.parse(time);
         }
         catch (Exception ex) {
             return false;
         }
		return true;
	}
	
	/**
	 * 校验时间格式HH:MM（精确）
	 */
	public static boolean checkTime(String time) {
		if (checkHHMM(time)) {
			String[] temp = time.split(":");
			int temp0 = temp[0].length();
			int temp1 = temp[1].length();
			int hour = 24;
			int sec = 60;
			boolean flag = (temp0 == 2 ||temp0 == 1);
			boolean flag1 = temp1 == 2;
			if ( flag && flag1) {
				int h,m;
				try {
					h = Integer.parseInt(temp[0]);
					m = Integer.parseInt(temp[1]);
				} catch (NumberFormatException e) {
					return false;
				}	
				if (h >= 0 && h <= hour && m <= sec && m >= 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static final String dateTimeNow(final String format)
	{
		return parseDateToStr(format, new Date());
	}

	public static final String dateTime(final Date date)
	{
		return parseDateToStr(YYYY_MM_DD, date);
	}

	public static final String getYYYY_MM_DD(){
		return parseDateToStr(YYYY_MM_DD, new Date());
	}

	public static final String getHHmmss(){
		return parseDateToStr(TIME_FORMAT, new Date());
	}

	public static final String parseDateToStr(final String format, final Date date)
	{
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 日期加天数
	 * @param date
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static String getAddDayDate(String date,int day) throws Exception{
		SimpleDateFormat sim =new SimpleDateFormat(FORMAT_DATE);
		Date date_ = sim.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date_);
		cal.add(Calendar.DATE, day);
		return sim.format(cal.getTime());
	}
	
	/**
	* @Desc    : 当前时间加小时按指定格式返回
	* @Author  : HuYang
	* @Date    : 2020年2月22日 下午4:35:55
	* @param date
	* @param hour
	* @param pattern
	* @return
	* @throws Exception  :
	 */
	public static String getCurrentTimeAddHour(String pattern, int hour) throws Exception{
		SimpleDateFormat sim =new SimpleDateFormat(pattern);
		Date date_ = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date_);
		cal.add(Calendar.HOUR, hour);
		return sim.format(cal.getTime());
	}

	public String getDayAfterOrBefor(int day) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
		return formatter.format(calendar.getTime());
	}

	/**
	 * 日期转换
	 *
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String formatDateToString(Date date, String fmt) {
		String format = new SimpleDateFormat(fmt).format(date);//试试
		return format;
	}

	    /**
	    * @Title: addNatureDays
	    * @Description: 添加指定天数
	    * @param timeStr
	    * @param days
	    * @param format
	    * @throws ParseException   
	    * @return String    
	     */
	public static String addNatureDays(String timeStr, Integer days, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(timeStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
	
	public static String addNatureMonths(Integer months, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return sdf.format(cal.getTime());
	}
	
	/**
	* @Desc    : 当前日期新增指定天数时间戳
	* @Author  : HuYang
	* @Date    : 2020年2月25日 下午9:31:15
	* @param add
	* @return  :
	 */
	public static long getAddDayStamp(int add){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, add);
		return cal.getTimeInMillis();
	}
	
	/**
	* 判断给定日期是否为月末的一天
	* @param date
	* @return true:是|false:不是
	*/
	public static boolean isLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * @Title: getNowTimeMic   
	 * @Description: 获取当前时间字符串 格式:yyyyMMddHHmmssSSS  
	 * @return: String      
	 * @throws
	 */
	public static String getNowTimeMic() {
		Date nowday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = sdf.format(nowday);
		return time;
	}
	
	/**
	  * 获得当月1号
	  * @return
	  */
	public static String firstDayByMonth() {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    Date date = calendar.getTime();
	    String parseDateByPattern = "";
	    try {
			parseDateByPattern = DateUtils.parseDateByPattern(date, FORMAT_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return parseDateByPattern;
	}
	/**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * 
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
