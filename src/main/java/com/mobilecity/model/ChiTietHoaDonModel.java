package com.mobilecity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChiTietHoaDonModel {

	private int id;
	private String ten;
	private String anh;
	private int soLuong;
	private long gia;
	private boolean damua;
}
