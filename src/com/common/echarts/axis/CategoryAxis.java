package com.common.echarts.axis;

import com.common.echarts.code.AxisType;

/**
 * 类目轴
 *
 * @author liuzh
 */
public class CategoryAxis extends Axis<CategoryAxis> {
    /**
     * [类目型]类目起始和结束两端空白策略，见下图，默认为true留空，false则顶头
     */
    private Boolean boundaryGap;

    /**
     * 获取boundaryGap值
     */
    public Boolean boundaryGap() {
        return this.boundaryGap;
    }

    /**
     * 设置boundaryGap值
     *
     * @param boundaryGap
     */
    public CategoryAxis boundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
        return this;
    }

    /**
     * 构造函数
     */
    public CategoryAxis() {
        this.type(AxisType.category);
    }

    /**
     * 获取boundaryGap值
     *
     */
    public Boolean getBoundaryGap() {
        return boundaryGap;
    }

    /**
     * 设置boundaryGap值
     *
     * @param boundaryGap
     */
    public void setBoundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
    }
}
