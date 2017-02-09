package com.ahchim.designpattern.templatemethod;

public class Frog extends TemplateMethod{
	@Override
	public void jump() {
		System.out.println("��¦ ��¦~");
	}

	@Override
	public void land() {
		System.out.println("�ٴ� �������� �����ϴ�.");
	}
}
