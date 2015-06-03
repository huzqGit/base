package com.common.echarts.series.force;

import com.common.echarts.style.ItemStyle;

/**
 * 力导向图中节点的分类
 *
 * @author liuzh
 */
public class Category implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类目名称
     */
    private String name;
    /**
     * 所有该类目的节点的形状, 详见 symbolList
     *
     * @see com.tellhow.eomp.echarts.code.Symbol
     */
    private Object symbol;
    /**
     * 所有该类目的节点的大小
     */
    private Object symbolSize;
    /**
     * 所有该类目的节点是否能被拖拽
     */
    private Boolean draggable;
    /**
     * 详见 itemStyle
     *
     * @see com.tellhow.eomp.echarts.style.ItemStyle
     */
    private ItemStyle itemStyle;

    /**
     * 构造函数
     */
    public Category() {
    }

    /**
     * 构造函数,参数:name
     *
     * @param name
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * 获取name值
     */
    public String name() {
        return this.name;
    }

    /**
     * 设置name值
     *
     * @param name
     */
    public Category name(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取symbol值
     */
    public Object symbol() {
        return this.symbol;
    }

    /**
     * 设置symbol值
     *
     * @param symbol
     */
    public Category symbol(Object symbol) {
        this.symbol = symbol;
        return this;
    }

    /**
     * 获取symbolSize值
     */
    public Object symbolSize() {
        return this.symbolSize;
    }

    /**
     * 设置symbolSize值
     *
     * @param symbolSize
     */
    public Category symbolSize(Object symbolSize) {
        this.symbolSize = symbolSize;
        return this;
    }

    /**
     * 获取draggable值
     */
    public Boolean draggable() {
        return this.draggable;
    }

    /**
     * 设置draggable值
     *
     * @param draggable
     */
    public Category draggable(Boolean draggable) {
        this.draggable = draggable;
        return this;
    }

    /**
     * 详见 itemStyle
     *
     * @see com.tellhow.eomp.echarts.style.ItemStyle
     */
    public ItemStyle itemStyle() {
        if (this.itemStyle == null) {
            this.itemStyle = new ItemStyle();
        }
        return this.itemStyle;
    }

    /**
     * 获取itemStyle值
     */
    public ItemStyle getItemStyle() {
        return itemStyle;
    }

    /**
     * 设置itemStyle值
     *
     * @param itemStyle
     */
    public void setItemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    /**
     * 获取name值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name值
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取symbol值
     */
    public Object getSymbol() {
        return symbol;
    }

    /**
     * 设置symbol值
     *
     * @param symbol
     */
    public void setSymbol(Object symbol) {
        this.symbol = symbol;
    }

    /**
     * 获取symbolSize值
     */
    public Object getSymbolSize() {
        return symbolSize;
    }

    /**
     * 设置symbolSize值
     *
     * @param symbolSize
     */
    public void setSymbolSize(Object symbolSize) {
        this.symbolSize = symbolSize;
    }

    /**
     * 获取draggable值
     */
    public Boolean getDraggable() {
        return draggable;
    }

    /**
     * 设置draggable值
     *
     * @param draggable
     */
    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }
}
