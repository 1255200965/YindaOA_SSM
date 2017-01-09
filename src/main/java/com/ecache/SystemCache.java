package com.ecache;



import java.util.List;

import org.springframework.cache.Cache.ValueWrapper;

import com.model.YoOrder;




public interface  SystemCache {
	
	public  void put(String key,List<YoOrder> list);
	
	public  void removeCache(String key);

	public  void updateCache(String key);
	
	public  ValueWrapper get(String key);
		
	
	public  void initCache();
	


}
