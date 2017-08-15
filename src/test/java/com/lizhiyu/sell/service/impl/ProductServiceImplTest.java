package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.ProductInfo;
import com.lizhiyu.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	private ProductServiceImpl productService;

	@Test
	@Transactional
	public void findOne() throws Exception {
		ProductInfo productInfo = productService.findOne("123456");
		Assert.assertEquals("123456",productInfo.getProductId());
	}

	@Test
	public void findUpALl() throws Exception {
		List<ProductInfo> productInfoList = productService.findUpALl();
		Assert.assertNotEquals(0,productInfoList.size());
	}

	@Test
	public void findALl() throws Exception {
		PageRequest request = new PageRequest(0,2);
		Page<ProductInfo> productInfoPage = productService.findALl(request);
		//System.out.println(productInfoPage.getTotalElements());
		Assert.assertNotEquals(0,productInfoPage.getTotalElements());
	}

	@Test
	public void save() throws Exception {
		ProductInfo productinfo = new ProductInfo();
		productinfo.setProductId("123457");
		productinfo.setProductName("爬爬虾");
		productinfo.setProductPrice(new BigDecimal(3.2));
		productinfo.setProductStock(100);
		productinfo.setProductDescription("很好吃的虾");
		productinfo.setProductIcon("http://xxxxx.jpg");
		productinfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
		productinfo.setCategoryType(3);

		ProductInfo result = productService.save(productinfo);
		Assert.assertNotNull(result);
	}

}