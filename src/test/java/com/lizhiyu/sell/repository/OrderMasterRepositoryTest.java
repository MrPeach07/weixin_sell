package com.lizhiyu.sell.repository;

import com.lizhiyu.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by lzy on 17-8-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {


	@Autowired
	private OrderMasterRepository repository;

	private final String OPENID = "119119";

	@Test
	public void saveTest() {
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("123459");
		orderMaster.setBuyerName("李先生");
		orderMaster.setBuyerPhone("12345678910");
		orderMaster.setBuyerAddress("石油大学");
		orderMaster.setBuyerOpenid(OPENID);
		orderMaster.setOrderAmount(new BigDecimal(3.3));

		OrderMaster result = repository.save(orderMaster);
		Assert.assertNotNull(result);
	}

	@Test
	public void findByBuyerOpenid() throws Exception {
		PageRequest request = new PageRequest(0,3);//从第0页开始的

		Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
		Assert.assertNotEquals(0,result.getTotalElements());
		//System.out.println(result.getTotalElements());
	}

}