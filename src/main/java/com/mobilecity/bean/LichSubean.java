package com.mobilecity.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor@Getter

public class LichSubean {

	private int maCT;
	private int maHD;
	private int soLuong;
	private long gia;
	private String ten;
	private String hoten;
	private boolean status;
	private String anh;
	private Date ngayMua;
}
