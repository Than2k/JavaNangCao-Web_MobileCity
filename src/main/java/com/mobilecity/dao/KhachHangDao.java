package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mobilecity.bean.KhachHangBean;


public class KhachHangDao {

	public KhachHangBean ktDn(String tk, String mk) throws Exception {
		KhachHangBean kh = null;
		KetNoi.ketNoi();

		String sql = "select * from KhachHang where email=? and matkhau=?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, tk);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if (rs.next() == true) {
			int maKh = rs.getInt("id");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String matkhau = rs.getString("matkhau");
			kh = new KhachHangBean(maKh, hoten, diachi, sdt, email, matkhau);
		}
		rs.close();
		KetNoi.cn.close();
		return kh;
	}
	
	public KhachHangBean getKhByEmail(String email) throws Exception {
		KhachHangBean kh = null;
		KetNoi.ketNoi();

		String sql = "select * from KhachHang where email=? ";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, email);
	
		ResultSet rs = cmd.executeQuery();
		if (rs.next() == true) {
			int maKh = rs.getInt("id");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sdt = rs.getString("sdt");
			String email1 = rs.getString("email");
			String matkhau = rs.getString("matkhau");
			kh = new KhachHangBean(maKh, hoten, diachi, sdt, email1, matkhau);
		}
		rs.close();
		KetNoi.cn.close();
		return kh;
	}
	
	public List<KhachHangBean> getAll() throws Exception {
		
		List<KhachHangBean> list = new ArrayList<KhachHangBean>();
		
		
		KetNoi.ketNoi();

		String sql = "select * from KhachHang";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			int maKh = rs.getInt("id");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String matkhau = rs.getString("matkhau");
			KhachHangBean kh = new KhachHangBean(maKh, hoten, diachi, sdt, email, matkhau);
			list.add(kh);
		}
		rs.close();
		KetNoi.cn.close();
		return list;
	}

	public int add(KhachHangBean kh) throws Exception {

		KetNoi.ketNoi();

		String sql = "insert into KhachHang(hoten, diachi, email, sdt, matkhau) values(?,?,?,?,?)";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, kh.getHoten());
		cmd.setString(2, kh.getDiachi());
		cmd.setString(3, kh.getEmail());
		cmd.setString(4, kh.getSdt());
		cmd.setString(5, kh.getMatkhau());
		
		int rs = cmd.executeUpdate();

		KetNoi.cn.close();
		return rs;
	}
	
	public int getSoLuongKh() throws Exception {

		KetNoi.ketNoi();

		String sql = "select count(id) as soLuong from KhachHang";	
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);		
		ResultSet rs =  cmd.executeQuery();
		int result = rs.next()==true ? rs.getInt("soLuong"):0;

		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public int updatePass(String pass, int idKh) throws Exception {

		KetNoi.ketNoi();

		String sql = "update KhachHang set matkhau=? where id=? ";	
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, pass);
		cmd.setInt(2, idKh);
		int result =  cmd.executeUpdate();

		KetNoi.cn.close();
		return result;
	}
}
