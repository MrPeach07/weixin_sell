package com.lizhiyu.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lzy on 17-9-4.
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

	@GetMapping("/authorize")
	public void authorize() {

	}
}