package com.ahchim.designpattern.factorymethod;

/**
 * FactoryMethod
 * 객체를 생성해주는 패턴
 * 확장한 부모클래스의 메서드를 오버라이드해서 반환해준다.
 * 
 * @author Ahchim
 */
public abstract class FactoryMethod {
	public abstract Product make();
	public abstract Packed pack(Product product);
}
