package com.lizhiyu.sell.service;

import com.lizhiyu.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */
public interface CategoryServcie {

	ProductCategory findOne(Integer categoryId);

	List<ProductCategory> findALl();

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

	ProductCategory save(ProductCategory productCategory);
}
