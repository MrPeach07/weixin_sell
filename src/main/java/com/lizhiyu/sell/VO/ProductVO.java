package com.lizhiyu.sell.VO;

/**
 * Created by lzy on 17-8-15.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 商品（包含类目）
 */
public class ProductVO {


	@JsonProperty("name")
	private  String categoryName;

	@JsonProperty("type")
	private Integer categorytype;

	@JsonProperty("foods")
	private List<ProductInfoVO> productInfoVOList;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(Integer categorytype) {
		this.categorytype = categorytype;
	}

	public List<ProductInfoVO> getProductInfoVOList() {
		return productInfoVOList;
	}

	public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
		this.productInfoVOList = productInfoVOList;
	}
}
