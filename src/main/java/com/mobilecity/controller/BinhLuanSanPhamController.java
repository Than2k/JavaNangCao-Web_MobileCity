package com.mobilecity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.bo.BinhLuanBo;

@Controller
public class BinhLuanSanPhamController {

	@PostMapping("/comment/add")
	public String add(Model model, HttpServletRequest req,
			@RequestParam(name = "message", required = false , defaultValue = "") String message,
			@RequestParam(name = "idMobile", required = false , defaultValue = "0") int idMobile) throws Exception{
		
		BinhLuanBo bLuanBo = new BinhLuanBo();
		HttpSession session = req.getSession();
		KhachHangBean kh =null;
		if( session.getAttribute("kh") != null) {
			kh = (KhachHangBean)session.getAttribute("kh");
		}
		bLuanBo.add(kh.getId(), idMobile, message);
		model.addAttribute("listComment", bLuanBo.getBinhLuanById(idMobile));
		return "comment/comment-add";
	}
}
