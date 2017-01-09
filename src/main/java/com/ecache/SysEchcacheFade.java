package com.ecache;



import java.util.ArrayList;
import java.util.List;

public class SysEchcacheFade {

	List<SystemCache> fade = new ArrayList<SystemCache>();

	/**
	 * 
	 * Description: 初始化缓存<br>
	 * Create By: Administrator <br>
	 * Create Date: 2016年11月19日 上午1:11:58
	 * 
	 */
	public void loadCache() {

		for (SystemCache cache : fade) {
			cache.initCache();
		}
	}





	public List<SystemCache> getFade() {
		return fade;
	}





	public void setFade(List<SystemCache> fade) {
		this.fade = fade;
	}



}
