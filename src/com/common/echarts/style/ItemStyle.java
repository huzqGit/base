package com.common.echarts.style;

import com.common.echarts.style.itemstyle.Emphasis;
import com.common.echarts.style.itemstyle.Normal;

/**
 * Description: ItemStyle
 *
 * @author liuzh
 */
public class ItemStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认样式
     */
    private Normal normal;
    /**
     * 强调样式（悬浮时样式）
     */
    private Emphasis emphasis;

    /**
     * 获取normal值
     */
    public Normal normal() {
        if (this.normal == null) {
            this.normal = new Normal();
        }
        return this.normal;
    }

    /**
     * 设置normal值
     *
     * @param normal
     */
    public ItemStyle normal(Normal normal) {
        this.normal = normal;
        return this;
    }

    /**
     * 获取emphasis值
     */
    public Emphasis emphasis() {
        if (this.emphasis == null) {
            this.emphasis = new Emphasis();
        }
        return this.emphasis;
    }

    /**
     * 设置emphasis值
     *
     * @param emphasis
     */
    public ItemStyle emphasis(Emphasis emphasis) {
        this.emphasis = emphasis;
        return this;
    }

    /**
     * 获取normal值
     */
    public Normal getNormal() {
        return normal;
    }

    /**
     * 设置normal值
     *
     * @param normal
     */
    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    /**
     * 获取emphasis值
     */
    public Emphasis getEmphasis() {
        return emphasis;
    }

    /**
     * 设置emphasis值
     *
     * @param emphasis
     */
    public void setEmphasis(Emphasis emphasis) {
        this.emphasis = emphasis;
    }
}
