package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mobilecity.bean.LoaiSanPhamBean;

public class LoaiSanPhamDao {

	public List<LoaiSanPhamBean> getAll() throws Exception{
		List<LoaiSanPhamBean> result = new ArrayList<LoaiSanPhamBean>();
		KetNoi.ketNoi();
		String sql = "select * from LoaiSanPham";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			String tenLoai = rs.getString("tenLoai");
			result.add(new LoaiSanPhamBean(id, tenLoai));
		}
		
		rs.close();
		KetNoi.cn.close();
		return result;
	}
}
