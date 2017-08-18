package com.lizhiyu.sell.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lzy on 17-8-18.
 */
@Entity
public class OrderDetail {


	@Id
	private String detailId;

	/** 订单id. */
	private String orderId;

	/** 商品id. */
	private String productId;

	/** 商品名称. */
	private String productName;

	/** 单价. */
	private BigDecimal productPrice;

	/** 商品数量. */
	private Integer productQuantity;

	/** 商品小图. */
	private String prodctIcon;

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProdctIcon() {
		return prodctIcon;
	}

	public void setProdctIcon(String prodctIcon) {
		this.prodctIcon = prodctIcon;
	}

	public OrderDetail() {
	}
}