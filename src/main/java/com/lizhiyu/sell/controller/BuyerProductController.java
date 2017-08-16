package com.lizhiyu.sell.controller;

import com.lizhiyu.sell.VO.ProductInfoVO;
import com.lizhiyu.sell.VO.ProductVO;
import com.lizhiyu.sell.VO.ResultVO;
import com.lizhiyu.sell.dataobject.ProductCategory;
import com.lizhiyu.sell.dataobject.ProductInfo;
import com.lizhiyu.sell.service.CategoryServcie;
import com.lizhiyu.sell.service.ProductService;
import com.lizhiyu.sell.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lzy on 17-8-15.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryServcie categoryServcie;

	@GetMapping("/list")
	public ResultVO list() {
		//1.查询所有的上架商品
		List<ProductInfo> productInfoList = productService.findUpALl();

		//2.查询类目（一次性查询）
		//List<Integer> categoryTypeList = new ArrayList<>();
		//传统方法
		/*for (ProductInfo productInfo : productInfoList) {
			categoryTypeList.add(productInfo.getCategoryType());
		}*/
		//精简方法(java8,lambda)
		List<Integer> categoryTypeList = productInfoList.stream()
				.map(e -> e.getCategoryType())
				.collect(Collectors.toList());
		List<ProductCategory> productCategoryList = categoryServcie.findByCategoryTypeIn(categoryTypeList);

		//3.数据拼装
		List<ProductVO> productVOList = new ArrayList<>();
		for (ProductCategory productCategory : productCategoryList) {
			ProductVO productVO = new ProductVO();
			productVO.setCategorytype(productCategory.getCategoryType());
			productVO.setCategoryName(productCategory.getCategoryName());

			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo,productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}



		return ResultVOUtil.success(productVOList);
	}
}
