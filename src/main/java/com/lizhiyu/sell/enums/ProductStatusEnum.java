
package com.lizhiyu.sell.enums;

/**
 * Created by lzy on 17-8-15.
 */

/**
 * 商品状态
 */
public enum ProductStatusEnum {
	UP(0,"在架"),
	DOWN(1,"下架")
	;

	private Integer code;

	private String message;

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}