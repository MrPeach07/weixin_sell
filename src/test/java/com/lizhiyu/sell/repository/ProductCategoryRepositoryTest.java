package com.lizhiyu.sell.repository;

import com.lizhiyu.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by lzy on 17-8-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository repository;

	@Test
	@Transactional
	public void findOneTest() {
		ProductCategory productCategory = repository.getOne(1);
		System.out.println(productCategory.toString());
	}
}