package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * 柱形图
 *
 * @author liuzh
 */
public class Bar extends Series<Bar> {
    /**
     * 柱条最小高度，可用于防止某item的值过小而影响交互
     */
    private Integer barMinHeight;
    /**
     * 柱间距离，默认为柱形宽度的30%，可设固定值
     */
    private String barGap;
    /**
     * 类目间柱形距离，默认为类目间距的20%，可设固定值
     */
    private String barCategoryGap;

    /**
     * 构造函数
     */
    public Bar() {
        this.type(SeriesType.bar);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Bar(String name) {
        super(name);
        this.type(SeriesType.bar);
    }

    /**
     * 获取barMinHeight值
     */
    public Integer barMinHeight() {
        return this.barMinHeight;
    }

    /**
     * 设置barMinHeight值
     *
     * @param barMinHeight
     */
    public Bar barMinHeight(Integer barMinHeight) {
        this.barMinHeight = barMinHeight;
        return this;
    }

    /**
     * 获取barGap值
     */
    public String barGap() {
        return this.barGap;
    }

    /**
     * 设置barGap值
     *
     * @param barGap
     */
    public Bar barGap(String barGap) {
        this.barGap = barGap;
        return this;
    }

    /**
     * 获取barCategoryGap值
     */
    public String barCategoryGap() {
        return this.barCategoryGap;
    }

    /**
     * 设置barCategoryGap值
     *
     * @param barCategoryGap
     */
    public Bar barCategoryGap(String barCategoryGap) {
        this.barCategoryGap = barCategoryGap;
        return this;
    }

    /**
     * 获取barMinHeight值
     */
    public Integer getBarMinHeight() {
        return barMinHeight;
    }

    /**
     * 设置barMinHeight值
     *
     * @param barMinHeight
     */
    public void setBarMinHeight(Integer barMinHeight) {
        this.barMinHeight = barMinHeight;
    }

    /**
     * 获取barGap值
     */
    public String getBarGap() {
        return barGap;
    }

    /**
     * 设置barGap值
     *
     * @param barGap
     */
    public void setBarGap(String barGap) {
        this.barGap = barGap;
    }

    /**
     * 获取barCategoryGap值
     */
    public String getBarCategoryGap() {
        return barCategoryGap;
    }

    /**
     * 设置barCategoryGap值
     *
     * @param barCategoryGap
     */
    public void setBarCategoryGap(String barCategoryGap) {
        this.barCategoryGap = barCategoryGap;
    }
}
