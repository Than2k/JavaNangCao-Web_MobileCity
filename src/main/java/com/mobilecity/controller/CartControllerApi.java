package com.mobilecity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mobilecity.bo.CartBo;
import com.mobilecity.bo.HoaDonBo;
import com.mobilecity.model.CartPayModel;
import com.mobilecity.model.HoaDonModel;

@RestController
public class CartControllerApi {

	@PostMapping("/cart-api/pay")
	public String pay(HttpServletRequest req, RedirectAttributes redirect, @RequestBody CartPayModel cartPay) throws Exception{
		
		CartBo cart = new CartBo();
		cart.pay1( cartPay);	
		System.out.println(cartPay.toString());
		return "thành công" ;
		
	}
	@GetMapping("/history-api")
	public List<HoaDonModel> history(HttpServletRequest req, RedirectAttributes redirect, 
			@RequestParam(name = "maKh", required = false, defaultValue = "0")int maKh ) throws Exception{
		
		System.out.println("lấy history:");
		HoaDonBo  hdBo = new HoaDonBo();
		return hdBo.getHdByKh(maKh);
		
	}
}
