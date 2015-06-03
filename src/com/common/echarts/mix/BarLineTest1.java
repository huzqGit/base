package com.common.echarts.mix;

import com.common.echarts.axis.CategoryAxis;
import com.common.echarts.axis.ValueAxis;
import com.common.echarts.bar.BarTest1;
import com.common.echarts.code.AxisType;
import com.common.echarts.code.Trigger;
import com.common.echarts.json.GsonOption;
import com.common.echarts.series.Bar;
import com.common.echarts.series.Line;

public class BarLineTest1 {

    public String test() {
        //echarts实例：http://echarts.baidu.com/doc/example/mix1.html
    	GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis);
        option.legend("蒸发量", "降水量", "平均温度");
        option.calculable(true);
        option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        ValueAxis value = new ValueAxis();
        value.name("水量").type(AxisType.value).axisLabel().formatter("{value}  ml");
        
        ValueAxis value2 = new ValueAxis();
        value2.name("温度").type(AxisType.value).axisLabel().formatter("{value}  °C");
        option.yAxis(value,value2);
        
        Bar bar = new Bar("蒸发量");
        bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);

        Bar bar2 = new Bar("降水量");
        bar2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);

        Line line = new Line("平均温度");
        line.yAxisIndex(1);
        line.data(2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2);
        
        
        option.series(bar, bar2,line);
//        option.exportToHtml("mix.html");
        System.out.print(option.toString());
        return option.toString();
    }
    
    public static void main(String[] args) {
		new BarTest1().test();
	}
}
