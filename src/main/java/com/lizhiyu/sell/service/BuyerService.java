package com.lizhiyu.sell.service;

import com.lizhiyu.sell.dto.OrderDTO;

/**
 * 买家
 * Created by lzy on 17-9-2.
 */
public interface BuyerService {

	//查询一个订单
	OrderDTO findOrderOne(String openid,String orderId);

	//取消订单
	OrderDTO cancelOrder(String openid,String orderId);
}
