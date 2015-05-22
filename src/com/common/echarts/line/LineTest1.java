package com.common.echarts.line;

import com.common.echarts.axis.CategoryAxis;
import com.common.echarts.axis.ValueAxis;
import com.common.echarts.code.Symbol;
import com.common.echarts.code.Trigger;
import com.common.echarts.data.LineData;
import com.common.echarts.json.GsonOption;
import com.common.echarts.series.Line;

public class LineTest1 {

    public String test() {
        //例子：http://echarts.baidu.com/doc/example/line.html
    	GsonOption option = new GsonOption();
    	option.title().text("后台的测试页面");
        option.tooltip().trigger(Trigger.axis);
        option.legend("邮件营销", "联盟广告", "直接访问", "搜索引擎");
        option.toolbox().show(true);
        option.calculable(true);
        option.xAxis(new CategoryAxis().boundaryGap(false).data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        option.yAxis(new ValueAxis());
        option.series(new Line().smooth(true).name("邮件营销").stack("总量").symbol(Symbol.none).data(120, 132, 301, 134, new LineData(90, Symbol.droplet, 5), 230, 210));
        LineData lineData = new LineData(201, Symbol.star, 15);
        lineData.itemStyle().normal().label().show(true).textStyle().fontSize(20).fontFamily("微软雅黑").fontWeight("bold");
        option.series(new Line().smooth(true).name("联盟广告").stack("总量").symbol("image://http://echarts.baidu.com/doc/asset/ico/favicon.png").symbolSize(8).data(120, 82, lineData, new LineData(134, Symbol.none), 190, new LineData(230, Symbol.emptypin, 8), 110));
        return option.toString();
    }
    
    public static void main(String[] args) {
    	new LineTest1().toString();
		
	}
}
