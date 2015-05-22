package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * 雷达图
 *
 * @author liuzh
 */
public class Radar extends Series<Radar> {
    /**
     * 极坐标索引
     */
    private Integer polarIndex;

    /**
     * 构造函数
     */
    public Radar() {
        this.type(SeriesType.radar);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Radar(String name) {
        super(name);
        this.type(SeriesType.radar);
    }

    /**
     * 获取polarIndex值
     */
    public Integer polarIndex() {
        return this.polarIndex;
    }

    /**
     * 设置polarIndex值
     *
     * @param polarIndex
     */
    public Radar polarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
        return this;
    }

    /**
     * 获取polarIndex值
     */
    public Integer getPolarIndex() {
        return polarIndex;
    }

    /**
     * 设置polarIndex值
     *
     * @param polarIndex
     */
    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }
}
