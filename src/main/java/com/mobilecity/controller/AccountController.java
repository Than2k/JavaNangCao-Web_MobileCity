package com.mobilecity.controller;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.bo.KhachHangBo;
import com.mobilecity.common.DataUntils;
import com.mobilecity.common.SendEmail;

import nl.captcha.Captcha;
import sun.security.krb5.internal.tools.Ktab;

@Controller
public class AccountController {

	KhachHangBo khBo = new KhachHangBo();

	@GetMapping("/Account/login")
	public String login(Model model, HttpServletRequest request, RedirectAttributes redirect,
			@RequestParam(name = "email", required = false, defaultValue = "") String email,
			@RequestParam(name = "pass", required = false, defaultValue = "") String pass,
			@RequestParam(name = "answer", required = false, defaultValue = "") String answer) throws Exception {

		HttpSession session = request.getSession();
		KhachHangBean kh = null;
		int count = 0;
		if (session.getAttribute("countDn") == null) {
			session.setAttribute("countDn", 0);
		} else {
			System.out.println("ddaay");
			count = (int) session.getAttribute("countDn");
		}

		if (email.equals(""))
			return "account/login";
		count++;
		System.out.println("count:"+count);
		model.addAttribute("countDn", count);
		session.setAttribute("countDn", count);
		// tạo captcha khi đăng nhập sai >3 lần
		if (count > 3) {
			if (!session.getAttribute("captcha_security").toString().equals(answer)) {// kiểm tra captcha người dùng																						// nhập vào đúng không
				model.addAttribute("err", "Mã captch không đúng!");
				return "account/login";
			} else {
				kh = khBo.ktDn(email, pass);// check tk mk trong database
				if (kh == null) { // đăng nhập không thành công
					model.addAttribute("err", "Thông tin đăng nhập sai!");
					return "account/login";
				}
			}
		} else {
			kh = khBo.ktDn(email, pass);// check tk mk trong database
			if (kh == null) { // đăng nhập không thành công
				model.addAttribute("err", "Thông tin đăng nhập sai!");
				return "account/login";
			}
		}
		// dn thành công
		// Tạo session đăng nhập
		if (session.getAttribute("kh") == null) {
			session.setAttribute("kh", kh);
		}
		session.removeAttribute("countDn");
		session.removeAttribute("captcha_security");
		return "redirect:/mobile";

	}

	@GetMapping("/Account/logout")
	public String logout(Model model, HttpServletRequest request, RedirectAttributes redirect) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute("kh");

		return "redirect:/Account/login";
	}

	@GetMapping("/Account/register")
	public String register(Model model, HttpServletRequest request,
			@RequestParam(name = "hoten", required = false, defaultValue = "") String hoten,
			@RequestParam(name = "diachi", required = false, defaultValue = "") String diachi,
			@RequestParam(name = "sdt", required = false, defaultValue = "") String sdt,
			@RequestParam(name = "email", required = false, defaultValue = "") String email,
			@RequestParam(name = "matkhau", required = false, defaultValue = "") String matkkhau,
			RedirectAttributes redirect) throws Exception {

		HttpSession session = request.getSession();

		if (hoten.equals("")) {
			return "account/register";
		}
		// tạo tài khoản
		KhachHangBean kh = new KhachHangBean(hoten, diachi, sdt, email, matkkhau);
		khBo.add(kh);
		return "redirect:/Account/login";
	}

	@RequestMapping("/Account/forget-password")
	public String forgetPassword(Model model, HttpServletRequest req, RedirectAttributes redirect,
			@RequestParam(name = "email", required = false, defaultValue = "") String email,
			@RequestParam(name = "send", required = false, defaultValue = "") String send) throws Exception {

		HttpSession session = req.getSession();
		if (!email.equals("") && send != null || !send.equals("")) {
			KhachHangBean kh = khBo.getKhByEmail(email);
			if (kh == null) {
				model.addAttribute("err", "Tài khoản này không tồn tại!");
			} else {// tài khoản tồn tại gửi mã code qua email
				// Tạo mã code dể xác thực
				session.setAttribute("kh", kh);
				// Tạo mã code dể xác thực
				String maMoi = DataUntils.genarateCode(6);
				session.setAttribute("ma", maMoi);
				// lưu thời gian hiệu lực mã
				session.setAttribute("time", java.time.LocalTime.now());
				// gửi mail

				SendEmail.send(kh.getEmail(), maMoi, kh.getHoten());

				return "redirect:/Account/verify-code";
			}
		}
		return "account/forget-password";
	}

	@RequestMapping("/Account/verify-code")
	public String verifyCode(Model model, HttpServletRequest req, RedirectAttributes redirect,
			@RequestParam(name = "ma", required = false, defaultValue = "") String ma) throws Exception {

		req.setCharacterEncoding("utf-8");

		try {
			HttpSession session = req.getSession();

			String maHienTai = null;
			KhachHangBean kh = null;
			long times = 0;
			// xử lý thời gian gửi mã xác nhận
			LocalTime timeSession = null;
			if (session.getAttribute("time") != null) {
				timeSession = (LocalTime) session.getAttribute("time");
			}
			// lấy giời gian còn lại của mã code
			if (timeSession != null)
				times = SendEmail.timeVerifyCode(timeSession);

			model.addAttribute("giay", 60 - times);// trẳ về thời gian xác thực
			// model.addAttribute("email", ư);// trả về email form xác thực

			// if thời gian xác thực mã >60 s thì thông báo mã hết hiệu lực
			if (times > 60 || times == 0) {
				model.addAttribute("err", "Mã xác nhận đã hết hiệu lực.");
				session.removeAttribute("time");
				session.removeAttribute("ma");
				model.addAttribute("giay", 0);
			} else {
				// lấy mã trong session
				if (session.getAttribute("ma") != null) {
					maHienTai = (String) session.getAttribute("ma");
				}
				if (!ma.equals("")) {
					// kiểm tra mã nhập vào có khớp không
					if (maHienTai.equals(ma)) {
						return "redirect:/Account/verify-pass";
					} else {
						model.addAttribute("err", "Mã xác thực không đúng!");
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lỗi:" + e.getMessage());
		}
		return "account/verify-code";

	}

	@RequestMapping("/Account/verify-pass")
	public String verifyPass(Model model, HttpServletRequest req, RedirectAttributes redirect,
			@RequestParam(name = "pass", required = false, defaultValue = "") String pass,
			@RequestParam(name = "passXn", required = false, defaultValue = "") String passXn,
			@RequestParam(name = "send", required = false, defaultValue = "") String send) throws Exception {

		HttpSession session = req.getSession();
		KhachHangBean kh = null;
		if (session.getAttribute("kh") != null) {
			kh = (KhachHangBean) session.getAttribute("kh");
		}
		// trường hợp nhập mk kiểm tra xem 2 mk có khớp không
		if (send.equals("send")) {
			if (!pass.equals(passXn)) {
				model.addAttribute("err", "Mật khẩu nhập lại không khớp!");
			} else {
				// thay đổi mật khẩu và trả về trang login

				khBo.updatePass(pass, kh.getId());
				// xóa session
				session.removeAttribute("kh");
				return "redirect:/Account/login";
			}
		}
		return "account/verify";

	}

}
