package com.intellij.learn.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
	public static Object jsonToMap(JSONObject json, String attributeName) throws JSONException {
	    Map<String, Object> retMap = new HashMap<String, Object>();
	    
	    if(json != JSONObject.NULL) {
	        retMap = toMap(json,retMap);
	    }
	    return retMap.getOrDefault(attributeName,"NA");
	}

	public static Map<String, Object> toMap(JSONObject object, Map<String, Object> map) throws JSONException {

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }
	        
	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value, map);
	        }
	        if(value instanceof Map) {
	        }else {
	        	map.put(key, value);
	        }
	        
	    }
	    return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value, new HashMap<String, Object>());
	        }
	        list.add(value);
	    }
	    return list;
	}
		

	}
