package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * 散点图、气泡图
 *
 * @author liuzh
 */
public class Scatter extends Series<Scatter> {
    /**
     * 大规模散点图
     */
    private Boolean large;
    /**
     * 大规模阀值，large为true且数据量>largeThreshold才启用大规模模式
     */
    private Long largeThreshold;

    /**
     * 构造函数
     */
    public Scatter() {
        this.type(SeriesType.scatter);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Scatter(String name) {
        super(name);
        this.type(SeriesType.scatter);
    }

    /**
     * 获取large值
     */
    public Boolean large() {
        return this.large;
    }

    /**
     * 设置large值
     *
     * @param large
     */
    public Scatter large(Boolean large) {
        this.large = large;
        return this;
    }

    /**
     * 获取largeThreshold值
     */
    public Long largeThreshold() {
        return this.largeThreshold;
    }

    /**
     * 设置largeThreshold值
     *
     * @param largeThreshold
     */
    public Scatter largeThreshold(Long largeThreshold) {
        this.largeThreshold = largeThreshold;
        return this;
    }

    /**
     * 获取large值
     */
    public Boolean getLarge() {
        return large;
    }

    /**
     * 设置large值
     *
     * @param large
     */
    public void setLarge(Boolean large) {
        this.large = large;
    }

    /**
     * 获取largeThreshold值
     */
    public Long getLargeThreshold() {
        return largeThreshold;
    }

    /**
     * 设置largeThreshold值
     *
     * @param largeThreshold
     */
    public void setLargeThreshold(Long largeThreshold) {
        this.largeThreshold = largeThreshold;
    }
}
