package com.mobilecity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.CartBean;
import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.bo.CartBo;
import com.mobilecity.bo.LichSuBo;

@Controller
public class CartController {

	
	
	@GetMapping("/cart")
	public String index(Model model, HttpServletRequest req,RedirectAttributes redirect) {
		
		HttpSession sesion = req.getSession();
		//kiểm tra khách hàng đăng nhập chưa
		if(sesion.getAttribute("kh") == null) {
			
			return "redirect:/Account/login";
		}
		//kiểm tra giỏ hàng có trống không
		if(sesion.getAttribute("cart") == null) {
			redirect.addFlashAttribute("cartNull", "Hiện tại giỏ hàng đang trống");
			return "redirect:/mobile";
		}
		CartBo cart = (CartBo)sesion.getAttribute("cart");
		for (CartBean c : cart.list) {
			System.out.println(c.toString());
		}
		model.addAttribute("cart", cart.list);
		model.addAttribute("tongTien", cart.TongTien());
		return "mobile/cart";
	}
	
	@GetMapping("/cart/add")
	public String add( RedirectAttributes redirect, HttpServletRequest req,
			@RequestParam(name = "id", required = false, defaultValue = "0") int id,
			@RequestParam(name = "anh", required = false, defaultValue = "") String anh,
			@RequestParam(name = "ten", required = false, defaultValue = "") String ten,
			@RequestParam(name = "gia", required = false, defaultValue = "0") long gia) {
		
		HttpSession sesion = req.getSession();
		CartBo cart=null ;
		// kiểm tra giỏ hang đã tồn tại chưa
		if( sesion.getAttribute("cart") == null) {
			cart =new CartBo();
			sesion.setAttribute("cart", cart);
		}
		cart = (CartBo)sesion.getAttribute("cart");
		
		cart.Them(id, ten, anh, gia, 1);
		//lưu lại session
		sesion.setAttribute("cart", cart);
		return "redirect:/cart";
		
	}
	@GetMapping("/cart/update")
	public String update(Model model, HttpServletRequest req, 
			@RequestParam(name = "soLuong", required = false, defaultValue = "0") int soLuong,
			@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
		
		HttpSession sesion = req.getSession();
		CartBo cart = (CartBo)sesion.getAttribute("cart");
		cart.suaSoLuong(id, soLuong);
		model.addAttribute("cart", cart.list);
		model.addAttribute("tongTien", cart.TongTien());
		return "cart/update";
	}
	
	@GetMapping("/cart/delete")
	public String delete(Model model, HttpServletRequest req, 
			@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
		
		HttpSession sesion = req.getSession();
		CartBo cart = (CartBo)sesion.getAttribute("cart");
		cart.Xoa1(id);
		sesion.setAttribute("cart", cart);
		model.addAttribute("cart", cart.list);
		model.addAttribute("tongTien", cart.TongTien());
		return "cart/update";
	}
	
	@GetMapping("/cart/deleteCheck")
	public String deleteCheck(HttpServletRequest req, RedirectAttributes redirect) {
		
		HttpSession session = req.getSession();
		CartBo  cart = (CartBo)session.getAttribute("cart");
		
		String[] listMa = req.getParameterValues("check");	
		if(listMa == null || listMa.length ==0) {
			redirect.addFlashAttribute("err", "Bạn chưa chọn mặt hàng nào để xóa!");
			return "redirect:/cart";
		}
		
		for (String string : listMa) {
			System.out.println(string);
			
		}
		cart.Xoa(listMa);
		session.setAttribute("cart", cart);
		if(cart.list.size() ==0) {
			return"redirect:/mobile";
		}
		return "redirect:/cart";
		
	}
	@GetMapping("/cart/pay")
	public String pay(HttpServletRequest req, RedirectAttributes redirect) throws Exception{
		
		HttpSession session = req.getSession();
		if(session.getAttribute("kh") == null) {
			return "redirect:/Account/login";
		}
		String[] listMa = req.getParameterValues("check");	
		if(listMa == null || listMa.length ==0) {
			redirect.addFlashAttribute("err", "Bạn chưa chọn mặt hàng nào để mua hàng!");
			return "redirect:/cart";
		}
		KhachHangBean kh = (KhachHangBean)session.getAttribute("kh");
		CartBo  cart = (CartBo)session.getAttribute("cart");	
		cart.pay( listMa, kh.getId());	
		
		return "redirect:/history";
		
	}
	@GetMapping("/history")
	public String history(Model model, HttpServletRequest req, RedirectAttributes redirect) throws Exception{
		
		HttpSession session = req.getSession();
		LichSuBo lsBo = new LichSuBo();
		if(session.getAttribute("kh") == null) {
			return "redirect:/Account/login";
		}
		KhachHangBean kh = (KhachHangBean)session.getAttribute("kh");
		model.addAttribute("listLichSu", lsBo.getByKh(kh.getId()));
		return "cart/history";
		
	}
}
