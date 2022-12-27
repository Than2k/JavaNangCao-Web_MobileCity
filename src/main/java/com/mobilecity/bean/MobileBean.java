package com.mobilecity.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class MobileBean {
	
	private int id;
	private String ten;
	private long giaBan;
	private long giaNhap;
	private int soluong;
	private String mausac;
	private String	cameraTruoc;
	private String cameraSau;
	private String pin;
	private String ram;
	private String anh;
	private Date ngaynhap;
	private String cpu;
	private String bonho;
	private String manhinh;
	private String maloai;
	private boolean baohanh;
	public MobileBean(String ten, long giaBan, long giaNhap, int soluong, String mausac, String cameraTruoc,
			String cameraSau, String pin, String ram, String anh, Date ngaynhap, String cpu, String bonho,
			String manhinh, String maloai, boolean baohanh) {
		super();
		this.ten = ten;
		this.giaBan = giaBan;
		this.giaNhap = giaNhap;
		this.soluong = soluong;
		this.mausac = mausac;
		this.cameraTruoc = cameraTruoc;
		this.cameraSau = cameraSau;
		this.pin = pin;
		this.ram = ram;
		this.anh = anh;
		this.ngaynhap = ngaynhap;
		this.cpu = cpu;
		this.bonho = bonho;
		this.manhinh = manhinh;
		this.maloai = maloai;
		this.baohanh = baohanh;
	}
	
}
