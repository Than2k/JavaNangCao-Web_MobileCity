package com.mobilecity.bo;

import java.util.List;

import com.mobilecity.dao.BinhLuanDao;
import com.mobilecity.model.BinhLuan;

public class BinhLuanBo {

	BinhLuanDao blDao = new BinhLuanDao();
	
	/**
	 * lấy tất cả bình luận theo điện thoại
	 * @param idMobile
	 * @return
	 * @throws Exception
	 */
	public List<BinhLuan> getBinhLuanById(int idMobile) throws Exception{
		return blDao.getBinhLuanById(idMobile);
	}
	
	/**
	 * Thêm mới 1 bình luận cho điện thoại
	 * @param idKhachHang
	 * @param idMobile
	 * @param noiDung
	 * @return
	 * @throws Exception
	 */
	public int  add( int idKhachHang, int idMobile, String noiDung) throws Exception{
		return blDao.add(idKhachHang, idMobile, noiDung);
	}
}
