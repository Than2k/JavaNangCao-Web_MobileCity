package com.mobilecity.bean;

import java.util.Date;

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
public class HoaDonbean {

	private int id;
	private int maKh;
	private Date ngayMua;
	private boolean status;
	public HoaDonbean(int maKh, Date ngayMua) {
		super();
		this.maKh = maKh;
		this.ngayMua = ngayMua;
		
	}

	
}
