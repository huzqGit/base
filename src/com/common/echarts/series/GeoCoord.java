package com.common.echarts.series;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 地图特有，标线图形定位坐标
 *
 * @author liuzh
 */
public class GeoCoord extends HashMap<String, BigDecimal[]> implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 设置key,x,y值
     *
     * @param key
     * @param x
     * @param y
     */
    public GeoCoord put(String key, String x, String y) {
        super.put(key, new BigDecimal[]{new BigDecimal(x), new BigDecimal(y)});
        return this;
    }

}
