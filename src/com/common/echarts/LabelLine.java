
package com.common.echarts;

import com.common.echarts.style.LineStyle;

/**
 * 标签视觉引导线l
 *
 * @author liuzh
 */
public class LabelLine implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 饼图标签视觉引导线显示策略，可选为：true（显示） | false（隐藏）
     */
    private Boolean show;
    /**
     * 线长 ，从外圆边缘起计算，可为负值
     */
    private Integer length;
    /**
     * 线条样式，详见lineStyle
     *
     * @see com.tellhow.eomp.echarts.style.LineStyle
     */
    private LineStyle lineStyle;

    /**
     * 获取show值
     */
    public Boolean show() {
        return this.show;
    }

    /**
     * 设置show值
     *
     * @param show
     */
    public LabelLine show(Boolean show) {
        this.show = show;
        return this;
    }

    /**
     * 获取length值
     */
    public Integer length() {
        return this.length;
    }

    /**
     * 设置length值
     *
     * @param length
     */
    public LabelLine length(Integer length) {
        this.length = length;
        return this;
    }

    /**
     * 线条样式，详见lineStyle
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
     * 设置style值
     *
     * @param style
     */
    public LabelLine lineStyle(LineStyle style) {
        this.lineStyle = style;
        return this;
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

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
