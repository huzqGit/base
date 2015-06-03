package com.common.echarts.series;

/**
 * @author liuzh
 */
public class ScaleLimit implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Double min;
    private Double max;

    /**
     * 构造函数
     */
    public ScaleLimit() {
    }

    /**
     * 构造函数,参数:min,max
     *
     * @param min
     * @param max
     */
    public ScaleLimit(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 获取min值
     */
    public Double min() {
        return this.min;
    }

    /**
     * 设置min值
     *
     * @param min
     */
    public ScaleLimit min(Double min) {
        this.min = min;
        return this;
    }

    /**
     * 获取max值
     */
    public Double max() {
        return this.max;
    }

    /**
     * 设置max值
     *
     * @param max
     */
    public ScaleLimit max(Double max) {
        this.max = max;
        return this;
    }

    /**
     * 获取min值
     */
    public Double getMin() {
        return min;
    }

    /**
     * 设置min值
     *
     * @param min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * 获取max值
     */
    public Double getMax() {
        return max;
    }

    /**
     * 设置max值
     *
     * @param max
     */
    public void setMax(Double max) {
        this.max = max;
    }
}
