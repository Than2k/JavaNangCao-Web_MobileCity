package com.mobilecity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.bo.KhachHangBo;
import com.mobilecity.model.Login;

@RestController
public class AcountControllerApi {

	KhachHangBo khBo = new KhachHangBo();

	@PostMapping("/account/login")
	public KhachHangBean login(Model model, HttpServletRequest request, RedirectAttributes redirect, @RequestBody Login login) throws Exception {
		
		HttpSession session = request.getSession();
		KhachHangBean kh = null;
		kh = khBo.ktDn(login.getEmail(), login.getPass());// check tk mk trong database
		System.out.println(kh);
		if (kh == null) { // đăng nhập không thành công		
			return null;
		}else {
			if(session.getAttribute("kh") == null) {
				System.out.println("dã tạo session khách hàng");
				session.setAttribute("kh", kh);
			}
			return kh;
		}
	

	}
	
	@PostMapping("/account/register")
	public String register(Model model, HttpServletRequest request, @RequestBody KhachHangBean kh,
			RedirectAttributes redirect) throws Exception {
		
		System.out.println("hjf:"+kh.toString());
		khBo.add(kh);
		return "tạo tài khoản thành công";
	}
	
	
}
