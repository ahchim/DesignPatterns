package com.ahchim.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import com.ahchim.designpattern.factorymethod.FactoryMethod;
import com.ahchim.designpattern.factorymethod.Packed;
import com.ahchim.designpattern.factorymethod.Product;
import com.ahchim.designpattern.factorymethod.TVFactory;
import com.ahchim.designpattern.proxy.Bbs;
import com.ahchim.designpattern.proxy.Proxy;
import com.ahchim.designpattern.singleton.Multiton;
import com.ahchim.designpattern.singleton.Singleton;
import com.ahchim.designpattern.strategy.Soldier;
import com.ahchim.designpattern.strategy.Strategy;
import com.ahchim.designpattern.strategy.StrategyGun;
import com.ahchim.designpattern.strategy.StrategySheild;
import com.ahchim.designpattern.strategy.StrategySword;
import com.ahchim.designpattern.templatemethod.Frog;
import com.ahchim.designpattern.templatemethod.Rabbit;
import com.ahchim.designpattern.templatemethod.TemplateMethod;

public class MainDesignPattern {
	public static void main(String[] args){
		// 1. 싱글톤 패턴 사용해 보기
		// 결합도(의존성)는 낮추고 응집도는 높이고
		// new를 못하게 하는 것이 핵심
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		System.out.printf("single1.name = %s, single2.name = %s\n", single1.getName(), single2.getName());
		single1.setName("이아침");
		System.out.printf("single1.name = %s, single2.name = %s\n", single1.getName(), single2.getName());
		
		System.out.println();
		
		// 2. 멀티톤 패턴 사용해 보기
		// 메인함수에서 new를 선언하지 못하기 때문에 메인함수와의 의존성 제거
		Multiton multi1 = Multiton.newInstance();
		Multiton multi2 = Multiton.newInstance();
		
		System.out.printf("multi1.name = %s, multi2.name = %s\n", multi1.getName(), multi2.getName());
		multi1.setName("안이아침");
		System.out.printf("multi1.name = %s, multi2.name = %s\n", multi1.getName(), multi2.getName());
		
		System.out.println();
		
		// 3. 싱글턴에 newInstance() 함수를 추가하고 변수 single3에 적용한 후 single3.name을 출력해보세요.
		Singleton single3 = Singleton.newInstance();
		System.out.printf("single3.name = %s\n", single3.getName());
		
		System.out.println();
		
		// 4. 프록시 패턴을 사용해봅니다.
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33);
		System.out.printf("no = %d | title = %s | content = %s\n", bbs.getNo(), bbs.getTitle(), bbs.getContent());
		
		System.out.println();
		
		// 5. 템플릿 메서드 패턴을 사용합니다.
		TemplateMethod frog = new Frog();
		frog.play();
		
		TemplateMethod rabbit = new Rabbit();
		rabbit.play();
		
		// 6. 팩토리 메서드 패턴을 사용합니다.
		FactoryMethod factory = new TVFactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
		
		
		// 7. 전략패턴을 사용합니다. Main이 클라이언트
		Strategy strategy = null;
		Soldier context = new Soldier();
		
		context.status = Soldier.NEAR;
		
		// 전략패턴은 전략인터페이스를 구현한 구현체를 주입한다.
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategySheild();
		} else if(context.status == Soldier.NEAR){
			strategy = new StrategySword();
		} else {
			strategy = new StrategyGun();
		}
		
		// 전략을 컨텍스트에 넘겨서 사용한다
		context.useStrategy(strategy);
		
		// 7. 전략 CallBack 패턴을 사용합니다.
		// 전략패턴과 동일한데 전략자체를 클라이언트에서 익명객체로 생성한다.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED;
		
		// 전략 CallBack은 구현체를 사용하지 않고 익명객체를 코드상에서 구현해준다.
		if(context2.status == Soldier.ATTACKED){
			context2.useStrategy(
				// 익명객체란?
				// 변수가 없이 instance가 생성되는 것을 가리킨다.
				// 아래와 같이 변수를 지정하지 않고 바로 초기화할 수 있지만
				// 초기화된 곳 이외에서는 사용할 수 없다.
				new Strategy(){
					@Override
					public void runStrategy() {
						useSheild();
						System.out.println("막는다~");
					}
					
					private void useSheild(){ // bothHands
						System.out.println("방패를 양손으로 잡고");
					}
			});
		} else if(context2.status == Soldier.NEAR){
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("찌른다~");
				}
			});
		} else {
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("쏜다~");
				}
			});
		}
		
	}
}
