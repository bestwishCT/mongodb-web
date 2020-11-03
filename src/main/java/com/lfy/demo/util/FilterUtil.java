package com.lfy.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.sf.json.JSONObject;


public class FilterUtil {
	public static Map listToMap1(List<JSONObject> dataList, String key, String value){
		Map map = new HashMap<>();
		try {
			map = dataList.stream().collect(Collectors.toMap(obj -> obj.getString(key), obj -> (obj.get(value) != null && !"".equals(obj.get(value)) ? obj.get(value) : "") , (obj1,obj2) -> obj1 ));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
