package com.mobilecity.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartPayModel {

	private int idCustomer;
	private List<CartModel> cart;
}
