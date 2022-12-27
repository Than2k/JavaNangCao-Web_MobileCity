package com.mobilecity.bo;

import java.util.List;

import com.mobilecity.bean.LoaiSanPhamBean;
import com.mobilecity.dao.LoaiSanPhamDao;

public class LoaiSanPhamBo {

	LoaiSanPhamDao lDao = new LoaiSanPhamDao();
	public List<LoaiSanPhamBean> getAll() throws Exception{
		return lDao.getAll();
	}
	public static void main(String[] args) {
		try {
			for (LoaiSanPhamBean  l : new LoaiSanPhamBo().getAll()) {
				System.out.println(l.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
