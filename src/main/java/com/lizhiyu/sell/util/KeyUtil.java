package com.lizhiyu.sell.util;

import java.util.Random;

/**
 * Created by lzy on 17-8-18.
 */
public class KeyUtil {

	/**
	 * * 生成唯一的主键
	 * 格式：时间+随机数
	 *
	 * @return
	 */
	public static synchronized String getUniqueKey() {
		Random random = new Random();

		Integer number = random.nextInt(900000) + 100000;

		return System.currentTimeMillis() + String.valueOf(number);
	}
}
