
package com.common.echarts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: ScatterData
 *
 * @author liuzh
 */
public class ScatterData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private List<Object> value;

    /**
     * 横值，纵值
     *
     * @param width
     * @param height
     */
    public ScatterData(Object width, Object height) {
        this.value(width, height);
    }

    /**
     * 横值，纵值，大小
     *
     * @param width
     * @param height
     * @param size
     */
    public ScatterData(Object width, Object height, Object size) {
        this.value(width, height, size);
    }

    /**
     * 获取value值
     */
    public List<Object> value() {
        if (this.value == null) {
            this.value = new ArrayList<Object>();
        }
        return this.value;
    }

    /**
     * 设置values值
     *
     * @param values
     */
    private ScatterData value(Object... values) {
        if (values == null || values.length == 0) {
            return this;
        }
        this.value().addAll(Arrays.asList(values));
        return this;
    }

    /**
     * 获取value值
     */
    public List<Object> getValue() {
        return value;
    }

    /**
     * 设置value值
     *
     * @param value
     */
    public void setValue(List<Object> value) {
        this.value = value;
    }
}
