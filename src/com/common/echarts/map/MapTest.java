package com.common.echarts.map;

import java.util.ArrayList;
import java.util.List;

import com.common.echarts.code.Orient;
import com.common.echarts.code.Position;
import com.common.echarts.code.RoseType;
import com.common.echarts.code.SelectedMode;
import com.common.echarts.code.Trigger;
import com.common.echarts.code.X;
import com.common.echarts.data.MapData;
import com.common.echarts.data.PieData;
import com.common.echarts.json.GsonOption;
import com.common.echarts.series.Map;
import com.common.echarts.series.Pie;
import com.common.echarts.style.ItemStyle;

public class MapTest {

    public String test() {
        //echarts地址：http://echarts.baidu.com/doc/example/map.html
    	GsonOption option = new GsonOption();
    	
    	
//    	option.title().text("持证上岗人员统计").x(X.center).y(Y.top);
    	option.tooltip().trigger(Trigger.item);
    	option.legend().x(X.center).selectedMode(false).data("调度值长","调度员","监控员");
    	option.grid().x(00).y(00).x2(00).y2(00);
    	option.dataRange().orient(Orient.horizontal).min(0).max(55000).text("高","低").splitNumber(0);
    	
    	
        Map map = new Map("2011全国GDP分布");
        map.mapType("china");
        map.mapLocation().x(Position.left);
        map.selectedMode(SelectedMode.multiple);	
        ItemStyle itemStyle = new ItemStyle();
        itemStyle.normal().label().show(true);
        itemStyle.emphasis().label().show(true);
        map.itemStyle(itemStyle);
        map.data(new MapData("西藏",605.83),
        		new MapData("青海",605.83),
            	new MapData("宁夏",2102.21),
            	new MapData("海南",2522.66),
            	new MapData("甘肃",5020.37),
                new MapData("贵州", 5701.84),
                new MapData("新疆", 6610.05),
                new MapData("云南", 8893.12),
                new MapData("重庆", 10011.37),
                new MapData("吉林", 10568.83),
                new MapData("山西", 11237.55),
                new MapData("天津", 11307.28),
                new MapData("江西", 11702.82),
                new MapData("广西", 11720.87),
                new MapData("陕西", 12512.3),
                new MapData("黑龙江", 12582),
                new MapData("内蒙古", 14359.88),
                new MapData("安徽", 15300.65),
                new MapData("北京", 16251.93,true),
                new MapData("福建", 17560.18),
                new MapData("上海", 19195.69, true),
                new MapData("湖北", 19632.26),
                new MapData("湖南", 19669.56),
                new MapData("四川", 21026.68),
                new MapData("辽宁", 22226.7),
                new MapData("河北", 24515.76),
                new MapData("河南", 26931.03),
                new MapData("浙江", 32318.85),
                new MapData("山东", 45361.85),
                new MapData("江苏", 49110.27),
                new MapData("广东", 53210.28, true));
        
        Pie pie = new Pie("2011全国GDP对比");
        pie.roseType(RoseType.area);
        pie.center("document.getElementById(\"bar1\").offsetWidth - 550", 225);
        pie.radius(30, 120);
        pie.data(new PieData("调度值长",16251.93),new PieData("调度员",19195.69),new PieData("监控员",53210.28));
        
        option.series(map,pie);
//        option.exportToHtml("map.html");
//        option.view();
        return option.toString();
    }
    
    
   
    
    public static void main(String[] args) {
		new MapTest().test();
	}
    
    
    public List<MapData> getMapList(){
    	List<MapData> list = new ArrayList<MapData>();
    	list.add(new MapData("西藏",605.83));
    	list.add(new MapData("青海",605.83));
    	list.add(new MapData("宁夏",2102.21));
    	list.add(new MapData("海南",2522.66));
    	list.add(new MapData("甘肃",5020.37));
        list.add(new MapData("贵州", 5701.84));
        list.add(new MapData("新疆", 6610.05));
        list.add(new MapData("云南", 8893.12));
        list.add(new MapData("重庆", 10011.37));
        list.add(new MapData("吉林", 10568.83));
        list.add(new MapData("山西", 11237.55));
        list.add(new MapData("天津", 11307.28));
        list.add(new MapData("江西", 11702.82));
        list.add(new MapData("广西", 11720.87));
        list.add(new MapData("陕西", 12512.3));
        list.add(new MapData("黑龙江", 12582));
        list.add(new MapData("内蒙古", 14359.88));
        list.add(new MapData("安徽", 15300.65));
        list.add(new MapData("北京", 16251.93,true));
        list.add(new MapData("福建", 17560.18));
        list.add(new MapData("上海", 19195.69, true));
        list.add(new MapData("湖北", 19632.26));
        list.add(new MapData("湖南", 19669.56));
        list.add(new MapData("四川", 21026.68));
        list.add(new MapData("辽宁", 22226.7));
        list.add(new MapData("河北", 24515.76));
        list.add(new MapData("河南", 26931.03));
        list.add(new MapData("浙江", 32318.85));
        list.add(new MapData("山东", 45361.85));
        list.add(new MapData("江苏", 49110.27));
        list.add(new MapData("广东", 53210.28, true));
    	return list;
    }
}
