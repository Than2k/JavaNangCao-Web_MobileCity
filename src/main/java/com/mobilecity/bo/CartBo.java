package com.mobilecity.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.bean.CartBean;
import com.mobilecity.bean.HoaDonbean;
import com.mobilecity.model.CartModel;
import com.mobilecity.model.CartPayModel;

public class CartBo {

	public List<CartBean> list = new ArrayList<CartBean>();

	public void Them(int id, String ten, String anh, long gia, int soLuong) {
		System.out.println("slll:" + soLuong);
		for (CartBean h : list)
			if (h.getId() == id) {
				h.setSoLuong(h.getSoLuong() + soLuong);
				System.out.println("gia:" + h.getGia());
				return;
			}
		list.add(new CartBean(id, ten, anh, gia, soLuong));
	}

	public long TongTien() {
		long sum = 0;
		for (CartBean gioHangBean : list) {
			sum += gioHangBean.getThanhTien();
		}
		return sum;
	}

	public void Xoa1(int ma) {
//		list.removeIf(new Predicate<GioHangBean>() {
//			@Override
//			public boolean test(GioHangBean t) {
//				return t.getMaSach().equals(ma);
//			}
//		});
//		
//		list.removeIf(gh ->{
//			return gh.getMaSach().equals(ma);
//		});

		list.removeIf(gh -> gh.getId() == ma);

	}

	public void Xoa(String[] dsMa) {
		for (String ma : dsMa) {
			Xoa1(Integer.parseInt(ma));
		}
	}

	public void suaSoLuong(int ma, int sl) {
		for (CartBean gioHangBean : list) {
			if (gioHangBean.getId() == ma) {
				gioHangBean.setSoLuong(sl);
			}
		}
	}

	public void pay(String[] listma, int maKh) throws Exception {

		HoaDonBo hdBo = new HoaDonBo();
		ChiTietHoaDonBo cttBo = new ChiTietHoaDonBo();

		// tạo hóa đơn
		hdBo.add(maKh, new Date());
		// lấy max mã hóa đơn
		int maxHd = hdBo.getMaxMaHd();
		for (CartBean c : list) {
			for (String ma : listma) {
				if (Integer.parseInt(ma) == c.getId()) {
					// thêm chi tiết hóa
					cttBo.add(c.getId(), c.getSoLuong(), c.getGia(), maxHd);
				}
			}
		}
	}

	public void pay1( CartPayModel cartPay) throws Exception {

		HoaDonBo hdBo = new HoaDonBo();
		ChiTietHoaDonBo cttBo = new ChiTietHoaDonBo();

		// tạo hóa đơn
		hdBo.add(cartPay.getIdCustomer(), new Date());
		// lấy max mã hóa đơn
		int maxHd = hdBo.getMaxMaHd();
		for (CartModel c : cartPay.getCart()) {
			
			cttBo.add(c.getId(), c.getSoLuong(), c.getGia(), maxHd);
		}
	}
}
