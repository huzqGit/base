package com.common.echarts.series;

import com.common.echarts.code.SeriesType;

/**
 * @author liuzh
 */
public class Line extends Series<Line> {
    /**
     * 平滑曲线
     */
    private Boolean smooth;

    /**
     * 构造函数
     */
    public Line() {
        this.type(SeriesType.line);
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Line(String name) {
        super(name);
        this.type(SeriesType.line);
    }

    /**
     * 获取smooth值
     */
    public Boolean smooth() {
        return this.smooth;
    }

    /**
     * 设置smooth值
     *
     * @param smooth
     */
    public Line smooth(Boolean smooth) {
        this.smooth = smooth;
        return this;
    }

    /**
     * 获取smooth值
     */
    public Boolean getSmooth() {
        return smooth;
    }

    /**
     * 设置smooth值
     *
     * @param smooth
     */
    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }
}
