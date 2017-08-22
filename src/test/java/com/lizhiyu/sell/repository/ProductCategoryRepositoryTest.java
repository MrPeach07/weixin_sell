package com.lizhiyu.sell.repository;

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
 * Created by lzy on 17-8-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
/*@TransactionConfiguration(defaultRollback = false)*/
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository repository;

	@Test
	@Transactional
	public void findOneTest() {
		ProductCategory productCategory = repository.getOne(3);
		System.out.println(productCategory.toString());
	}

	@Test
	@Transactional
	public void saveTest() {
		ProductCategory productCategory = new ProductCategory("女生最爱",2);
		ProductCategory result = repository.save(productCategory);
		Assert.assertNotNull(result);
		// Assert.assertNotEquals(null,result);
	}

	@Test
	public void findByCategoryTypeIn() {
		List<Integer> list = Arrays.asList(2,3,4);

		List<ProductCategory> result = repository.findByCategoryTypeIn(list);
		Assert.assertNotEquals(0,result.size());
	}
}