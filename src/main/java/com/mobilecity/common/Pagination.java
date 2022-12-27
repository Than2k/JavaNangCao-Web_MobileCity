package com.mobilecity.common;

import java.util.ArrayList;
import java.util.List;



public class Pagination {
	private int page;
	private int pageSize;
	private int rowCount;
	private String searchValues;
	private String maLoai;
	private String sapXep;

	public int getPageCount() {
		int pageCount = rowCount / pageSize;
		if (rowCount % pageSize > 0)
			pageCount++;
		return pageCount;
	}

	
	public int getPage() {
		return page;
	}

	public String  getSapXep() {
		return sapXep;
	}
	public void setSapXep(String sapxep) {
		this.sapXep =sapxep;
	}
	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getRowCount() {
		return rowCount;
	}


	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}


	public String getSearchValues() {
		return searchValues;
	}


	public void setSearchValues(String searchValues) {
		this.searchValues = searchValues;
	}


	public String getMaLoai() {
		return maLoai;
	}


	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}


	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Integer> paginationResult(int pageInput) {
		List<Integer> listPage = new ArrayList<Integer>();
		int pageCount = getPageCount();
		if (pageInput <= pageCount) {// if page nhập vào <= pageCount
			if (page > 3) {
				if (page > 4 && pageCount > 2) {
					listPage.add(1);
					listPage.add(-1);
				}
				for (int i = page - 3; i <= page && i <= pageCount; i++)
					listPage.add(i);

				for (int i = page + 1; i <= page + 2 && i <= pageCount; i++)
					listPage.add(i);

				if (page + 2 < pageCount)
					listPage.add(-1);
			} else {
				for (int i = 1; i <= 6 && i <= pageCount; i++) {
					listPage.add(i);
				}
				if (pageCount > 6)
					listPage.add(-1);
			}
			return listPage;
		}else {
			return listPage;
		}
	}
}
