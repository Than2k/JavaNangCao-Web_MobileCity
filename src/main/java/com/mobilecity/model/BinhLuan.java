package com.mobilecity.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BinhLuan {

	private int id;
	private String hoTen;
	private String noiDung;
	private String ngayBinhLuan;
	
}
