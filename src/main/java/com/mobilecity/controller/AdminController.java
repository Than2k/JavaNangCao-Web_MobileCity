package com.mobilecity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.LichSubean;
import com.mobilecity.bean.MobileBean;
import com.mobilecity.bo.ChiTietHoaDonBo;
import com.mobilecity.bo.HoaDonBo;
import com.mobilecity.bo.KhachHangBo;
import com.mobilecity.bo.LichSuBo;
import com.mobilecity.bo.LoaiSanPhamBo;
import com.mobilecity.bo.MobileBo;
import com.mobilecity.bo.ThongKeBo;
import com.mobilecity.common.Pagination;

@Controller
public class AdminController {

	 @RequestMapping("/admin")
	 public String index( Model model, HttpServletRequest req, RedirectAttributes redirect) throws Exception{
		 
		 
		 HttpSession session = req.getSession();
		 if(session.getAttribute("admin") == null) {
			 return "redirect:/admin/login";
		 }
		 ThongKeBo tkBo = new ThongKeBo();
		 
		 model.addAttribute("title", "Hệ thống Mobile City");
		 model.addAttribute("thongKe", tkBo.getThongKe());
		 model.addAttribute("slKhachHang", new KhachHangBo().getSoLuongKh());
		 return "admin/index";
	 }
	 @RequestMapping("/admin/mobile")
	 public String indexMobile(Model model, HttpServletRequest request) throws Exception{
		 
		 LoaiSanPhamBo lBo = new LoaiSanPhamBo();
			
			MobileBo mBo =new MobileBo();
			List<MobileBean> ds;
			String ml = request.getParameter("ml");
			String value = request.getParameter("value");
			int page =1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page")) ;
			}
			
			//lấy tổng số hàng
			int rowCount = mBo.countByKey((ml==null)?"":ml, (value==null)?"":value);
			System.out.println("rowcont:"+rowCount);
			//tạo serch phân trang
			Pagination pagination = new Pagination();
			pagination.setMaLoai((ml==null)?"":ml);
			pagination.setSearchValues((value == null)?"":value);
			pagination.setPage(page);
			pagination.setRowCount(rowCount);
			pagination.setPageSize(10);//1 trang 9 quyển
			//System.out.println("sl dtttttttttt:"+  pagination.getPageSize());
			ds = mBo.getMobile(pagination.getMaLoai(), pagination.getSearchValues(), page, pagination.getPageSize(),null);
			

			
			
			model.addAttribute("listPage", pagination.paginationResult(page));
			model.addAttribute("pagination", pagination);
			model.addAttribute("listMobile", ds);
			model.addAttribute("listLoai",lBo.getAll());
			model.addAttribute("title","Quản lý điện thoại");
			//request.setAttribute("slSachGio",(ghBo != null)?ghBo.list.size():0);
			//request.setAttribute("dangnhap", sesion.getAttribute("dangnhap"));
				 
		 return "admin/quanly-mobile";
	 }
	 
	 @RequestMapping("/admin/category")
	 public String indexCategoty(Model model, HttpServletRequest request) throws Exception{
		 
		 LoaiSanPhamBo lBo = new LoaiSanPhamBo();
			
			
		model.addAttribute("listLoai",lBo.getAll());
		model.addAttribute("title","Quản lý hãng điện thoại");
		//request.setAttribute("slSachGio",(ghBo != null)?ghBo.list.size():0);
		//request.setAttribute("dangnhap", sesion.getAttribute("dangnhap"));
				 
		 return "admin/quanly-loai";
	 }
	 
	 @RequestMapping("/admin/customer")
	 public String indexcustomer(Model model, HttpServletRequest request) throws Exception{
		 
		KhachHangBo khBo = new KhachHangBo();
			
			
		model.addAttribute("listCustomer", khBo.getAll());
		model.addAttribute("title","Quản lý khách hàng");
				 
	    return "admin/quanly-khachhang";
	 }
	 
	 @RequestMapping("/admin/confirm-index")
	 public String confirmIndex(Model model, HttpServletRequest request) throws Exception{
		 
		LichSuBo lBo = new LichSuBo();
		HoaDonBo hdBo = new HoaDonBo();
		model.addAttribute("listHoaDon", hdBo.getAllHoaDon());
		model.addAttribute("title","Quản lý xác nhận đơn hàng");
		return "admin/quanly-xacnhan";
		
		
	 }
	 
	 @RequestMapping("/admin/customer-pay")
	 public String customerPay(Model model, HttpServletRequest request) throws Exception{
		 
		LichSuBo lBo = new LichSuBo();
		model.addAttribute("listCustomerPay", lBo.getCustomerPay());
		model.addAttribute("title","Quản lý khách hàng chuyển tiền");
		return "admin/quanly-khachhang-chuyentien";
		
		
		
	 }
	 @RequestMapping("/admin/confirm")
	 public String confirm(Model model, HttpServletRequest request, RedirectAttributes redirect,
			 @RequestParam(name = "id", required = false, defaultValue = "") int idHd) throws Exception{
		 
		HoaDonBo hdBo = new HoaDonBo();
		ChiTietHoaDonBo ctBo = new ChiTietHoaDonBo();
		hdBo.setStatus(idHd);
		ctBo.setStatus(idHd);
		System.out.println("set chi tiet hd thành công");
		return "redirect:/admin/confirm-index";
	 }
	 
	 @RequestMapping("/admin/thongke")
	 public String thongke(Model model, HttpServletRequest request, RedirectAttributes redirect,
			 @RequestParam(name = "id", required = false, defaultValue = "") int maCT) throws Exception{
		 
		
		return "admin/quanly-thongke";
	 }
	 
	
}
