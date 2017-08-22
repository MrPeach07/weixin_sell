package com.lizhiyu.sell.enums;

/**
 * Created by lzy on 17-8-18.
 */
public enum ResultEnum {

	PROCUCT_NOT_EXIST(10, "商品不存在"),

	PRODUCT_STOCK_ERROR(11, "商品库存不正确")
	;
	private Integer code;

	private String message;

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
