
package com.common.echarts.json;

import com.common.echarts.Option;
import com.common.echarts.code.Magic;
import com.common.echarts.code.Tool;
import com.common.echarts.feature.MagicType;

public class GsonOption extends Option {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GsonOption(){
		   this.title("");
	}
	
	public GsonOption(boolean isNeedToolBox){
		 this.title("");
		if(isNeedToolBox){
			setToolBox();
		}
		
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
     * 导出到指定文件名
     *
     * @param fileName
     * @return 返回html路径
     */
    public String exportToHtml(String fileName) {
        return exportToHtml(System.getProperty("java.io.tmpdir"), fileName);
    }

    /**
     * 导出到指定文件名
     *
     * @param fileName
     * @return 返回html路径,测试用的！
     */
    public String exportToHtml(String filePath, String fileName) {
        return OptionUtil.exportToHtml(this, "c:/echarts", fileName);
    }
    
    
    public void setToolBox(){
        this.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);

    }

}
