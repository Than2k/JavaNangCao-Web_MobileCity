package com.mobilecity.bo;

import com.mobilecity.dao.ChiTietHoaDonDao;

public class ChiTietHoaDonBo {

	ChiTietHoaDonDao ctDao = new ChiTietHoaDonDao();
	
	/**
	 * thêm mới chi tiết hóa đơn
	 * @param maMobile
	 * @param soLuongMua
	 * @param gia
	 * @param maHD
	 * @return
	 * @throws Exception
	 */
	public int add(int maMobile, int soLuongMua, long gia, int maHD) throws Exception{
		return ctDao.add(maMobile, soLuongMua, gia, maHD);
	}
	
	/**
	 * set trường đã mua thành 1
	 * @param maCT
	 * @return
	 * @throws Exception
	 */
	public int setStatus(int maHd) throws Exception{
		return ctDao.setStatus(maHd);
	}
}
