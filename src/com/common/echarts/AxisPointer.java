package com.common.echarts;

import com.common.echarts.code.PointerType;
import com.common.echarts.style.CrossStyle;
import com.common.echarts.style.LineStyle;
import com.common.echarts.style.ShadowStyle;

/**
 * 坐标轴指示器，坐标轴触发有效
 *
 * @author liuzh
 */
public class AxisPointer implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认为直线，可选为：'line' | 'shadow' | 'cross'
     *
     * @see com.tellhow.eomp.echarts.code.PointerType
     */
    private PointerType type;
    /**
     * 设置直线指示器
     *
     * @see com.tellhow.eomp.echarts.style.LineStyle
     */
    private LineStyle lineStyle;
    /**
     * 设置十字准星指示器
     */
    private CrossStyle crossStyle;
    /**
     * 设置阴影指示器
     */
    private ShadowStyle shadowStyle;

    /**
     * 设置lineStyle值
     *
     * @param lineStyle
     */
    public AxisPointer lineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    /**
     * 设置crossStyle值
     *
     * @param crossStyle
     */
    public AxisPointer crossStyle(CrossStyle crossStyle) {
        this.crossStyle = crossStyle;
        return this;
    }

    /**
     * 设置shadowStyle值
     *
     * @param shadowStyle
     */
    public AxisPointer shadowStyle(ShadowStyle shadowStyle) {
        this.shadowStyle = shadowStyle;
        return this;
    }

    /**
     * 获取type值
     */
    public PointerType type() {
        return this.type;
    }

    /**
     * 设置type值
     *
     * @param type
     */
    public AxisPointer type(PointerType type) {
        this.type = type;
        return this;
    }

    /**
     * 设置直线指示器
     *
     * @see com.tellhow.eomp.echarts.style.LineStyle
     */
    public LineStyle lineStyle() {
        if (this.lineStyle == null) {
            this.lineStyle = new LineStyle();
        }
        return this.lineStyle;
    }

    /**
     * 设置十字准星指示器
     */
    public CrossStyle crossStyle() {
        if (this.crossStyle == null) {
            this.crossStyle = new CrossStyle();
        }
        return this.crossStyle;
    }

    /**
     * 设置阴影指示器
     */
    public ShadowStyle shadowStyle() {
        if (this.shadowStyle == null) {
            this.shadowStyle = new ShadowStyle();
        }
        return this.shadowStyle;
    }

    /**
     * 获取lineStyle值
     */
    public LineStyle getLineStyle() {
        return lineStyle;
    }

    /**
     * 设置lineStyle值
     *
     * @param lineStyle
     */
    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    /**
     * 获取crossStyle值
     */
    public CrossStyle getCrossStyle() {
        return crossStyle;
    }

    /**
     * 设置crossStyle值
     *
     * @param crossStyle
     */
    public void setCrossStyle(CrossStyle crossStyle) {
        this.crossStyle = crossStyle;
    }

    /**
     * 获取shadowStyle值
     */
    public ShadowStyle getShadowStyle() {
        return shadowStyle;
    }

    /**
     * 设置shadowStyle值
     *
     * @param shadowStyle
     */
    public void setShadowStyle(ShadowStyle shadowStyle) {
        this.shadowStyle = shadowStyle;
    }

    /**
     * 获取type值
     */
    public PointerType getType() {
        return type;
    }

    /**
     * 设置type值
     *
     * @param type
     */
    public void setType(PointerType type) {
        this.type = type;
    }
}
