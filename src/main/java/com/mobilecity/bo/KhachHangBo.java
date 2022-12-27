package com.mobilecity.bo;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.mobilecity.bean.KhachHangBean;
import com.mobilecity.dao.KhachHangDao;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class KhachHangBo {

	KhachHangDao khDao = new KhachHangDao();
	
	/**
	 * Kiểm tra đăng nhập khách hàng
	 * @param email
	 * @param pass
	 * @return KhachHangBean
	 * @throws Exception
	 */
	public KhachHangBean ktDn(String email, String pass)throws Exception{
		return khDao.ktDn(email,  DigestUtils.sha1Hex(pass));
	}
	
	/**
	 * Thêm mới khách hàng
	 * @param kh
	 * @return int
	 * @throws Exception
	 */
	public int add( KhachHangBean kh) throws Exception{
		kh.setMatkhau(DigestUtils.sha1Hex(kh.getMatkhau()));
		return khDao.add(kh);
	}
	
	public List<KhachHangBean> getAll( ) throws Exception{
		return khDao.getAll();
	}
	
	/**
	 * lấy về số lượng khách hàng đã đăng ký vào hệ thống
	 * @return {@link KhachHangBean}
	 * @throws Exception
	 */
	public int getSoLuongKh() throws Exception{
		return khDao.getSoLuongKh();
	}
	/**
	 * trả về thông tin khách hàng theo địa chỉ email
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public KhachHangBean getKhByEmail(String email) throws Exception{
		return khDao.getKhByEmail(email);
	}
	
	public int updatePass(String pass, int idKh) throws Exception{
		
		return khDao.updatePass( DigestUtils.sha1Hex(pass), idKh);
	}
}
