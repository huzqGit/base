package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * Description: K
 *
 * @author liuzh
 */
public class K extends Series<K> {
    /**
     * 构造函数
     */
    public K() {
        this.type(SeriesType.k);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public K(String name) {
        super(name);
        this.type(SeriesType.k);
    }

    /**
     * 设置open,close,min,max值
     *
     * @param open
     * @param close
     * @param min
     * @param max
     */
    public K data(Double open, Double close, Double min, Double max) {
        Object[] kData = new Object[]{open, close, min, max};
        super.data(kData);
        return this;
    }
}
