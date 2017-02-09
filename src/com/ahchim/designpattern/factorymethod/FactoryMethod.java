package com.ahchim.designpattern.factorymethod;

/**
 * FactoryMethod
 * ��ü�� �������ִ� ����
 * Ȯ���� �θ�Ŭ������ �޼��带 �������̵��ؼ� ��ȯ���ش�.
 * 
 * @author Ahchim
 */
public abstract class FactoryMethod {
	public abstract Product make();
	public abstract Packed pack(Product product);
}
