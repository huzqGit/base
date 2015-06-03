package com.common.echarts.json;

import java.util.List;

import com.common.echarts.Option;
import com.common.echarts.axis.AxisLabel;
import com.common.echarts.axis.CategoryAxis;
import com.common.echarts.axis.ValueAxis;
import com.common.echarts.code.AxisType;
import com.common.echarts.code.Magic;
import com.common.echarts.code.Tool;
import com.common.echarts.code.Trigger;
import com.common.echarts.data.MapData;
import com.common.echarts.data.NamedData;
import com.common.echarts.data.PieData;
import com.common.echarts.data.ValueAixsData;
import com.common.echarts.feature.MagicType;
import com.common.echarts.series.Bar;
import com.common.echarts.series.Line;
import com.common.echarts.series.Map;
import com.common.echarts.series.Pie;

public class EompOption extends Option {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EompOption() {
	}

	/**
	 * 在浏览器中查看
	 */
	public void view() {
		OptionUtil.browse(this);
	}

	@Override
	/**
	 * 获取toString值
	 */
	public String toString() {
		return GsonUtil.format(this);
	}

	/**
	 * 获取toPrettyString值
	 */
	public String toPrettyString() {
		return GsonUtil.prettyFormat(this);
	}

	/**
	 * 设置工具条，默认是条形和柱形的却换，如果需要新的图形请参看Magic类的的相关枚举类型
	 * 
	 */

	public void setToolBox(Magic... magics) {
		if (magics != null) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(magics).show(true), Tool.restore,
					Tool.saveAsImage);

		} else {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);

		}

	}

	/**
	 * 设置是否计算
	 * 
	 * @param iscalculable
	 */
	public void setCalculable(boolean iscalculable) {
		this.calculable(iscalculable);
	}

	/**
	 * 设置tooltip的触发点
	 * 
	 * @param trigger
	 */

	public void setTrigger(Trigger trigger) {
		this.tooltip().trigger(trigger);
	}

	/**
	 * 设置头显示图标，默认没有数据！
	 * 
	 * @param values
	 */
	public void setLegend(Object... values) {
		this.legend(values);

	}

	/**
	 * 设置横坐标
	 * 
	 * @param values
	 */
	public void setXAxis(Object... values) {
		this.xAxis(new CategoryAxis().data(values));

	}

	/**
	 * 设置纵坐标
	 * 
	 * @param values
	 */
	public void setYAxis(String formatterValue) {
		this.yAxis(new ValueAxis().axisLabel(new AxisLabel()
				.formatter(formatterValue)));
	}

	/**
	 * 
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */
	public void setDefaultFrame(Object[] xAxisData, boolean isToolBox) {
		this.title().text("");
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		this.yAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param legend
	 *            :设置图标图例
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */

	public void setDefaultFrame(Object[] xAxisData, Object[] legend,
			boolean isToolBox) {
		this.title().text("");
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		this.yAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */
	public void setDefaultFrame(String title, Object[] xAxisData,
			boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		this.yAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param legend
	 *            :设置图标图例
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 */

	public void setDefaultFrame(String title, Object[] xAxisData,
			Object[] legend, boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            :设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 * @param valueAixsDatas
	 *            :构造多个Y轴的结构
	 */
	public void setDefaultFrame(String title, Object[] xAxisData,Object[] legend,
			boolean isToolBox, List<ValueAixsData> valueAixsDatas) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		for (ValueAixsData data : valueAixsDatas) {
			ValueAxis value = new ValueAxis();
			value.name(data.getName()).type(AxisType.value).axisLabel()
					.formatter(data.getFormatter());
			this.yAxis(value);
		}
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            :设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 * @param valueAixsData
	 *            :2个Y轴的结构,一根按正常计算，一根特殊处理.
	 */

	public void setDefaultFrame(String title, Object[] xAxisData,
			boolean isToolBox, Object[] legend,ValueAixsData valueAixsData) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		this.yAxis(new ValueAxis());
		ValueAxis value = new ValueAxis();
		value.name(valueAixsData.getName()).type(AxisType.value).axisLabel()
				.formatter(valueAixsData.getFormatter());
		this.yAxis(value);
	}
	
	
	
	
	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            :设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 * @param valueAixsDatas
	 *            :构造第二根线
	 */
	public void setDefaultFrame(Object[] xAxisData,
			 Object[] legend,boolean isToolBox,ValueAixsData valueAixsData) {
		this.title().text("");
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		ValueAxis value = new ValueAxis();
		value.name(valueAixsData.getName()).type(AxisType.value).axisLabel()
				.formatter(valueAixsData.getFormatter());
		
		this.yAxis(new ValueAxis(),value);
	}
	
	

	/**
	 * @param title
	 *            设置标题
	 * @param xAxisData
	 *            设置边框，边框横坐标数组集合
	 * @param legend
	 *            设置图标图例
	 * @param formatStr
	 *            设置Y轴图标图例
	 * @param isToolBox
	 *            设置是否需要工具栏
	 */
	public void setDefaultFrame(String title, Object[] xAxisData,
			Object[] legend, String formatStr, boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.xAxis(new CategoryAxis().data(xAxisData));
		ValueAxis valueAxis = new ValueAxis();
		valueAxis.axisLabel().formatter(formatStr);
		this.yAxis(valueAxis);

	}
	
	
	/**
	 * 
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */
	public void setDefaultReverseFrame(Object[] xAxisData, boolean isToolBox) {
		this.title().text("");
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		this.xAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param legend
	 *            :设置图标图例
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */

	public void setDefaultReverseFrame(Object[] xAxisData, Object[] legend,
			boolean isToolBox) {
		this.title().text("");
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		this.xAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            ：设置是否需要工具栏
	 */
	public void setDefaultReverseFrame(String title, Object[] xAxisData,
			boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		this.xAxis(new ValueAxis());
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            ：设置边框，边框横坐标数组集合
	 * @param legend
	 *            :设置图标图例
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 */

	public void setDefaultReverseFrame(String title, Object[] xAxisData,
			Object[] legend, boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            :设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 * @param valueAixsDatas
	 *            :构造多个Y轴的结构
	 */
	public void setDefaultReverseFrame(String title, Object[] xAxisData,
			boolean isToolBox, List<ValueAixsData> valueAixsDatas) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		for (ValueAixsData data : valueAixsDatas) {
			ValueAxis value = new ValueAxis();
			value.name(data.getName()).type(AxisType.value).axisLabel()
					.formatter(data.getFormatter());
			this.xAxis(value);
		}
	}

	/**
	 * 
	 * @param title
	 *            :设置标题
	 * @param xAxisData
	 *            :设置边框，边框横坐标数组集合
	 * @param isToolBox
	 *            :设置是否需要工具栏
	 * @param valueAixsData
	 *            :2个Y轴的结构,一根按正常计算，一根特殊处理.
	 */

	public void setDefaultReverseFrame(String title, Object[] xAxisData,
			boolean isToolBox, ValueAixsData valueAixsData) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend("");
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		this.xAxis(new ValueAxis());
		ValueAxis value = new ValueAxis();
		value.name(valueAixsData.getName()).type(AxisType.value).axisLabel()
				.formatter(valueAixsData.getFormatter());
		this.xAxis(value);
	}

	/**
	 * @param title
	 *            设置标题
	 * @param xAxisData
	 *            设置边框，边框横坐标数组集合
	 * @param legend
	 *            设置图标图例
	 * @param formatStr
	 *            设置Y轴图标图例
	 * @param isToolBox
	 *            设置是否需要工具栏
	 */
	public void setDefaultReverseFrame(String title, Object[] xAxisData,
			Object[] legend, String formatStr, boolean isToolBox) {
		this.title().text(title);
		this.tooltip().trigger(Trigger.axis);
		if (isToolBox) {
			this.toolbox().show(true).feature(Tool.mark, Tool.dataView,
					new MagicType(Magic.line, Magic.bar).show(true),
					Tool.restore, Tool.saveAsImage);
		}
		this.legend(legend);
		this.calculable(true);
		this.yAxis(new CategoryAxis().data(xAxisData));
		ValueAxis valueAxis = new ValueAxis();
		valueAxis.axisLabel().formatter(formatStr);
		this.xAxis(valueAxis);

	}

	/**
	 * 创建多个bar
	 * 
	 * @param lsts
	 */
	public void createBars(List<Object>... lsts) {
		for (int i = 0; i < lsts.length; i++) {
			Bar bar = new Bar();
			bar.data().addAll(lsts[i]);
			this.series(bar);
		}
	}

	/**
	 * 创建多个line
	 * 
	 * @param lsts
	 */
	public void createLines(List<Object>... lsts) {
		for (int i = 0; i < lsts.length; i++) {
			Line bar = new Line();
			bar.data().addAll(lsts[i]);
			this.series(bar);
		}

	}

	/**
	 * 创建多个带名字的bar
	 * 
	 * @param lsts
	 */
	public void createBars(NamedData... lst) {
		for (NamedData data : lst) {
			Bar bar = new Bar(data.getName());
			bar.data().addAll(data.getDataLst());
			this.series(bar);
		}
	}

	/**
	 * 创建多个带名字的line
	 * 
	 * @param lsts
	 */

	public void createLines(NamedData... lst) {
		for (NamedData data : lst) {
			Line line = new Line(data.getName());
			line.data().addAll(data.getDataLst());
			this.series(line);
		}
	}

	public void createPie(PieData... lst) {
		Pie pie = new Pie();
		for (PieData data : lst) {
			pie.data().add(data);
		}
		this.series(pie);
	}

	public void createPies(List<PieData>... lst) {
		for (List<PieData> data : lst) {
			Pie pie = new Pie();
			pie.data().addAll(data);
			this.series(pie);
		}
	}

	public void createPie(String radius, Object[] center, PieData... lst) {
		Pie pie = new Pie();
		for (PieData data : lst) {
			pie.data().add(data);
		}
		pie.radius(radius);
		pie.center(center);
		this.series(pie);
	}

	public void createPies(String radius, Object[] center, List<PieData>... lst) {
		for (List<PieData> data : lst) {
			Pie pie = new Pie();
			pie.radius(radius);
			pie.center(center);
			pie.data().addAll(data);
			this.series(pie);
		}
	}

	public void createMap(String name, String maptype, MapData... lst) {
		Map map = new Map();
		map.name(name);
		map.mapType(maptype);
		for (MapData data : lst) {
			map.data().add(data);
		}
		this.series(map);
	}
	
	/**
	 * 特殊处理用的
	 * @param data
	 * @return
	 */

	public Bar createEchartBar(NamedData data) {
			Bar bar = new Bar(data.getName());
			bar.data().addAll(data.getDataLst());
			return bar;
	}
	
	
	public Line createEchartLine(NamedData data) {
		Line line = new Line(data.getName());
		line.data().addAll(data.getDataLst());
		return line;
}
	
	
	public Pie createEchartPie(PieData... lst) {
		Pie pie = new Pie();
		for (PieData data : lst) {
			pie.data().add(data);
		}
		return pie;
	}
	
	
	public Map createEchartMap(String name, String maptype, MapData... lst) {
		Map map = new Map();
		map.name(name);
		map.mapType(maptype);
		for (MapData data : lst) {
			map.data().add(data);
		}
		return map;
	}
	
	
	
}
