package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.ProductCategory;
import com.lizhiyu.sell.repository.ProductCategoryRepository;
import com.lizhiyu.sell.service.CategoryServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */

/**
 * 类目service
 */
@Service
public class CategoryServiceImpl implements CategoryServcie {

	@Autowired
	private ProductCategoryRepository repository;

	@Override
	public ProductCategory findOne(Integer categoryId) {
		return repository.getOne(categoryId);
	}

	@Override
	public List<ProductCategory> findALl() {
		return repository.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return repository.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return repository.save(productCategory);
	}
}
