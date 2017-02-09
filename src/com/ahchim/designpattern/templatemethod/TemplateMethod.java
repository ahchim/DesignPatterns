package com.ahchim.designpattern.templatemethod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Template Method
 * 부모 클래스인 추상클래스에 구현된 함수가
 * 추상함수를 상속받은 자식 클래스가 구현한 메서드를 호출하는 패턴
 * 
 * @author Ahchim
 *
 */
public abstract class TemplateMethod {
	public void play(){
		System.out.println("플레이가 시작됩니다.");
		jump();
		land();
	}
	
	public abstract void jump();
	public abstract void land();
}
