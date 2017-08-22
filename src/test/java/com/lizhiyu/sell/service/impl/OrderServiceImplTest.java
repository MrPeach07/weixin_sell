package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.OrderDetail;
import com.lizhiyu.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzy on 17-8-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

	@Autowired
	private OrderServiceImpl orderService;

	private final String BUYER_OPENID = "110110";

	@Test
	public void create() throws Exception {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName("李志钰");
		orderDTO.setBuyerAddress("西南石油大学");
		orderDTO.setBuyerPhone("12345678911");
		orderDTO.setBuyerOpenid(BUYER_OPENID);

		//购物车
		List<OrderDetail> orderDetailList = new ArrayList<>();
		OrderDetail o1 = new OrderDetail();
		o1.setProductId("123456");
		o1.setProductQuantity(1);
		orderDetailList.add(o1);

		orderDTO.setOrderDetailList(orderDetailList);

		OrderDTO result = orderService.create(orderDTO);
		log.info("[创建订单] result={}",result);

	}

	@Test
	public void findOne() throws Exception {

	}

	@Test
	public void findList() throws Exception {

	}

	@Test
	public void cancel() throws Exception {

	}

	@Test
	public void finish() throws Exception {

	}

	@Test
	public void paid() throws Exception {

	}

}