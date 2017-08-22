package com.lizhiyu.sell.exception;

import com.lizhiyu.sell.enums.ResultEnum;

/**
 * Created by lzy on 17-8-18.
 */
public class SellException extends RuntimeException {

	private Integer code;

	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());

		this.code = resultEnum.getCode();
	}
}
