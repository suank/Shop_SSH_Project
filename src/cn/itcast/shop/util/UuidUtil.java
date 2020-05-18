package cn.itcast.shop.util;

import java.util.UUID;

public class UuidUtil {
	
	//返回随机UUID字符串
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
}
