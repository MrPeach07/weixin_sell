package com.lizhiyu.sell.controller;

import com.lizhiyu.sell.VO.ProductInfoVO;
import com.lizhiyu.sell.VO.ProductVO;
import com.lizhiyu.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by lzy on 17-8-15.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


	@GetMapping("/list")
	public ResultVO list() {
		ResultVO resultVO = new ResultVO();
		ProductVO productVO = new ProductVO();
		ProductInfoVO productInfoVO = new ProductInfoVO();

		productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
		resultVO.setData(Arrays.asList(productVO));
		resultVO.setCode(0);
		resultVO.setMsg("成功");



		return resultVO;
	}
}
