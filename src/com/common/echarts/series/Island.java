package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * @author liuzh
 */
public class Island extends Series<Island> {
    private Object r;
    /**
     * 滚轮可计算步长 0.1 = 10%
     */
    private Object calculateStep;

    /**
     * 构造函数
     */
    public Island() {
        this.type(SeriesType.island);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Island(String name) {
        super(name);
        this.type(SeriesType.island);
    }

    /**
     * 获取r值
     */
    public Object r() {
        return this.r;
    }

    /**
     * 设置r值
     *
     * @param r
     */
    public Island r(Object r) {
        this.r = r;
        return this;
    }

    /**
     * 获取calculateStep值
     */
    public Object calculateStep() {
        return this.calculateStep;
    }

    /**
     * 设置calculateStep值
     *
     * @param calculateStep
     */
    public Island calculateStep(Object calculateStep) {
        this.calculateStep = calculateStep;
        return this;
    }

    /**
     * 获取r值
     */
    public Object getR() {
        return r;
    }

    /**
     * 设置r值
     *
     * @param r
     */
    public void setR(Object r) {
        this.r = r;
    }

    /**
     * 获取calculateStep值
     */
    public Object getCalculateStep() {
        return calculateStep;
    }

    /**
     * 设置calculateStep值
     *
     * @param calculateStep
     */
    public void setCalculateStep(Object calculateStep) {
        this.calculateStep = calculateStep;
    }
}
