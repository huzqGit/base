package com.common.echarts;

/**
 * 直角坐标系内绘图网格
 *
 * @author liuzh
 */
public class Grid extends Basic<Grid> implements Component {
    /**
     * 直角坐标系内绘图网格左上角横坐标，数值单位px，支持百分比（字符串），如'50%'(显示区域横向中心)
     */
    private Object x2;
    /**
     * 直角坐标系内绘图网格左上角纵坐标，数值单位px，支持百分比（字符串），如'50%'(显示区域纵向中心)
     */
    private Object y2;
    /**
     * 直角坐标系内绘图网格（不含坐标轴）宽度，默认为总宽度 - x - x2，数值单位px，指定width后将忽略x2，见下图。
     * 支持百分比（字符串），如'50%'(显示区域一半的宽度)
     */
    private Object width;
    /**
     * 直角坐标系内绘图网格（不含坐标轴）高度，默认为总宽度 - y - y2，数值单位px，指定height后将忽略y2，见下图。
     * 支持百分比（字符串），如'50%'(显示区域一半的高度)
     */
    private Object height;

    /**
     * 获取x2值
     */
    public Object x2() {
        return this.x2;
    }

    /**
     * 设置x2值
     *
     * @param x2
     */
    public Grid x2(Object x2) {
        this.x2 = x2;
        return this;
    }

    /**
     * 获取y2值
     */
    public Object y2() {
        return this.y2;
    }

    /**
     * 设置y2值
     *
     * @param y2
     */
    public Grid y2(Object y2) {
        this.y2 = y2;
        return this;
    }

    /**
     * 获取width值
     */
    public Object width() {
        return this.width;
    }

    /**
     * 设置width值
     *
     * @param width
     */
    public Grid width(Object width) {
        this.width = width;
        return this;
    }

    /**
     * 获取height值
     */
    public Object height() {
        return this.height;
    }

    /**
     * 设置height值
     *
     * @param height
     */
    public Grid height(Object height) {
        this.height = height;
        return this;
    }

    /**
     * 获取x2值
     */
    public Object getX2() {
        return x2;
    }

    /**
     * 设置x2值
     *
     * @param x2
     */
    public void setX2(Object x2) {
        this.x2 = x2;
    }

    /**
     * 获取y2值
     */
    public Object getY2() {
        return y2;
    }

    /**
     * 设置y2值
     *
     * @param y2
     */
    public void setY2(Object y2) {
        this.y2 = y2;
    }

    /**
     * 获取width值
     */
    public Object getWidth() {
        return width;
    }

    /**
     * 设置width值
     *
     * @param width
     */
    public void setWidth(Object width) {
        this.width = width;
    }

    /**
     * 获取height值
     */
    public Object getHeight() {
        return height;
    }

    /**
     * 设置height值
     *
     * @param height
     */
    public void setHeight(Object height) {
        this.height = height;
    }
}
