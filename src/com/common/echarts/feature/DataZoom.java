package com.common.echarts.feature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzh
 */
public class DataZoom extends Feature {
    /**
     * 构造函数
     */
    public DataZoom() {
        this.show(true);
        Map title = new HashMap<String, String>();
        title.put("dataZoom", "区域缩放");
        title.put("dataZoomReset", "区域缩放后退");
        this.title(title);
    }
}
