package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mobilecity.bean.TaiKhoanBean;

public class TaiKhoanDao {

	public TaiKhoanBean ktDn(String tk, String mk) throws Exception {
		TaiKhoanBean kh = null;
		KetNoi.ketNoi();

		String sql = "select * from TaiKhoan where taiKhoan=? and matKhau=?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, tk);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if (rs.next() == true) {
			
			String hoTen = rs.getString("hoTen");
			String matKhau = rs.getString("matKhau");
			String quyen = rs.getString("quyen");
			String taiKhoan = rs.getString("taiKhoan");
			kh = new TaiKhoanBean(taiKhoan, matKhau, hoTen, quyen);
		}
		rs.close();
		KetNoi.cn.close();
		return kh;
	}
}
