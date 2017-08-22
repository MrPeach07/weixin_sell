package com.lizhiyu.sell.dto;

/**
 * 购物车
 * Created by lzy on 17-8-18.
 */
public class CartDTO {

	/** 商品id. */
	private String productId;

	/** 数量. */
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
}
