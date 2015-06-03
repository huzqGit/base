package com.common.echarts.bar;



import com.common.echarts.data.ValueAixsData;
import com.common.echarts.helper.EChartDataHelper;
import com.common.echarts.json.EompOption;
import com.common.echarts.series.Line;

public class BarTest1 {

    @SuppressWarnings("unchecked")
	public String test() {
    	
    	
    	String sql1 ="select GENERATOR_TERMINAL_QUANTITY from YX_GENERATE_ELECTRICITY";
    	
    	String sql2 ="select ONLINE_ELECTRIC_QUANTITY from YX_GENERATE_ELECTRICITY";
    	
    	String sql3 ="select PLANT_POWER_RATE from YX_GENERATE_ELECTRICITY";
    	
    	
    	EompOption option = new EompOption();
//    	option.setDefaultFrame(new Object[]{"1号", "2号", "3号", "4号", "5号", "6号", "7号", "8号", "9号", "10号","11号","12号","13号","14号"},
//    			new Object[]{"调度机端电量","上网电量","厂用电率"},
//    			false);
    	option.setDefaultFrame( new Object[]{"1号", "2号", "3号", "4号", "5号", "6号", "7号", "8号", "9号", "10号","11号","12号","13号","14号"},
    			new Object[]{"调度机端电量","上网电量","厂用电率"},false, new ValueAixsData("","{value} %"));
    	
    	
    	
        option.createBars(EChartDataHelper.consrtctedNamedData("调度机端电量", EChartDataHelper.queryForList(sql1)),
        		EChartDataHelper.consrtctedNamedData("上网电量", EChartDataHelper.queryForList(sql2)));
        
        
        Line line = option.createEchartLine(EChartDataHelper.consrtctedNamedData("厂用电率", EChartDataHelper.queryForList(sql3)));
        line.yAxisIndex(1);
        option.series(line);
        
        return option.toString();
    	
 
    }
    
    public static void main(String[] args) {
	}
}
