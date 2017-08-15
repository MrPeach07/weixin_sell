package com.lizhiyu.sell.service;

import com.lizhiyu.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */
public interface ProductService {

	ProductInfo findOne(String productId);

	/**
	 * 查询所有在架商品列表
	 * @return
	 */
	List<ProductInfo> findUpALl();

	Page<ProductInfo> findALl(Pageable pageable);

	ProductInfo save(ProductInfo productInfo);

	//加库存

	//减库存

}
