package com.lizhiyu.sell.service.impl;

import com.lizhiyu.sell.dataobject.ProductInfo;
import com.lizhiyu.sell.dto.CartDTO;
import com.lizhiyu.sell.enums.ProductStatusEnum;
import com.lizhiyu.sell.enums.ResultEnum;
import com.lizhiyu.sell.exception.SellException;
import com.lizhiyu.sell.repository.ProductInfoRepository;
import com.lizhiyu.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lzy on 17-8-15.
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductInfoRepository repository;

	@Override
	public ProductInfo findOne(String productId) {
		return repository.getOne(productId);
	}

	@Override
	public List<ProductInfo> findUpALl() {
		return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findALl(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return repository.save(productInfo);
	}

	@Override
	public void increaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO:cartDTOList) {
			ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PROCUCT_NOT_EXIST);
			}
			Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
			productInfo.setProductStock(result);

			repository.save(productInfo);
		}
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO: cartDTOList) {
			ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PROCUCT_NOT_EXIST);
			}

			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if (result < 0) {
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}

			productInfo.setProductStock(result);

			repository.save(productInfo);
		}
	}
}

