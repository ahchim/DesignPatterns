package com.ahchim.designpattern.factorymethod;

// 포장된 제품
public abstract class Packed {
	private Product product;

	public void setProduct(Product product) {
		this.product = product;
	}
}
