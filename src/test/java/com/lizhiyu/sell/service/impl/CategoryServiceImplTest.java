package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

	@Autowired
	private CategoryServiceImpl categoryService;

	@Test
	@Transactional
	public void findOne() throws Exception {
		ProductCategory productCategory = categoryService.findOne(4);
		Assert.assertEquals(new Integer(4),productCategory.getCategoryId());
	}

	@Test
	public void findALl() throws Exception {
		List<ProductCategory> productCategoryList = categoryService.findALl();
		Assert.assertNotEquals(0,productCategoryList.size());
	}

	@Test
	public void findByCategoryTypeIn() throws Exception {
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
		Assert.assertNotEquals(0,productCategoryList.size());
	}

	@Test
	@Transactional
	public void save() throws Exception {
		ProductCategory productCategory = new ProductCategory("男生专项",10);
		ProductCategory result = categoryService.save(productCategory);
		Assert.assertNotNull(result);
	}

}