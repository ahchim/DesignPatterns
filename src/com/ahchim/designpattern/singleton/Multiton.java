package com.ahchim.designpattern.singleton;

public class Multiton {
	// �����ڸ� private�� ���´�.
	private Multiton(){ }

	// �����Լ��� �����Ѵ�.
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
