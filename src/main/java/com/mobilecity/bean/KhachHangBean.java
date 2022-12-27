package com.mobilecity.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhachHangBean {

	private int id;
	private String hoten;
	private String diachi;
	private String sdt;
	private String email;
	private String matkhau;
	public KhachHangBean(String hoten, String diachi, String sdt, String email, String matkhau) {
		super();
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.matkhau = matkhau;
	}
	
}
