package com.mobilecity.bo;

import java.util.List;

import com.mobilecity.bean.LichSubean;
import com.mobilecity.dao.LichSuDao;
import com.mobilecity.model.KhChuyenTien;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class LichSuBo {

	LichSuDao lsDao = new LichSuDao();
	public List<LichSubean> getByKh(int maKh) throws Exception{
		return lsDao.getByKh(maKh);
	}
	
	public List<LichSubean> getConfirm() throws Exception{
		return lsDao.getConfirm();
	}
	
	/**
	 * khách hàng đã thanh toán tiền
	 * @return
	 * @throws Exception
	 */
	public List<KhChuyenTien> getCustomerPay() throws Exception{
		return lsDao.getCustomerPay();
	}
	

}
