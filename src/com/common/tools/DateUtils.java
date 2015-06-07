package com.common.tools;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private static Logger log = LoggerFactory.getLogger(DateUtils.class);
	private static final String datePattern = "yyyy-MM-dd";
	private static final String yearMonthPattern = "yyyy-MM";
	private static final String timestampPattern = "yyyy-MM-dd HH:mm:ss";
	private static final String timePattern = "HH:mm:ss";

	/**
	 * format the date to 'yyyy-mm-dd'
	 * 
	 * @param date
	 *          String
	 * @return Date
	 */
	public static Date parseDate(String date) {
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(date,
					new String[] { datePattern });
		} catch (Exception ex) {
			log.error("Date format occurs error .", ex);
			return null;
		}
	}
	
	public static Date parseDateFullPattern(String date) {
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(date,
					new String[] { timestampPattern,datePattern,yearMonthPattern,timePattern});
		} catch (Exception ex) {
			log.error("Date format occurs error .", ex);
			return null;
		}
	}
	
	/**
	 * format the date to 'yyyy-mm'
	 * 
	 * @param date
	 *          String
	 * @return Date
	 */
	public static Date parseDateOfYearMonth(String yearMonth) {
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(yearMonth,
					new String[] { yearMonthPattern });
		} catch (Exception ex) {
			log.error("Date format occurs error .", ex);
			return null;
		}
	}

	public static String format(Date date) {
		if (date == null) {
			return "";
		} else {
			return DateFormatUtils.format(date, datePattern);
		}
	}

	public static Date parseTimestamp(String timestamp) {
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(timestamp,
					new String[] { timestampPattern });
		} catch (Exception ex) {
			log.error("Date format occurs error .", ex);
			return null;
		}
	}
	public static Date parseTime(String time) {
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(time,
					new String[] { timePattern });
		} catch (Exception ex) {
			log.error("Date format occurs error .", ex);
			return null;
		}
	}
	public static String formatTimestamp(Timestamp timestamp) {
		if (timestamp == null) {
			return "";
		} else {
			return DateFormatUtils.format(timestamp, timestampPattern);
		}
	}
	
	public static String formatTime(Time time) {
		if (time == null) {
			return "";
		} else {
			return DateFormatUtils.format(time, timePattern);
		}
	}
	
	public static String formatTime(Timestamp time) {
		if (time == null) {
			return "";
		} else {
			return DateFormatUtils.format(time, timePattern);
		}
	}
	
	public static void trimToDate(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * rollDays distance to today ; n before today? negative : positive
	 * 
	 * @param n
	 *          int
	 * @return Timestamp
	 */
	public static Timestamp rollDays(int n) {
		long dayMils = 86400000l;
		return new Timestamp(System.currentTimeMillis() + dayMils * n);
	}

	/**
	 * 
	 * @param first
	 *          Date
	 * @param end
	 *          Date
	 * @return List<String>. format YearMonth patten is decided by cfg
	 *         ('global.yearMonthFormat')
	 */

	public static List<String> getYearMonthsOfDateInterval(Date first, Date end) {
		List<String> dateList = new ArrayList<String>();
		Calendar firstCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		firstCalendar.setTime(first);
		endCalendar.setTime(end);
		firstCalendar.add(Calendar.MONTH, 1);
		endCalendar.add(Calendar.MONTH, -1);
		while (!firstCalendar.after(endCalendar)) {
			dateList.add(DateFormatUtils.format(firstCalendar.getTime(),yearMonthPattern));
			firstCalendar.add(Calendar.MONTH, 1);
		}
		return dateList;
	}

	/**
	 * true behalf the firstDay of month, false behalf the endDay of month
	 * 
	 * @param bool
	 * @return
	 */
	public static Date getFirstOrEndDayOfMonth(boolean bool) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		if (!bool) {// 当月最后一天.
			calendar.roll(Calendar.MONTH, 1);
			calendar.roll(Calendar.DAY_OF_YEAR, -1);
		}
		return calendar.getTime();
	}
	
	/**
	 * 指定某月份第一天，最后一天.
	 * @param yearMonth: 2014-02
	 */
	public static Date getFirstOrEndDayOfYearMonth(String yearMonth, boolean bool) {
		Calendar calendar=new GregorianCalendar();  
        calendar.setTime(DateUtils.parseDateOfYearMonth(yearMonth));  
        calendar.add(calendar.DATE, 0); 
        calendar.roll(calendar.DATE, -1);
        if (!bool) { //某月最后一天.
        	calendar.roll(calendar.DATE, -1);
        }
        return calendar.getTime();  
	}
	
	/**
	 * 指定某年，某一周第一天，最后一天.
	 * @param year
	 * @param week
	 * @param flag
	 * @return
	 */
	public static Date getDayByWeek(int year, int week, boolean bool) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//设置周一  
		cal.setFirstDayOfWeek(Calendar.MONDAY); 
		if (!bool)//某周最后一天.
			cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
		return cal.getTime();
	}
	
	/**
	 * 当前周.
	 * @return
	 */
	public static int getWeekNumber() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static void main(String[] args) throws ParseException {
//		System.out.println(DateUtils.format(getFirstOrEndDayOfMonth(false)));
//		System.out.println(DateUtils.format(getFirstOrEndDayOfMonth(true)));
		
//		System.out.println(DateUtils.format(DateUtils.getDayByWeek(2014, 3, true)));
//		System.out.println(DateUtils.format(DateUtils.getDayByWeek(2014, 3, false)));
		
//		System.out.println(getWeekNumber());
		
		Date date = formatDate(new Date(), -1);
		System.out.println(DateUtils.format(date));
		
	}

	/**
	 * 根据某一日期算出多少天后的某日.
	 * 
	 * @param initDate Date
	 * @param days int
	 * @return Date
	 */
	public static Date formatDate(Date initDate, int days) {
		Calendar strCal = new GregorianCalendar();
		Date formatDate = null;
		strCal.setTime(initDate);
		Calendar endCal = new GregorianCalendar(strCal.get(Calendar.YEAR), strCal
				.get(Calendar.MONTH), strCal.get(Calendar.DAY_OF_MONTH) + days);
		if (endCal != null) {
			formatDate = endCal.getTime();
		}
		return formatDate;
	}
	
	/**  
	  * 根据所给日期返回两日期相差的秒数  
	  * @param startDate  
	  * @param endDate  
	  * @return 返回两个日期间隔的毫秒数  
	  */  
	   public static long getSecond(Date startDate,Date endDate)   
	   {   
	         long startTime = startDate.getTime();   
	         long endTime = endDate.getTime();   
	         long interval = (endTime - startTime)/1000;   
	        
	         return interval;   
	   }    
	 
	   /**  
	   * 根据所秒数,计算相差的时间并以**时**分**秒返回
	   */  
	   public static String getBeapartDate(long interval) {   
			String beapartdate = "";
			int nDay = (int) interval / (24 * 60 * 60);
			int nHour = (int) (interval - nDay * 24 * 60 * 60) / (60 * 60);
			int nMinute = (int) (interval - nDay * 24 * 60 * 60 - nHour * 60 * 60) / 60;
			int nSecond = (int) interval - nDay * 24 * 60 * 60 - nHour * 60 * 60 - nMinute* 60;
			String day = nDay == 0 ? "" : nDay+"天";
			String hour = nHour == 0 ? "" : nHour+"小时";
			String minute = nMinute == 0 ? "" : nMinute + "分";
			String second = nSecond == 0 ? "" : nSecond + "秒";
			beapartdate = day+hour+minute+second; 
	        return beapartdate;  
	   }

}
