package com.lizhiyu.sell.dataobject;



import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目
 * Created by lzy on 17-8-13.
 */
@Entity
@DynamicUpdate
public class ProductCategory {

	/** 类目id. */
	@Id
	@GeneratedValue
	private Integer categoryId;

	/** 类目名字. */
	private String categoryName;

	/** 类目编号. */
	private Integer categoryType;

	public ProductCategory() {

	}

	public ProductCategory(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}


	@Override
	public String toString() {
		return "ProductCategory{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				", categoryType=" + categoryType +
				'}';
	}
}
