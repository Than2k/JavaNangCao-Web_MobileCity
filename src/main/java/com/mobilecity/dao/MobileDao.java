package com.mobilecity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.bean.MobileBean;




public class MobileDao {

	public List<MobileBean> getAll() throws Exception {
		List<MobileBean> result = new ArrayList<MobileBean>();
		KetNoi.ketNoi();
		String sql = "select * from DienThoai";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String ten = rs.getString("ten");
			long giaBan = rs.getLong("giaBan");
			long giaNhap = rs.getLong("giaNhap");
			int soluong = rs.getInt("soluong");
			String mausac = rs.getString("mausac");
			String cameraTruoc = rs.getString("cameraTruoc");
			String cameraSau = rs.getString("cameraSau");
			String pin = rs.getString("pin");
			String ram = rs.getString("ram");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			String cpu = rs.getString("cpu");
			String bonho = rs.getString("bonho");
			String manhinh = rs.getString("manhinh");
			String maloai = rs.getString("maloai");
			boolean baohanh = false;
			MobileBean mobile = new MobileBean(id, ten, giaBan,giaNhap, soluong, mausac, cameraTruoc, cameraSau, pin, ram, anh,
					ngaynhap, cpu, bonho, manhinh, maloai, baohanh);
			result.add(mobile);
			
			
		}
		rs.close();
		KetNoi.cn.close();
		return result;
	}
	public MobileBean getById( int ma) throws Exception {

		MobileBean mobile =null;
		KetNoi.ketNoi();
		String sql = "select * from DienThoai where id =?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1,ma );
		ResultSet rs = cmd.executeQuery();
		if(rs.next() == true) {
			//lấy thông tin điện thoại
			int id = rs.getInt("id");
			String ten = rs.getString("ten");
			long giaBan = rs.getLong("giaBan");
			long giaNhap = rs.getLong("giaNhap");
			int soluong = rs.getInt("soluong");
			String mausac = rs.getString("mausac");
			String cameraTruoc = rs.getString("cameraTruoc");
			String cameraSau = rs.getString("cameraSau");
			String pin = rs.getString("pin");
			String ram = rs.getString("ram");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			String cpu = rs.getString("cpu");
			String bonho = rs.getString("bonho");
			String manhinh = rs.getString("manhinh");
			String maloai = rs.getString("maloai");
			boolean baohanh = false;
			mobile = new MobileBean(id, ten, giaBan,giaNhap, soluong, mausac, cameraTruoc, cameraSau, pin, ram, anh,
					ngaynhap, cpu, bonho, manhinh, maloai, baohanh);
			
		}	
			
		
		rs.close();
		KetNoi.cn.close();
		return mobile;
	}
	public int countByKey(String maLoai, String value) throws Exception{
		KetNoi.ketNoi();
		String sql = "SELECT COUNT(DienThoai.id) as count \r\n" + 
					"FROM   DienThoai  inner join LoaiSanPham  on DienThoai.maloai = LoaiSanPham.id\r\n" + 
					"where ( ? = '' OR DienThoai.ten like ?  )\r\n" + 
					"And ( ? = '' OR LoaiSanPham.id = ? )";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, value);
		cmd.setString(2, value);
		cmd.setString(3, maLoai);
		cmd.setString(4, maLoai);

		ResultSet rs = cmd.executeQuery();
		rs.next();
		int r = rs.getInt("count");
		rs.close();
		KetNoi.cn.close();
		return r;
	}
	public List<MobileBean> getMobile(String ml,String value, int page, int pageSize, String sapXep) throws Exception {
		List<MobileBean> ds = new ArrayList<MobileBean>();
		
		KetNoi.ketNoi();
		String sql1 = (sapXep!= null)?(sapXep.equals("tang-dan")?"order by DienThoai.giaBan asc":"order by DienThoai.giaBan desc"):"order by DienThoai.id desc";
		String sql =  " SELECT * \r\n" + 
						"FROM   DienThoai  inner join LoaiSanPham  on DienThoai.maloai = LoaiSanPham.id  \r\n" + 
						"where ( ? = '' OR DienThoai.ten like ? ) \r\n" +
						"And ( ? = '' OR LoaiSanPham.id = ? ) \r\n" + 
						sql1+
						"  OFFSET  ? ROWS \r\n" + 
						"  FETCH NEXT ? ROWS ONLY ";
		
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, value);
		cmd.setString(2, value);
		
		cmd.setString(3, ml);
		cmd.setString(4, ml);
		cmd.setInt(5, (page ==1)?0: (page-1)* pageSize);
		cmd.setInt(6, pageSize);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) { 
			int id = rs.getInt("id");
			String ten = rs.getString("ten");
			long giaBan = rs.getLong("giaBan");
			long giaNhap = rs.getLong("giaNhap");
			int soluong = rs.getInt("soluong");
			String mausac = rs.getString("mausac");
			String cameraTruoc = rs.getString("cameraTruoc");
			String cameraSau = rs.getString("cameraSau");
			String pin = rs.getString("pin");
			String ram = rs.getString("ram");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			String cpu = rs.getString("cpu");
			String bonho = rs.getString("bonho");
			String manhinh = rs.getString("manhinh");
			String maloai = rs.getString("maloai");
			boolean baohanh = false;
			MobileBean mobile = new MobileBean(id, ten, giaBan,giaNhap, soluong, mausac, cameraTruoc, cameraSau, pin, ram, anh,
					ngaynhap, cpu, bonho, manhinh, maloai, baohanh);
			ds.add(mobile);
		}
		rs.close();
		KetNoi.cn.close();
		return ds;
	}
	
	public int add (MobileBean m) {
		int rs=0 ;
		try {
			
			KetNoi.ketNoi();
			
			String sql = "INSERT [dbo].[DienThoai] ( [ten], [giaBan], [soluong], [mausac], [cameraTruoc], [cameraSau], [pin],  "
					+ " [ram], [anh], [ngaynhap], [cpu], [bonho], [manhinh], [maloai], [baohanh] ,[giaNhap])  "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			cmd.setString(1, m.getTen());
			cmd.setLong(2, m.getGiaBan());
			cmd.setInt(3,m.getSoluong());
			cmd.setString(4, m.getMausac());
			cmd.setString(5, m.getCameraTruoc());
			cmd.setString(6, m.getCameraSau());
			cmd.setString(7, m.getPin());
			cmd.setString(8, m.getRam());
			cmd.setString(9, m.getAnh());
			cmd.setDate(10,new java.sql.Date(m.getNgaynhap().getTime()));
			cmd.setString(11, m.getCpu());
			
			cmd.setString(12, m.getBonho());
			cmd.setString(13, m.getManhinh());
			cmd.setString(14, m.getMaloai());
			cmd.setBoolean(15, m.isBaohanh());
			cmd.setLong(16, m.getGiaNhap());
			rs = cmd.executeUpdate();
			KetNoi.cn.close();
			
		} catch (Exception e) {
			
			System.out.println("looic:"+ e.getMessage());
			
		}
		return rs;
	}
	
	public int edit (MobileBean m) {
		int rs=0 ;
		try {
			
			KetNoi.ketNoi();
			
			String sql = "update DienThoai "
					+ " set ten =?, giaBan =?, soluong =?, mausac =?, cameraTruoc=?, cameraSau =?, pin=? ,  "
					+ " ram =?, anh =?, ngaynhap =?, cpu=?, bonho =?, manhinh=?, maloai=?, baohanh=? ,giaNhap=?  "
					+ " where id =?";
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			cmd.setString(1, m.getTen());
			cmd.setLong(2, m.getGiaBan());
			cmd.setInt(3,m.getSoluong());
			cmd.setString(4, m.getMausac());
			cmd.setString(5, m.getCameraTruoc());
			cmd.setString(6, m.getCameraSau());
			cmd.setString(7, m.getPin());
			cmd.setString(8, m.getRam());
			cmd.setString(9, m.getAnh());
			cmd.setDate(10,new java.sql.Date(m.getNgaynhap().getTime()));
			cmd.setString(11, m.getCpu());
			
			cmd.setString(12, m.getBonho());
			cmd.setString(13, m.getManhinh());
			cmd.setString(14, m.getMaloai());
			cmd.setBoolean(15, m.isBaohanh());
			cmd.setLong(16, m.getGiaNhap());
			cmd.setInt(17, m.getId());
			rs = cmd.executeUpdate();
			KetNoi.cn.close();
			
		} catch (Exception e) {
			
			System.out.println("looic:"+ e.getMessage());
			
		}
		return rs;
	}
	public int delete(int id) throws Exception{
		KetNoi.ketNoi();
		String sql = "delete DienThoai where id=?";
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		int rs = cmd.executeUpdate();
		
		KetNoi.cn.close();
		return rs;
	}
}
