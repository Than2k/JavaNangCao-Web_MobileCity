package com.mobilecity.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;import java.sql.SQLClientInfoException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.model.BinhLuan;

public class BinhLuanDao {

	
	public List<BinhLuan> getBinhLuanById(int idMobile) throws Exception{
		List<BinhLuan> result = new ArrayList<BinhLuan>();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		KetNoi.ketNoi();
		String sql ="select * from view_binhluan where idMobile =?";
		PreparedStatement cmd  = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, idMobile);
		ResultSet rs = cmd.executeQuery();
		while(rs.next() ) {
			//System.out.println(rs.getString("ngayBinhLuan"));
			//date = ff.parse(rs.getString("ngayBinhLuan"));
			int idBinhLuan =  rs.getInt("idBinhLuan");
			String hoTen =  rs.getString("hoten");
			String noiDung =  rs.getString("noiDung");
			Date ngay = ff.parse(rs.getString("ngayBinhLuan"));
			BinhLuan b = new BinhLuan(idBinhLuan, hoTen, noiDung, ff.format(ngay));
			System.out.println(ff.parse(rs.getString("ngayBinhLuan")));
			result.add(b);
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public int  add( int idKhachHang, int idMobile, String noiDung) throws Exception{
		
		KetNoi.ketNoi();
		String sql ="insert into BinhLuan(idKhachHang,idMobile, noiDung, ngayBinhLuan) "
				+ " values(?,?,?, GETDATE())";
		PreparedStatement cmd  = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, idKhachHang);
		cmd.setInt(2, idMobile);
		cmd.setString(3,noiDung);
		
		
		int rs = cmd.executeUpdate();
		KetNoi.cn.close();
		return rs;
	}
	
}
