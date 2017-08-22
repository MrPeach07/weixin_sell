package com.lizhiyu.sell.repository;

import com.lizhiyu.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lzy on 17-8-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

	@Autowired
	private OrderDetailRepository repository;

	@Test
	public void saveTest() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("11111111");
		orderDetail.setOrderId("123459");
		orderDetail.setProdctIcon("http://xxxxx.jpg");
		orderDetail.setProductId("1111111112");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(1.2));
		orderDetail.setProductQuantity(2);

		OrderDetail result = repository.save(orderDetail);
		Assert.assertNotNull(result);
	}

	@Test
	public void findByOrderId() throws Exception {
		List<OrderDetail> orderDetailList = repository.findByOrderId("123459");
		Assert.assertNotEquals(0,orderDetailList.size());
	}

}