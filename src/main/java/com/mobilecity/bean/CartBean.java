package com.mobilecity.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor

@ToString
public class CartBean {

	
	private int id;
	private String ten;
	private String anh;
	private int soLuong;
	private long gia;
	private long thanhTien;
	public CartBean(int id, String ten, String anh, long gia, int soLuong) {
		super();
		this.id = id;
		this.ten = ten;
		this.anh = anh;
		this.soLuong = soLuong;
		this.gia = gia;
		this.thanhTien = gia* soLuong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhTien() {
		return gia* soLuong;
	}
	
	
	
}
