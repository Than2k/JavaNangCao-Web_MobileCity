package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mobilecity.model.ThongKe;

public class ThongKeDao {

	
	public ThongKe getThongKe() throws Exception{
		ThongKe  tk =null;
		KetNoi.ketNoi();
		String sql ="select sum(giaBan*soLuongMua) as doanhThu, sum(giaNhap*soLuongMua) as giaCa, "
				+ "count(idCT) as slDonHang , sum(soLuongMua) as slMobile \r\n" + 
				"from view_thongke";
		PreparedStatement cmd  = KetNoi.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		if(rs.next() ) {
			tk = new ThongKe( rs.getLong("doanhThu"), rs.getLong("giaCa"), rs.getInt("slDonHang"), rs.getInt("slMobile"));
		}
		return tk;
	}
	
	
}
