package com.common.echarts.style;

/**
 * 时间轴控制器样式
 *
 * @author liuzh
 */
public class ControlStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 正常
     */
    private Color normal;
    /**
     * 高亮
     */
    private Color emphasis;

    /**
     * 构造函数
     */
    public ControlStyle() {
    }

    /**
     * 获取normal值
     */
    public Color normal() {
        if (this.normal == null) {
            this.normal = new Color();
        }
        return this.normal;
    }

    /**
     * 设置normal值
     *
     * @param normal
     */
    public ControlStyle normal(Color normal) {
        this.normal = normal;
        return this;
    }

    /**
     * 获取emphasis值
     */
    public Color emphasis() {
        if (this.emphasis == null) {
            this.emphasis = new Color();
        }
        return this.emphasis;
    }

    /**
     * 设置emphasis值
     *
     * @param emphasis
     */
    public ControlStyle emphasis(Color emphasis) {
        this.emphasis = emphasis;
        return this;
    }

    /**
     * 获取normal值
     */
    public Color getNormal() {
        return normal;
    }

    /**
     * 设置normal值
     *
     * @param normal
     */
    public void setNormal(Color normal) {
        this.normal = normal;
    }

    /**
     * 获取emphasis值
     */
    public Color getEmphasis() {
        return emphasis;
    }

    /**
     * 设置emphasis值
     *
     * @param emphasis
     */
    public void setEmphasis(Color emphasis) {
        this.emphasis = emphasis;
    }

    public class Color {
        /**
         * 时间轴控制器样式颜色
         */
        private String color;

        /**
         * 获取color值
         */
        public String color() {
            return this.color;
        }

        /**
         * 设置color值
         *
         * @param color
         */
        public Color color(String color) {
            this.color = color;
            return this;
        }

        /**
         * 获取color值
         */
        public String getColor() {
            return color;
        }

        /**
         * 设置color值
         *
         * @param color
         */
        public void setColor(String color) {
            this.color = color;
        }
    }
}
