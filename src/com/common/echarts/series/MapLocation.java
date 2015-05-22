
package com.common.echarts.series;

import com.common.echarts.code.X;
import com.common.echarts.code.Y;

/**
 * 地图位置设置，默认只适应上下左右居中可配x，y，width，height，任意参数为空都将根据其他参数自适应
 *
 * @author liuzh
 */
public class MapLocation implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Object x;
    private Object y;
    private Object width;
    private Object height;

    /**
     * 构造函数
     */
    public MapLocation() {
    }

    /**
     * 构造函数,参数:x,y
     *
     * @param x
     * @param y
     */
    public MapLocation(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 构造函数,参数:x,y,width
     *
     * @param x
     * @param y
     * @param width
     */
    public MapLocation(Object x, Object y, Object width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * 构造函数,参数:x,y,width,height
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public MapLocation(Object x, Object y, Object width, Object height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * 构造函数,参数:x,y
     *
     * @param x
     * @param y
     */
    public MapLocation(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 构造函数,参数:x,y,width
     *
     * @param x
     * @param y
     * @param width
     */
    public MapLocation(X x, Y y, Object width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * 构造函数,参数:x,y,width,height
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public MapLocation(X x, Y y, Object width, Object height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * 获取x值
     */
    public Object x() {
        return this.x;
    }

    /**
     * 设置x值
     *
     * @param x
     */
    public MapLocation x(Object x) {
        this.x = x;
        return this;
    }

    /**
     * 设置x值
     *
     * @param x
     */
    public MapLocation x(X x) {
        this.x = x;
        return this;
    }

    /**
     * 获取y值
     */
    public Object y() {
        return this.y;
    }

    /**
     * 设置y值
     *
     * @param y
     */
    public MapLocation y(Y y) {
        this.y = y;
        return this;
    }

    /**
     * 设置y值
     *
     * @param y
     */
    public MapLocation y(Object y) {
        this.y = y;
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
    public MapLocation width(Object width) {
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
    public MapLocation height(Object height) {
        this.height = height;
        return this;
    }

    /**
     * 获取x值
     */
    public Object getX() {
        return x;
    }

    /**
     * 设置x值
     *
     * @param x
     */
    public void setX(Object x) {
        this.x = x;
    }

    /**
     * 获取y值
     */
    public Object getY() {
        return y;
    }

    /**
     * 设置y值
     *
     * @param y
     */
    public void setY(Object y) {
        this.y = y;
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
