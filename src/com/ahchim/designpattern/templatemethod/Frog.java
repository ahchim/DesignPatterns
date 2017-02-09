package com.ahchim.designpattern.templatemethod;

public class Frog extends TemplateMethod{
	@Override
	public void jump() {
		System.out.println("ÆúÂ¦ ÆúÂ¦~");
	}

	@Override
	public void land() {
		System.out.println("¶Ù´Ù ¹°¼ÓÀ¸·Î µé¾î°¬½À´Ï´Ù.");
	}
}
