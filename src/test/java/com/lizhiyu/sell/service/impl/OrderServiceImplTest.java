package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.OrderDetail;
import com.lizhiyu.sell.dto.OrderDTO;
import com.lizhiyu.sell.enums.OrderStatusEnum;
import com.lizhiyu.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

	private final String ORDER_ID = "1503378827880195084";

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
		o1.setProductQuantity(22);
		orderDetailList.add(o1);


		orderDTO.setOrderDetailList(orderDetailList);

		OrderDTO result = orderService.create(orderDTO);
		log.info("[创建订单] result={}",result);
		Assert.assertNotNull(result);
	}

	@Test
	@Transactional
	public void findOne() throws Exception {

		OrderDTO result = orderService.findOne(ORDER_ID);
		log.info("[查询单个订单] result={}", result);
		Assert.assertEquals(ORDER_ID, result.getOrderId());
	}

	@Test
	public void findList() throws Exception {
		PageRequest request = new PageRequest(0,2);
		Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
		Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
	}

	@Test
	@Transactional
	public void cancel() throws Exception {
		OrderDTO orderDTO = orderService.findOne(ORDER_ID);
		OrderDTO result = orderService.cancel(orderDTO);
		Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
	}

	@Test
	@Transactional
	public void finish() throws Exception {
		OrderDTO orderDTO = orderService.findOne(ORDER_ID);
		OrderDTO result = orderService.finish(orderDTO);
		Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
	}

	@Test
	@Transactional
	public void paid() throws Exception {
		OrderDTO orderDTO = orderService.findOne(ORDER_ID);
		OrderDTO result = orderService.paid(orderDTO);
		Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
	}

}