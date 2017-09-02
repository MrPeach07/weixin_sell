package com.lizhiyu.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lizhiyu.sell.dataobject.OrderDetail;
import com.lizhiyu.sell.dto.OrderDTO;
import com.lizhiyu.sell.enums.ResultEnum;
import com.lizhiyu.sell.exception.SellException;
import com.lizhiyu.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzy on 17-8-23.
 */
@Slf4j
public class OrderFormToOrderDTOConverter {

	public static OrderDTO convert(OrderForm orderForm) {
		OrderDTO orderDTO = new OrderDTO();
		Gson gson = new Gson();

		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(),
					new TypeToken<List<OrderDetail>>() {
					}.getType());
		} catch (Exception e) {
			log.error("[对象转换]错误,json={}", orderForm.getItems());
			throw new SellException(ResultEnum.PARAM_ERROR);
		}
		orderDTO.setOrderDetailList(orderDetailList);

		return orderDTO;
	}
}
