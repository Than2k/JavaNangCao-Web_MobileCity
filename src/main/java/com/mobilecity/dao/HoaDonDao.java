package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.bean.HoaDonbean;
import com.mobilecity.model.ChiTietHoaDonModel;

public class HoaDonDao {

	public int add(int maKh, Date ngayMua) throws Exception {

		KetNoi.ketNoi();

		String sql = "insert into HoaDon(maKh,ngayMua) values(?,?)";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, maKh);
		cmd.setDate(2, new java.sql.Date(ngayMua.getTime()));

		int rs = cmd.executeUpdate();

		KetNoi.cn.close();
		return rs;
	}

	public int getMaxMaHd() throws Exception {

		KetNoi.ketNoi();

		String sql = "select top(1)hoadon.id\r\n" + "from HoaDon\r\n" + "order by hoadon.id desc";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		int max = rs.getInt(1);

		rs.close();
		KetNoi.cn.close();
		return max;
	}

	public List<HoaDonbean> getAllByKh(int maKH) throws Exception {

		List<HoaDonbean> result = new ArrayList<HoaDonbean>();
		KetNoi.ketNoi();

		String sql = "select * from HoaDon  where maKh=?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, maKH);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 int id = rs.getInt("id");
			 int maKh = rs.getInt("maKh");
			 Date ngayMua= rs.getDate("ngayMua");
			 boolean status = rs.getBoolean("status");
			 result.add(new HoaDonbean(id, maKh, ngayMua, status));
		}
			

		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public List<HoaDonbean> getAll() throws Exception {

		List<HoaDonbean> result = new ArrayList<HoaDonbean>();
		KetNoi.ketNoi();

		String sql = "select * from HoaDon";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 int id = rs.getInt("id");
			 int maKh = rs.getInt("maKh");
			 Date ngayMua= rs.getDate("ngayMua");
			 boolean status = rs.getBoolean("status");
			 result.add(new HoaDonbean(id, maKh, ngayMua, status));
		}	

		rs.close();
		KetNoi.cn.close();
		return result;
	}
	
	public List<ChiTietHoaDonModel> getCtHd( int idHd) throws Exception {

		List<ChiTietHoaDonModel> result = new ArrayList<ChiTietHoaDonModel>();
		KetNoi.ketNoi();

		String sql = "select *  from view_hoadon where maHD=?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, idHd);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 int id = rs.getInt("idCT");
			 String ten = rs.getString("ten");
			 String anh = rs.getString("anh");
			 int soLuong = rs.getInt("soLuongMua");
			 long gia= rs.getLong("gia");
			 boolean damua = rs.getBoolean("damua");
			 result.add(new ChiTietHoaDonModel(id, ten, anh, soLuong, gia, damua));
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public int setStatus( int idHd) throws Exception {

		int rs;
		KetNoi.ketNoi();

		String sql = "update HoaDon set status =1 where id =?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, idHd);
		rs = cmd.executeUpdate();
		
		KetNoi.cn.close();
		return rs;
	}
	
}
