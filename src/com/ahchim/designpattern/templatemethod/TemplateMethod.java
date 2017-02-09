package com.ahchim.designpattern.templatemethod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Template Method
 * �θ� Ŭ������ �߻�Ŭ������ ������ �Լ���
 * �߻��Լ��� ��ӹ��� �ڽ� Ŭ������ ������ �޼��带 ȣ���ϴ� ����
 * 
 * @author Ahchim
 *
 */
public abstract class TemplateMethod {
	public void play(){
		System.out.println("�÷��̰� ���۵˴ϴ�.");
		jump();
		land();
	}
	
	public abstract void jump();
	public abstract void land();
}
