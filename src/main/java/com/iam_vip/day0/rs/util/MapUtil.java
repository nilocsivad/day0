/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iam_vip.day0.logic.model.__Model;

/**
 * @author Colin
 */
public class MapUtil {

	/**
	 * 
	 */
	public MapUtil() {
	}

	@SuppressWarnings("unchecked")
	public static <V> Map<String, V> mapThem(String[] keys, V... vals) {
		if (keys == null || keys.length == 0) {
			return new HashMap<String, V>(4);
		}
		Map<String, V> map = new HashMap<String, V>(keys.length + 1);
		for (int i = 0; i < keys.length; i++) {
			if (vals.length > i) {
				map.put(keys[i], vals[i]);
			}
			else {
				map.put(keys[i], null);
			}
		}
		return map;
	}

	public static Map<String, Object> map() {
		return new HashMap<String, Object>(4);
	}

	/**
	 * @param cols "name,address,telephone"
	 */
	public static Map<String, Object> toMap1(int from, __Model obj, String cols) throws SecurityException, IllegalArgumentException, IllegalAccessException {
		return toMap2(from, obj, cols.split(","));
	}

	public static Map<String, Object> toMap2(int from, __Model obj, String... fields) throws SecurityException, IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>(fields.length + 1);
		if (obj != null && obj instanceof __Model) {
			Class<?> cls = obj.getClass();
			for (String key : fields) {
				key = key.trim();
				try {
					Field fd = cls.getDeclaredField(key);
					if (fd != null) {
						boolean accessible = fd.isAccessible();
						fd.setAccessible(true);
						Object val = fd.get(obj);
						if (val == null) {
							map.put(key, (from == 9 ? "nil" : null));
						}
						else {
							if (from == 9 && fd.getType().isAssignableFrom(Integer.class)) {
								map.put(key, val + "");
							}
							else {
								map.put(key, val);
							}
						}
						// else {
						// if (val instanceof Integer && from == 9) {
						// Integer ival = (Integer) val;
						// ival = ival == 0 ? -ival : ival;
						// map.put(key, ival);
						// }
						// else {
						// map.put(key, val);
						// }
						// }
						fd.setAccessible(accessible);
					}
				}
				catch (NoSuchFieldException e) {
					map.put(key, "");
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	/**
	 * @param cols "name,address,telephone"
	 */
	public static List<Map<String, Object>> toMapList1(int from, List<?> obj, String cols) throws SecurityException, IllegalArgumentException, IllegalAccessException {
		return toMapList2(from, obj, cols.split(","));
	}

	public static List<Map<String, Object>> toMapList2(int from, List<?> obj, String... fields) throws SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(obj.size() + 1);
		for (Object t : obj) {
			if (t instanceof __Model) {
				__Model mo = (__Model) t;
				list.add(toMap2(from, mo, fields));
			}
		}
		return list;
	}

	/**
	 * iOS null->nil 0->-0
	 * @param from 0:Android 9:iOS
	 * @param map
	 * @return
	 */
	public static List<Map<String, Object>> mapData(List<Map<String, Object>> listMap) {
		List<Map<String, Object>> rMaps = new ArrayList<>(listMap.size() + 1);
		for (Map<String, Object> map : listMap) {
			rMaps.add(mapData(map));
		}
		return rMaps;
	}

	/**
	 * iOS null->nil 0->-0
	 * @param from 0:Android 9:iOS
	 * @param map
	 * @return
	 */
	public static Map<String, Object> mapData(Map<String, Object> map) {
		for (Map.Entry<String, Object> itm : map.entrySet()) {
			if (itm.getValue() == null) {
				itm.setValue("nil");
			}
			else {
				if (itm.getValue() instanceof Integer) {
					int v = (int) itm.getValue();
					if (v == 0)
						itm.setValue("0");
				}
			}
		}
		return map;
	}

}
