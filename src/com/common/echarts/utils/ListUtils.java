package com.common.echarts.utils;


import java.util.List;

public class ListUtils {
	  public static boolean isEmpty(List data) {
	        boolean isEmpty = true;
	        if (data != null && data.size() > 0) {
	            isEmpty = false;
	        }
	        return isEmpty;
	    }

	    public static boolean isNotEmpty(List data) {
	        return !isEmpty(data);
	    }
}
