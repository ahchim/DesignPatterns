package com.ahchim.designpattern.factorymethod;

public class TVFactory extends FactoryMethod {
	@Override
	public Product make() {
		return new TV();
	}

	@Override
	public Packed pack(Product product) {
		Packed packed = new TVPacked();
		packed.setProduct(product);
		
		return packed;
	}
}
