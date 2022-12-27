package com.mobilecity.dao;

import java.sql.PreparedStatement;

public class ChiTietHoaDonDao {

	public int add(int maMobile, int soLuongMua, long gia, int maHD) throws Exception {

		KetNoi.ketNoi();

		String sql = "insert into ChiTietHoaDon(maMobile,soluongMua,gia,maHD) values(?,?,?,?)";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, maMobile);
		cmd.setInt(2, soLuongMua);
		cmd.setLong(3, gia);
		cmd.setInt(4, maHD);
		int rs = cmd.executeUpdate();

		KetNoi.cn.close();
		return rs;
	}

	public int setStatus(int maHd) throws Exception {

		KetNoi.ketNoi();

		String sql = "update ChiTietHoaDon set damua =1 where maHd = ? ";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, maHd);
		int rs = cmd.executeUpdate();

		KetNoi.cn.close();
		return rs;
	}
}
