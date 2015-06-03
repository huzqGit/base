package com.common.echarts.pie;

import com.common.echarts.Option;
import com.common.echarts.code.Magic;
import com.common.echarts.code.Tool;
import com.common.echarts.code.Trigger;
import com.common.echarts.code.X;
import com.common.echarts.data.LineData;
import com.common.echarts.data.PieData;
import com.common.echarts.feature.MagicType;
import com.common.echarts.json.GsonOption;
import com.common.echarts.series.Funnel;
import com.common.echarts.series.Pie;


public class PieTest1 {

	  public String test() {
	        //实例地址：http://echarts.baidu.com/doc/example/pie7.html
	    	GsonOption option = new GsonOption();
	        //时间轴
	        option.timeline().data("2013-01-01", "2013-02-01", "2013-03-01", "2013-04-01", "2013-05-01",
	                new LineData("2013-06-01", "emptyStart6", 8), "2013-07-01", "2013-08-01", "2013-09-01", "2013-10-01",
	                "2013-11-01", new LineData("2013-12-01", "star6", 8));
	        option.timeline().autoPlay(true).label().formatter("function(s){return s.slice(0,7);}");
	        //timeline有多个Option
	        Option basic = new Option();
	        basic.title().text("浏览器占比变化").subtext("纯属虚构");
	        basic.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
	        basic.legend().data("Chrome", "Firefox", "Safari", "IE9+", "IE8-");
	        basic.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage, new MagicType(Magic.pie, Magic.funnel)
	                .option(new MagicType.Option().funnel(
	                        new Funnel().x("25%").width("50%").funnelAlign(X.left).max(1548))));

	        int idx = 1;
	        basic.series(getPie(idx++).center("50%", "45%").radius("50%"));
	        //加入
	        option.options(basic);
	        //构造11个数据
	        Option[] os = new Option[11];
	        for (int i = 0; i < os.length; i++) {
	            os[i] = new Option().series(getPie(idx++));
	        }
	        option.options(os);
//	        option.exportToHtml("pie2.html");
//	        option.view();
	        return option.toString();
	    }

	    /**
	     * 获取饼图数据
	     *
	     * @param idx
	     * @return
	     */
	    public Pie getPie(int idx) {
	        return new Pie().name("浏览器（数据纯属虚构）").data(
	                new PieData("Chrome", idx * 128 + 80),
	                new PieData("Firefox", idx * 64 + 160),
	                new PieData("Safari", idx * 32 + 320),
	                new PieData("IE9+", idx * 16 + 640),
	                new PieData("IE8-", idx * 8 + 1280));
	    }
	    
	    public static void main(String[] args) {
	    	new PieTest1().test();
		}
}
