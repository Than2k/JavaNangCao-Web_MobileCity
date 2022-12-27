package com.mobilecity.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonModel {

	private int id;
	private String ngayMua;
	private int damua;
	private List<ChiTietHoaDonModel> chiTietHD;
	public long tongTien() {
		long sum=0;
		for (ChiTietHoaDonModel ct : chiTietHD) {
			sum += ct.getGia()* ct.getSoLuong();
		}
		return sum;
	}
}
