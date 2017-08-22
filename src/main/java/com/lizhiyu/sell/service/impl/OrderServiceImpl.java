package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.OrderDetail;
import com.lizhiyu.sell.dataobject.OrderMaster;
import com.lizhiyu.sell.dataobject.ProductInfo;
import com.lizhiyu.sell.dto.CartDTO;
import com.lizhiyu.sell.dto.OrderDTO;
import com.lizhiyu.sell.enums.OrderStatusEnum;
import com.lizhiyu.sell.enums.PayStatusEnum;
import com.lizhiyu.sell.enums.ResultEnum;
import com.lizhiyu.sell.exception.SellException;
import com.lizhiyu.sell.repository.OrderDetailRepository;
import com.lizhiyu.sell.repository.OrderMasterRepository;
import com.lizhiyu.sell.service.OrderService;
import com.lizhiyu.sell.service.ProductService;
import com.lizhiyu.sell.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lzy on 17-8-18.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO) {

		String orderId = KeyUtil.getUniqueKey();
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
		//List<CartDTO> cartDTOList = new ArrayList<>();

		//1.查询商品(数量，价格)
		for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
			ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
			if (productInfo ==null ) {
				throw new SellException(ResultEnum.PROCUCT_NOT_EXIST);
			}

			//2.计算总价
			orderAmount = productInfo.getProductPrice()
					.multiply(new BigDecimal(orderDetail
					.getProductQuantity())).add(orderAmount);

			//订单详情入库
			orderDetail.setDetailId(KeyUtil.getUniqueKey());
			orderDetail.setOrderId(orderId);
			BeanUtils.copyProperties(productInfo,orderDetail);
			orderDetailRepository.save(orderDetail);

			//CartDTO cartDTO = new CartDTO(orderDetail.getDetailId(),orderDetail.getProductQuantity());
			//cartDTOList.add(cartDTO);
		}

		//3.写入订单数据库(OrderMaster和OrderDetail)
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderId(orderId);
		orderMaster.setOrderAmount(orderAmount);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);

		//4.扣库存
		List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
			new CartDTO(e.getProductId(),e.getProductQuantity())
		).collect(Collectors.toList());
		productService.decreaseStock(cartDTOList);

		return orderDTO;
	}

	@Override
	public OrderDTO findOne(String orderId) {
		return null;
	}

	@Override
	public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
		return null;
	}

	@Override
	public OrderDTO cancel(OrderDTO orderDTO) {
		return null;
	}

	@Override
	public OrderDTO finish(OrderDTO orderDTO) {
		return null;
	}

	@Override
	public OrderDTO paid(OrderDTO orderDTO) {
		return null;
	}
}