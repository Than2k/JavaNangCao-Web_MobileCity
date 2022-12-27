package com.mobilecity.bo;

import java.util.List;

import com.mobilecity.bean.MobileBean;
import com.mobilecity.dao.MobileDao;

public class MobileBo {

	MobileDao mDao = new MobileDao();
	public List<MobileBean> getAll() throws Exception{
		return mDao.getAll();
	}
	public int countByKey(String maloai, String value) throws Exception{
		
		return mDao.countByKey(maloai, "%"+value+"%");
	}
	public List<MobileBean> getMobile(String ml, String value, int page, int pageSize, String sapXep) throws Exception{
		return mDao.getMobile(ml, "%"+value+"%", page, pageSize, sapXep);
	}
	public MobileBean getById(int id) throws Exception{
		return mDao.getById(id);
	}
	
	
	public int add( MobileBean m ) throws Exception{
		return mDao.add(m);
	}
	/**
	 * Sửa thông tin điện thoại
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public int edit( MobileBean m ) throws Exception{
		return mDao.edit(m);
	}
	
	/**
	 * Xóa điện thoại theo mã
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete( int  id) throws Exception{
		return mDao.delete(id);
	}
//	public static void main(String[] args) {
//		try {
//			System.out.println(new MobileBo().countByKey("", "samsung"));
//			for (MobileBean m : new MobileBo().getMobile("", "samsung", 1, 20)) {
//				System.out.println(m.getId());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
