package com.mobilecity.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobilecity.bean.HoaDonbean;
import com.mobilecity.dao.HoaDonDao;
import com.mobilecity.model.ChiTietHoaDonModel;
import com.mobilecity.model.HoaDonModel;



public class HoaDonBo {

	HoaDonDao hdDao = new HoaDonDao();
	
	public int add(int maKh, Date ngayMua) throws Exception{
		return hdDao.add(maKh, ngayMua);
	}
	public int getMaxMaHd() throws Exception{
		return hdDao.getMaxMaHd();
	}
	/**
	 *  lấy tất cả hóa đơn của khách hàng
	 * @param maKh
	 * @return
	 * @throws Exception
	 */
	public List<HoaDonbean> getAllByKh(int maKh) throws Exception{
		return hdDao.getAllByKh( maKh);
	}
	/**
	 * lấy tất cả hóa đơn
	 * @param maKh
	 * @return
	 * @throws Exception
	 */
	public List<HoaDonbean> getAll() throws Exception{
		return hdDao.getAll();
	}
	/**
	 * lấy chi tiết hóa đơn theo hóa đơn
	 * @param idHd
	 * @return
	 * @throws Exception
	 */
	public List<ChiTietHoaDonModel> getCtHd(int idHd) throws Exception{
		return hdDao.getCtHd(idHd);
	}
	/**
	 * set trạng thái hóa đơn
	 * @param idHd
	 * @return
	 * @throws Exception
	 */
	public int setStatus(int idHd) throws Exception{
		return hdDao.setStatus(idHd);
	}
	public List<HoaDonModel> getHdByKh(int maKh) throws Exception{
		List<HoaDonModel> listHoadon = new ArrayList<HoaDonModel>();
		HoaDonModel hd ;
		List<ChiTietHoaDonModel> ctt = null;
		for (HoaDonbean hdBean : getAllByKh(maKh)) {
			ctt = getCtHd(hdBean.getId());
			hd = new HoaDonModel();
			hd.setId(hdBean.getId());
			hd.setChiTietHD(ctt);
			hd.setDamua(hdBean.isStatus()==true?1:0);
			hd.setNgayMua(hdBean.getNgayMua().toString());
			listHoadon.add(hd);
			
		}
		return listHoadon;
	}
	public List<HoaDonModel> getAllHoaDon() throws Exception{
		List<HoaDonModel> listHoadon = new ArrayList<HoaDonModel>();
		HoaDonModel hd ;
		List<ChiTietHoaDonModel> ctt = null;
		for (HoaDonbean hdBean : getAll()) {
			ctt = getCtHd(hdBean.getId());
			hd = new HoaDonModel();
			hd.setId(hdBean.getId());
			hd.setChiTietHD(ctt);
			hd.setDamua(hdBean.isStatus()==true?1:0);
			hd.setNgayMua(hdBean.getNgayMua().toString());
			listHoadon.add(hd);
			
		}
		return listHoadon;
	}
//	public static void main(String[] args) {
//		try {
//			HoaDonBo hd = new HoaDonBo();
//			System.out.println(hd.getAllByKh(1));
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
}
