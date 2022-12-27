package com.mobilecity.bo;

import com.mobilecity.dao.ThongKeDao;
import com.mobilecity.model.ThongKe;

public class ThongKeBo {

	ThongKeDao tkDao = new ThongKeDao();
	
	public ThongKe getThongKe() throws Exception{
		return tkDao.getThongKe();
	}
}
