package com.lizhiyu.sell.repository;

import com.lizhiyu.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lzy on 17-8-18.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

	List<OrderDetail> findByOrderId(String orderId);
}
