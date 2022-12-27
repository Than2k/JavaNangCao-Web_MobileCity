package com.mobilecity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.TaiKhoanBean;

import com.mobilecity.bo.TaiKhoanBo;

@Controller
public class AdminAccountController {

	TaiKhoanBo tkBo = new TaiKhoanBo();

	@GetMapping("/admin/login")
	public String login(Model model, HttpServletRequest request, RedirectAttributes redirect) throws Exception {

		HttpSession session = request.getSession();

		if (request.getParameter("email") == null) {
			return "account/admin-login";
		} else {

			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			// gọi bo kiểm tra đăng nhập
			TaiKhoanBean admin = tkBo.ktDn(email, pass);
			if (admin != null) {
				session.setAttribute("admin", admin);
				return "redirect:/admin";
			} else {
				redirect.addFlashAttribute("err", "Thông tin đăng nhập không đúng!");
				model.addAttribute("err", "Thông tin đăng nhập không đúng!");
			}
		}
		return "account/admin-login";
	}

	@GetMapping("/admin/logout")
	public String logout(Model model, HttpServletRequest request, RedirectAttributes redirect) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute("admin");

		return "redirect:/admin/login";
	}

}
