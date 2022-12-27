package com.mobilecity.bo;

import org.apache.commons.codec.digest.DigestUtils;

import com.mobilecity.bean.TaiKhoanBean;
import com.mobilecity.dao.TaiKhoanDao;

public class TaiKhoanBo {

	TaiKhoanDao tkDao = new TaiKhoanDao();
	public TaiKhoanBean ktDn(String tk,String mk) throws Exception{
		System.out.println(DigestUtils.sha1Hex(mk));
		return tkDao.ktDn(tk, DigestUtils.sha1Hex(mk));
		
	}
}
