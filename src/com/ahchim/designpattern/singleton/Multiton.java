package com.ahchim.designpattern.singleton;

public class Multiton {
	// 생성자를 private로 막는다.
	private Multiton(){ }

	// 생성함수를 제공한다.
	public static Multiton newInstance(){
		return new Multiton();
	}
	
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
