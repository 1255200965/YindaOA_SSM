package com.util;

public class CalendarUtil {
	/**
	 * id 日历插件中唯一标识
	 */
	private	String id;
	
	/**
	 * id 日历插件中内容
	 */
	private String title;
	/**
	 * start   日历插件中时间
	 */
	private String start;
	
	/**
	 * color 日历插件中显示的颜色
	 */
	private String color;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
