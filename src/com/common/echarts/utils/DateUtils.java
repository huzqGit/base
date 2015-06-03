package com.common.echarts.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	public static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	
	public static String formatCalendarAsDate(Date date) {
		if (date == null) {
			return null;
		}

		return sdfDate.format(date);
	}

}
