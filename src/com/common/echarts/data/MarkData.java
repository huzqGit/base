
package com.common.echarts.data;

public class MarkData implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 构造函数
     */
	
	
    private String type;
    private Object name;
    
    public MarkData() {
        super();
    }

    
    /**
     * 构造函数,参数:name,value
     *
     * @param name
     * @param value
     */
    public MarkData(String type, Object name) {
        this.type = type;
        this.name = name;
    }


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Object getName() {
		return name;
	}


	public void setName(Object name) {
		this.name = name;
	}

    
    
    
}
