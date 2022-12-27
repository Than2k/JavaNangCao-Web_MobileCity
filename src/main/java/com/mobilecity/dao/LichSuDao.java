package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.bean.LichSubean;
import com.mobilecity.model.KhChuyenTien;

public class LichSuDao {

	public List<LichSubean> getByKh(int maKh) throws Exception {

		List<LichSubean> result = new ArrayList<LichSubean>();
		KetNoi.ketNoi();
		String sql = "select * from view_history where maKh =?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, maKh);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maCT = rs.getInt("maCt");
			int maHD = rs.getInt("maHD");
			int soLuong = rs.getInt("soLuongMua");
			long gia = rs.getLong("gia");
			String ten = rs.getString("ten");
			String hoten = rs.getString("hoten");
			boolean status = rs.getBoolean("status");
			String anh = rs.getString("anh");
			Date ngayMua = rs.getDate("ngayMua");
			result.add(new LichSubean(maCT, maHD, soLuong, gia, ten, hoten, status, anh, ngayMua));
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}

	public List<LichSubean> getConfirm() throws Exception {

		List<LichSubean> result = new ArrayList<LichSubean>();
		KetNoi.ketNoi();
		String sql = "select * from view_history where status = 0";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maCT = rs.getInt("maCt");
			int maHD = rs.getInt("maHD");
			int soLuong = rs.getInt("soLuongMua");
			long gia = rs.getLong("gia");
			String ten = rs.getString("ten");
			String hoten = rs.getString("hoten");
			boolean status = rs.getBoolean("status");
			String anh = rs.getString("anh");
			Date ngayMua = rs.getDate("ngayMua");
			result.add(new LichSubean(maCT, maHD, soLuong, gia, ten, hoten, status, anh, ngayMua));
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public List<KhChuyenTien> getCustomerPay() throws Exception {

		List<KhChuyenTien> result = new ArrayList<KhChuyenTien>();
		KetNoi.ketNoi();
		String sql = "select * from view_chuyentien";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maCT = rs.getInt("idCT");
			
			long thanhTien = rs.getLong("thanhTien");
			String sdt = rs.getString("sdt");
			String hoten = rs.getString("hoten");
			
			result.add(new KhChuyenTien(maCT, hoten, sdt, thanhTien));
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}
}
