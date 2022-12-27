package com.mobilecity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.bean.MobileBean;
import com.mobilecity.bo.LoaiSanPhamBo;
import com.mobilecity.bo.MobileBo;
import com.mobilecity.common.Pagination;

@RestController
public class MobileControllerApi {

	MobileBo mBo = new MobileBo();

	@GetMapping("/mobile-api")
	public List<MobileBean> index(Model model, HttpServletRequest request) throws Exception{

		HttpSession session = request.getSession();
		KhachHangBean kh;
		if(session.getAttribute("kh") != null) {
			kh = (KhachHangBean)session.getAttribute("kh");
			System.out.println(kh.toString());
		}
		//System.out.println(mBo.getAll());
		return mBo.getAll();
	}
	
}
