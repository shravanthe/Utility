package com.intellij.learn.util;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils {
	public static Object getValueFromJson(JSONObject object, String attributeName) {
		if (object == null || attributeName == null) {
			return null;
		}
		Object returnObj = null;//object.opt(attributeName);
		if(null==returnObj) {
//			JSONObject object = new JSONObject(jsonObj);
			Set<String> keySet = object.keySet();
			for (String key : keySet) {
				Object value = object.get(key);
				if(key.equalsIgnoreCase(attributeName)) {
					returnObj = value;
					break;
				}
				
				if(value.getClass().getSimpleName().equalsIgnoreCase("JSONArray")) {
					JSONArray jsArr = object.getJSONArray(key);
					for(int i=0;i<jsArr.length();i++) {
						JSONObject obj1 = jsArr.getJSONObject(i);
						Set<String> keySet1 = obj1.keySet();
						for (String key1 : keySet1) {
							if(key1.equalsIgnoreCase(attributeName)) {
								returnObj = obj1.get(key1);
//								System.out.printf("%s=%s (%s)\n", key1, value1, value1.getClass()
//										.getSimpleName());
								break;
							}
							

						}
					}
				}
			}
		}
		return returnObj;

	}
}
