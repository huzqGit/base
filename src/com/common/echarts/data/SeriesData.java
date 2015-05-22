package com.common.echarts.data;

import com.common.echarts.Tooltip;
import com.common.echarts.style.ItemStyle;

/**
 * Description: Series.Data
 *
 * @author liuzh
 */
public class SeriesData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Object value;
    private Tooltip tooltip;
    private ItemStyle itemStyle;

    /**
     * 构造函数,参数:value
     *
     * @param value
     */
    public SeriesData(Object value) {
        this.value = value;
    }

    /**
     * 构造函数,参数:value,tooltip
     *
     * @param value
     * @param tooltip
     */
    public SeriesData(Object value, Tooltip tooltip) {
        this.value = value;
        this.tooltip = tooltip;
    }

    /**
     * 构造函数,参数:value,itemStyle
     *
     * @param value
     * @param itemStyle
     */
    public SeriesData(Object value, ItemStyle itemStyle) {
        this.value = value;
        this.itemStyle = itemStyle;
    }

    /**
     * 构造函数,参数:value,tooltip,itemStyle
     *
     * @param value
     * @param tooltip
     * @param itemStyle
     */
    public SeriesData(Object value, Tooltip tooltip, ItemStyle itemStyle) {
        this.value = value;
        this.tooltip = tooltip;
        this.itemStyle = itemStyle;
    }

    /**
     * 获取value值
     */
    public Object value() {
        return this.value;
    }

    /**
     * 设置value值
     *
     * @param value
     */
    public SeriesData value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * 获取tooltip值
     */
    public Tooltip tooltip() {
        if (this.tooltip == null) {
            this.tooltip = new Tooltip();
        }
        return this.tooltip;
    }

    /**
     * 设置tooltip值
     *
     * @param tooltip
     */
    public SeriesData tooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    /**
     * 获取itemStyle值
     */
    public ItemStyle itemStyle() {
        if (this.itemStyle == null) {
            this.itemStyle = new ItemStyle();
        }
        return this.itemStyle;
    }

    /**
     * 设置itemStyle值
     *
     * @param itemStyle
     */
    public SeriesData itemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public ItemStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }
}
